package com.ismailhakkiaydin.covid19.ui.splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.ismailhakkiaydin.covid19.R;
import com.ismailhakkiaydin.covid19.databinding.ActivitySplashScreenBinding;
import com.ismailhakkiaydin.covid19.ui.main.MainActivity;

public class SplashScreenActivity extends AppCompatActivity {

    Animation animLogo, animText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivitySplashScreenBinding activitySplashScreenBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen);

        ImageView view = activitySplashScreenBinding.imgSplashLogo;

        TextView text = activitySplashScreenBinding.textView;

        animLogo = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splash_logo_animation);
        animText = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splash_text_animation);

        view.startAnimation(animLogo);
        text.startAnimation(animText);


        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(3500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();

    }
}
