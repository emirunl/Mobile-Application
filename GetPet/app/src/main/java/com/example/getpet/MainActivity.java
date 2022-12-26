package com.example.getpet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {
    ImageButton btnHome;
    ImageButton btnFavorite;
    ImageButton btnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        btnHome = findViewById(R.id.btnHome);

        FragmentManager fm = getSupportFragmentManager();
        btnFavorite = findViewById(R.id.btnFavorite);
        btnProfile = findViewById(R.id.btnProfile);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction().replace(R.id.fragmentContainerView,new ChoiceFragment()).commit();
            }
        });

        /*btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new choice fragment değiş yerine yenisini koy
                fm.beginTransaction().replace(R.id.fragmentContainerView,new ChoiceFragment()).commit();
            }
        });*/

        /*btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new choice fragment değiş yerine yenisini koy
                fm.beginTransaction().replace(R.id.fragmentContainerView,new ChoiceFragment()).commit();
            }
        });*/



    }
}