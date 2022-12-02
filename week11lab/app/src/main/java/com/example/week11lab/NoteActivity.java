package com.example.week11lab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NoteActivity extends AppCompatActivity {
    Button btnSave;
    EditText txtNote;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        btnSave = findViewById(R.id.btnSave);
        txtNote = findViewById(R.id.txtMulti);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int permission = checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
                if(permission != PackageManager.PERMISSION_GRANTED){
                    String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE};
                    requestPermissions(perms,1);
                }else{
                    writeData();
                }
            }
        });
        File file =  new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),"note.txt");

        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(reader);
            String line;
            StringBuffer buffer = new StringBuffer();
            while ((line = bufReader.readLine()) != null){
                buffer.append(line).append('\n');
            }
            txtNote.setText(buffer.toString());
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void writeData() {
        File file =  new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),"note.txt");

        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            writer.write(txtNote.getText().toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==1){
            if (permissions.length == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED){
                writeData();
            }
        }

    }
}