package com.example.health_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {

    private static final int SPLASH_TIME = 2000; // 2 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash); // ✅ This must point to the splash layout

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Navigate to LoginActivity after splash
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Close splash screen
            }
        }, SPLASH_TIME);
    }
}
