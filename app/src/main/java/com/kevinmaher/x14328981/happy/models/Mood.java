package com.kevinmaher.x14328981.happy.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.firestore.IgnoreExtraProperties;
import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

@IgnoreExtraProperties
public class Mood implements Parcelable {

    private String title;
    private String content;
    private @ServerTimestamp Date timestamp;
    private String mood_id;
    private String user_id;

    public Mood(String title, String content, Date timestamp, String mood_id, String user_id){
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
        this.mood_id = mood_id;
        this.user_id = user_id;
    }

    public Mood(){

    }

    protected Mood(Parcel in){
        title = in.readString();
        content = in.readString();
        mood_id = in.readString();
        user_id = in.readString();
    }

     public static final Creator<Mood> CREATOR = new Creator<Mood>() {
         @Override
         public Mood createFromParcel(Parcel in) {return new Mood(in);}

         @Override
         public Mood[] newArray(int size) {return new Mood[size];}
     };

    public String getUser_id() {return user_id;}

    public void setUser_id(String user_id) {this.user_id = user_id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getContent(){return content;}

    public void setContent(String content){this.content = content;}

    public Date getTimestamp(){return timestamp;}

    public void setTimestamp(Date timestamp){this.timestamp = timestamp;}

    public String getMood_id(){return mood_id;}

    public void setMood_id(String mood_id){this.mood_id = mood_id;}

    @Override
    public int describeContents(){return 0;}

    @Override
    public void writeToParcel(Parcel parcel, int i){
        parcel.writeString(title);
        parcel.writeString(content);
        parcel.writeString(mood_id);
        parcel.writeString(user_id);
    }
}
