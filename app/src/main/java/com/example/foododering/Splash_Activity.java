package com.example.foododering;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class Splash_Activity extends AppCompatActivity {

    ImageView logo,splashImg;
    View appName;
    LottieAnimationView lottieAnimationView;

//    void splash() {
//        splashImg.animate().translationY(-1600).setDuration(1000).setStartDelay(4000);
//        logo.animate().translationY(-1400).setDuration(1000).setStartDelay(4000);
//        appName.animate().translationY(-1400).setDuration(1000).setStartDelay(4000);
//        lottieAnimationView.animate().translationY(-1400).setDuration(1000).setStartDelay(4000);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        logo = findViewById(R.id.logo);
        appName = findViewById(R.id.cafe);
        lottieAnimationView = findViewById(R.id.lottie);

        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(4000);
                    splashImg.animate().translationY(-1600).setDuration(1000).setStartDelay(4000);
                    logo.animate().translationY(-1400).setDuration(1000).setStartDelay(4000);
                    appName.animate().translationY(-1400).setDuration(1000).setStartDelay(4000);
                    lottieAnimationView.animate().translationY(-1400).setDuration(1000).setStartDelay(4000);

                } catch (Exception e) {
                    e.printStackTrace();

                } finally {
                    Intent intent = new Intent(Splash_Activity.this, MainActivity.class);
                    startActivity(intent);

                }
            }
        };thread.start();
    }
}