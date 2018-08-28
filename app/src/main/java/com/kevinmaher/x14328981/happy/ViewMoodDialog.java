package com.kevinmaher.x14328981.happy;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;       //import android.app.DialogFragment; //TODO Check
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kevinmaher.x14328981.happy.models.Mood;

public class ViewMoodDialog extends DialogFragment implements View.OnClickListener{

    private static final String TAG = "ViewMoodDialog";

    //widgets
    private EditText mTitle, mContent;
    private TextView mSave, mDelete, mCancel;

    //variables
    private IMainActivity mIMainActivity;
    private Mood mMood;

    public static ViewMoodDialog newInstance(Mood mood){
        ViewMoodDialog dialog = new ViewMoodDialog();

        Bundle args = new Bundle();
        args.putParcelable("mood", mood);
        dialog.setArguments(args);

        return dialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        int style = DialogFragment.STYLE_NORMAL; //TODO CUSTOMISE
        int theme = android.R.style.Theme_Material_Light_DialogWhenLarge;
        setStyle(style,theme);

        mMood = getArguments().getParcelable("mood");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.dialog_view_mood, container, false);
        mTitle = view.findViewById(R.id.mood_title);
        mContent = view.findViewById(R.id.mood_content);
        mSave = view.findViewById(R.id.save);
        mDelete = view.findViewById(R.id.delete);
        mCancel = view.findViewById(R.id.cancel);


        mSave.setOnClickListener(this);
        mDelete.setOnClickListener(this);
        mCancel.setOnClickListener(this);

        getDialog().setTitle("Edit Mood");

        setInitialProperties();

        return view;
    }

    private void setInitialProperties(){
        mTitle.setText(mMood.getTitle());
        mContent.setText(mMood.getContent());
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.save:{
                String title = mTitle.getText().toString();
                String content = mContent.getText().toString();

                if(!title.equals("")){
                    mMood.setTitle(title);
                    mMood.setContent(content);

                    mIMainActivity.updateMood(mMood);
                    getDialog().dismiss();
                }
                else{
                    Toast.makeText(getActivity(), "Enter a title", Toast.LENGTH_SHORT).show();
                }
                break;
            }

            case  R.id.delete:{
                mIMainActivity.deleteMood(mMood);
                getDialog().dismiss();
                break;
            }

            case R.id.cancel:{
                getDialog().dismiss();
                break;
            }
        }
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        mIMainActivity = (IMainActivity)getActivity();
    }

}
