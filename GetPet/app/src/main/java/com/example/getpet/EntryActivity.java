package com.example.getpet;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class EntryActivity extends AppCompatActivity {

    ImageView logo;
    TextView appName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_entry);

        logo = findViewById(R.id.logo);
        appName = findViewById(R.id.txtAppName);

        logo.setVisibility(View.GONE);
        appName.setVisibility(View.GONE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                logo.setVisibility(View.VISIBLE);
                logo.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));
            }
        },2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                appName.setVisibility(View.VISIBLE);
                appName.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));

            }
        },3000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(EntryActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },6000);

    }
}