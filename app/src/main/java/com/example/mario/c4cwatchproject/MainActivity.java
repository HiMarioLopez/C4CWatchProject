package com.example.mario.c4cwatchproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends WearableActivity {

    private TextView mTextView;

    public void happyClick(View view) {

        Log.i("ButtonPress", "User has clicked on the 'happy' button.");
        Toast.makeText(MainActivity.this, "Thanks for your feedback! Back to " +
                "studying!", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, timeoutAfterClick.class);
        startActivity(intent);
    }

    public void sadClick(View view) {

        Log.i("ButtonPress", "User has clicked on the 'sad' button.");
        Toast.makeText(MainActivity.this, "Thanks for your feedback! Let your " +
                "teacher know if there's anything they can do to help.", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, timeoutAfterClick.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text);
    }
}
