package com.kevinmaher.x14328981.happy;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class NewMoodDialog extends DialogFragment implements View.OnClickListener {

    public static final String TAG = "NewMoodDialog";

    //widgets
    private EditText mContent;
    private TextView mCreate, mCancel;

    //variables
    private IMainActivity mIMainActivity;

    private CharSequence mood;
    private CharSequence locationInfo = "Location info: About";
    private CharSequence location = "Dublin";
    private CharSequence visibilityInfo = "Visibility info: About";
    private CharSequence username = "zebra53";
    private CharSequence usernameInfo = "Username info: About";
    private boolean isButtonClicked = false;

    private Button btnHappy;
    private Button btnIndifferent;
    private Button btnSad;

    private String moodType;

    private EditText moodContent;
    private Button btnUpdateLocationInfo;
    private Button btnUpdateVisibilityInfo;
    private Button btnUpdateUsernameInfo;

    private Switch switchUpdateLocation;
    private Switch switchUpdateVisibility;
    private Switch switchUpdateUsername;

    private TextView textPreview;
    private Button btnFace;
    private TextView textViewMoodTitle;
    private TextView textViewMoodDate;
    private TextView textViewMoodTime;
    private TextView textViewMoodLocation;
    private TextView textViewMoodUsername;
    private Button btnUpdateVisibility;
    private Button btnUpdate;
    private ImageView ivFace;

    private int DEFAULT_MSG_LENGTH_LIMIT = 20;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        int style = DialogFragment.STYLE_NORMAL;
        int theme = android.R.style.Theme_Material_Light_DialogWhenLarge; //TODO Theme_DeviceDefault_Settings ======== Theme_Material_Light_DialogWhenLarge ==== Theme_DeviceDefault_Light_DialogWhenLarge
        setStyle(style, theme);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.dialog_new_mood, container, false);
        mContent = view.findViewById(R.id.mood_content);
        mCreate = view.findViewById(R.id.create);
        mCancel = view.findViewById(R.id.cancel);

        mCancel.setOnClickListener(this);
        mCreate.setOnClickListener(this);


        btnHappy = (Button) view.findViewById(R.id.btn_update_happy);
        btnIndifferent = (Button) view.findViewById(R.id.btn_update_indifferent);
        btnSad = (Button) view.findViewById(R.id.btn_update_sad);

        getDialog().setTitle("How do you feel?");

        btnHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnHappy.setBackgroundResource(R.drawable.btn_face_happy_selected);
                btnIndifferent.setBackgroundResource(R.drawable.btn_face_indifferent_unselected);
                btnSad.setBackgroundResource(R.drawable.btn_face_sad_unselected);

                moodType = "Happy";
//                ivFace.setBackgroundResource(R.drawable.btn_face_happy_selected);

//                moodContent.setVisibility(View.VISIBLE);
//                moodContent.setTextColor(ContextCompat.getColorStateList(view.getContext(), R.color.happy));
//                //set colour of textbox underline
//                moodContent.setBackgroundTintList(ContextCompat.getColorStateList(view.getContext(), R.color.happy));
//                moodContent.setHint("What made you feel happy?");

                //update result section
//                btnFace.setBackgroundResource(R.drawable.btn_face_happy_selected);
//                textViewMoodTitle.setTextColor(ContextCompat.getColorStateList(view.getContext(), R.color.happy));
//                makeComponentsVisible();
            }
        });

        btnIndifferent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnHappy.setBackgroundResource(R.drawable.btn_face_happy_unselected);
                btnIndifferent.setBackgroundResource(R.drawable.btn_face_indifferent_selected);
                btnSad.setBackgroundResource(R.drawable.btn_face_sad_unselected);

                moodType = "Indifferent";

//                moodContent.setVisibility(View.VISIBLE);
//                moodContent.setTextColor(ContextCompat.getColorStateList(view.getContext(), R.color.indifferent));
//                moodContent.setBackgroundTintList(ContextCompat.getColorStateList(view.getContext(), R.color.indifferent));
//                moodContent.setHint("What made you feel indifferent?");

                //update result section
//                btnFace.setBackgroundResource(R.drawable.btn_face_indifferent_selected);
//                textViewMoodTitle.setTextColor(ContextCompat.getColorStateList(view.getContext(), R.color.indifferent));
//                makeComponentsVisible();
            }
        });


        btnSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnHappy.setBackgroundResource(R.drawable.btn_face_happy_unselected);
                btnIndifferent.setBackgroundResource(R.drawable.btn_face_indifferent_unselected);
                btnSad.setBackgroundResource(R.drawable.btn_face_sad_selected);

                moodType = "Sad";

//                moodContent.setVisibility(View.VISIBLE);
//                moodContent.setTextColor(ContextCompat.getColorStateList(view.getContext(), R.color.sad));
//                moodContent.setBackgroundTintList(ContextCompat.getColorStateList(view.getContext(), R.color.sad));
//                moodContent.setHint("What made you feel sad?");

                //update result section
//                btnFace.setBackgroundResource(R.drawable.btn_face_sad_selected);
//                textViewMoodTitle.setTextColor(ContextCompat.getColorStateList(view.getContext(), R.color.sad));
//                makeComponentsVisible();
            }
        });

        return view;
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.create:{
                //insert new mood
                String title = moodType;
                String content = mContent.getText().toString();

                if(!title.equals("")){
                    mIMainActivity.createNewMood(title, content);
                    getDialog().dismiss();
                }
                else{
                    Toast.makeText(getActivity(), "Enter a title", Toast.LENGTH_SHORT).show();
                }
                break;
            }

            case R.id.cancel:{
                getDialog().dismiss();
                break;
            }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mIMainActivity = (IMainActivity)getActivity();
    }
}
