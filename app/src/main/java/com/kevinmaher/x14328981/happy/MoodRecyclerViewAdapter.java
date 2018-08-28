package com.kevinmaher.x14328981.happy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.kevinmaher.x14328981.happy.models.Mood;


public class MoodRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final String TAG = "MoodRecyclerViewAdapter";

    private ArrayList<Mood> mMoods = new ArrayList<>();
    private IMainActivity mIMainActivity;
    private Context mContext;
    private int mSelectedMoodIndex;

    public MoodRecyclerViewAdapter(Context context, ArrayList<Mood> moods){
        mMoods = moods;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        RecyclerView.ViewHolder holder;
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.layout_mood_list_item, parent, false);
        holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position){
        if(holder instanceof ViewHolder){
            ((ViewHolder)holder).title.setText(mMoods.get(position).getTitle());

            SimpleDateFormat spf = new SimpleDateFormat("MMM dd, yyyy");
            String date = spf.format(mMoods.get(position).getTimestamp());
            ((ViewHolder)holder).timestamp.setText(date);

            ((ViewHolder)holder).content.setText(mMoods.get(position).getContent());
        }
    }

    @Override
    public int getItemCount(){return mMoods.size();}

    public void updateMood(Mood mood){
        mMoods.get(mSelectedMoodIndex).setTitle(mood.getTitle());
        mMoods.get(mSelectedMoodIndex).setContent(mood.getContent());
        notifyDataSetChanged();
    }

    public void removeMood(Mood mood){
        mMoods.remove(mood);
        notifyDataSetChanged();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
        mIMainActivity = (IMainActivity) mContext;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title,timestamp, content;

        public ViewHolder(View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.title);
            timestamp = itemView.findViewById(R.id.timestamp);
            content = itemView.findViewById(R.id.content);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){
            mSelectedMoodIndex = getAdapterPosition();
            mIMainActivity.onMoodSelected(mMoods.get(mSelectedMoodIndex));
        }
    }

}
