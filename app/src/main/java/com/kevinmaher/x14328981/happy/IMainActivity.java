package com.kevinmaher.x14328981.happy;

import com.kevinmaher.x14328981.happy.models.Mood;

public interface IMainActivity {

    void createNewMood (String title, String content);

    void updateMood(Mood mood);

    void onMoodSelected(Mood mood);

    void deleteMood(Mood mood);
}
