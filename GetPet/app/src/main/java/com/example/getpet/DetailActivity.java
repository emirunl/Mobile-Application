package com.example.getpet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DetailActivity extends AppCompatActivity {

    TextView txtInfoName, txtInfoAge, txtInfoGender, txtSize, txtLength, txtEnergy;
    ImageView detailImage;
    FloatingActionButton btnDownload;

    Bitmap bitmap;
    BitmapDrawable bitmapDrawable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        btnDownload = findViewById(R.id.btnDownload);

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

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               new Thread(new Runnable() {
                   @Override
                   public void run() {
                       bitmapDrawable = (BitmapDrawable) detailImage.getDrawable();
                       bitmap=bitmapDrawable.getBitmap();

                       FileOutputStream fileOutputStream=null;

                       File sdCard = Environment.getExternalStorageDirectory();
                       File Directory = new File(sdCard.getAbsolutePath()+ "/Download");
                       Directory.mkdir();

                       String filename = String.format("%d.jpg",System.currentTimeMillis());
                       File outfile = new File(Directory,filename);

                       //Toast.makeText(DetailActivity.this, "Image Saved", Toast.LENGTH_SHORT).show();

                       try {
                           fileOutputStream = new FileOutputStream(outfile);
                           bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
                           fileOutputStream.flush();
                           fileOutputStream.close();

                           Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                           intent.setData(Uri.fromFile(outfile));
                           sendBroadcast(intent);

                       }catch(FileNotFoundException e){
                           e.printStackTrace();
                       }catch (IOException e){
                           e.printStackTrace();
                       }
                   }
               }).start();
            }
        });

    }
}