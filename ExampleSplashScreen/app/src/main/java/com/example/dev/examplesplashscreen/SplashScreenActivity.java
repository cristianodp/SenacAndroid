package com.example.dev.examplesplashscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends AppCompatActivity {


    private TextView textViewSplash;
    private ProgressBar progressBarSplash;
    private Integer SPLASH_TIME_OUT = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        textViewSplash = (TextView) findViewById(R.id.textViewSplash);
        progressBarSplash = (ProgressBar) findViewById(R.id.progressBarSplash);
        progressBarSplash.setProgress(SPLASH_TIME_OUT);
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                SPLASH_TIME_OUT += 1;
                progressBarSplash.setProgress(SPLASH_TIME_OUT);
                if (SPLASH_TIME_OUT >= 100){
                    Intent i = new Intent(SplashScreenActivity.this,LoginActivity.class);
                    startActivity(i);
                    this.cancel();
                    SplashScreenActivity.this.finish();

                }

            }
        }
        ,100
        ,1000);






    }
}
