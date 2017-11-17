package com.example.mario.c4cwatchproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.Timer;

public class timeoutAfterClick extends WearableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeout_after_click);

        Intent intent = getIntent();

        new CountDownTimer(5000, 1000){
            public void onTick(long millisUntilFinished) {
                Log.i("TimeLeft", "Miliseconds remaining: " + millisUntilFinished);
            }
            public void onFinish() {
                Log.i("TimerDone", "Timer has run out. Returning to home screen.");
            }
        }.start();

        // Once the timer has run out we will notify the user to select another option
        Log.i("Vibrate", "Device is vibrating.");
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        long[] vibrationPattern = {0, 500, 50, 300};
        //-1 so we don't repeat
        final int indexInPatternToRepeat = -1;
        vibrator.vibrate(vibrationPattern, indexInPatternToRepeat);

        finish();
    }
}
