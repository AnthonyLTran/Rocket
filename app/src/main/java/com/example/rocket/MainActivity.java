package com.example.rocket;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button start;
    private Button stop;
    private ImageView rocket;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView rocketImage = findViewById(R.id.rocket);
        rocketImage.setBackgroundResource(R.drawable.flying_rocket);
        AnimationDrawable rocketAnimation = (AnimationDrawable) rocketImage.getBackground();

        rocketImage.setOnClickListener(view -> {
            if (rocketAnimation.isRunning()) {
                rocketAnimation.stop();
            }
            else {
                rocketAnimation.start();
            }
        });

    }

    public void startRocket(View view) {
        ImageView rocketImage = findViewById(R.id.rocket);
        rocketImage.setBackgroundResource(R.drawable.flying_rocket);
        AnimationDrawable rocketAnimation = (AnimationDrawable) rocketImage.getBackground();
        rocketAnimation.start();

        Animation rocketAnim = AnimationUtils.loadAnimation(this, R.anim.fly_rocket);
        rocketImage.startAnimation(rocketAnim);
    }

    public void stopRocket(View view) {
        ImageView rocketImage = findViewById(R.id.rocket);
        rocketImage.setBackgroundResource(R.drawable.flying_rocket);
        AnimationDrawable rocketAnimation = (AnimationDrawable) rocketImage.getBackground();
        rocketAnimation.stop();
        rocketImage.clearAnimation();
    }
}