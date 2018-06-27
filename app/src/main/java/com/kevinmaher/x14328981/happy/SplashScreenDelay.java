package com.kevinmaher.x14328981.happy;

import android.app.Application;
import android.os.SystemClock;

/**
 * Created by x14328981 on 23/11/2017.
 */

public class SplashScreenDelay extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(2000);
    }
}
