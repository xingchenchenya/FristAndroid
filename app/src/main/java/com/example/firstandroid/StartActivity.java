package com.example.firstandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {
    private static final long mDelay = 20000L;
    TextView welcome;
    TextView bye;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        bye =findViewById(R.id.bye);
        welcome =findViewById(R.id.welcome);
        welcome.animate().translationX(800).setDuration(2000).setStartDelay(10);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent turn= new Intent(getApplicationContext(), LogInActivity.class);
                startActivity(turn);
            }
        },2000);


    }
}


