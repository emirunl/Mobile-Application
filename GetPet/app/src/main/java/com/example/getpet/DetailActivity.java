package com.example.getpet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    TextView txtInfoName, txtInfoAge, txtInfoGender, txtSize, txtLength, txtEnergy;
    ImageView detailImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailImage = findViewById(R.id.detailImage);

        txtInfoName = findViewById(R.id.txtInfoName);
        txtInfoAge = findViewById(R.id.txtInfoAge);
        txtInfoGender = findViewById(R.id.txtInfoGender);
        txtSize = findViewById(R.id.txtSize);
        txtLength = findViewById(R.id.txtLength);
        txtEnergy = findViewById(R.id.txtEnergy);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){

            Glide.with(this).load(bundle.getString("Image")).into(detailImage);

            txtInfoName.setText("Name: " + bundle.getString("Name"));
            txtInfoAge.setText("Age: " + bundle.getString("Age"));
            txtInfoGender.setText("Gender: " + bundle.getString("Gender"));
            txtSize.setText("Size: " + bundle.getString("Size"));
            txtLength.setText("Coat Length: " + bundle.getString("Length"));
            txtEnergy.setText("Energy: " + bundle.getString("Energy"));

        }

    }
}