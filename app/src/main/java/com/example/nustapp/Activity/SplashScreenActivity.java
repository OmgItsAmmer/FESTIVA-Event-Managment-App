package com.example.nustapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.example.nustapp.R;
import com.example.nustapp.login.Login;

public class SplashScreenActivity extends AppCompatActivity {

    private ImageView splashBg;
    private ImageView splashLogo;
    private TextView splashAppName;
    private LottieAnimationView loadingAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        initializeViews();
        startAnimations();
    }

    private void initializeViews() {
        splashBg = findViewById(R.id.splashbg);
        splashLogo = findViewById(R.id.splashlogo);
        loadingAnim = findViewById(R.id.loadinganimation);
        splashAppName = findViewById(R.id.splashappname);
    }

    private void startAnimations() {
        splashBg.animate().translationY(-3000).setDuration(1000).setStartDelay(4000);
        splashLogo.animate().translationY(-3000).setDuration(1000).setStartDelay(4000);
        splashAppName.animate().translationY(-3000).setDuration(1000).setStartDelay(4000);
        loadingAnim.animate().translationY(-3000).setDuration(1000).setStartDelay(4000);


        splashBg.animate().withEndAction(() -> navigateToLogin()).start();
    }

    private void navigateToLogin() {
        Intent intent = new Intent(SplashScreenActivity.this, Login.class);
        startActivity(intent);

        finish();
    }
}
