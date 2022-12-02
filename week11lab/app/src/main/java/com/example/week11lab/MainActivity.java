package com.example.week11lab;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txtUserName ;
    Button btnLogin;
    CheckBox chkRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        chkRemember = findViewById(R.id.checkBox);
        txtUserName = findViewById(R.id.txtUsername);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("apppref ", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                if(chkRemember.isChecked()) {

                    editor.putString("userName" , txtUserName.getText().toString());
                    editor.putBoolean("remember" ,chkRemember.isChecked() );

                }else{
                    editor.remove("userName");
                }
                editor.putBoolean("remember" ,chkRemember.isChecked() );
                editor.commit();
                Intent intent = new Intent(MainActivity.this,NoteActivity.class);
                startActivity(intent);

            }

        });
        SharedPreferences pref = getSharedPreferences("apppref ", Context.MODE_PRIVATE);
        String username = pref.getString("userName" , "");
        txtUserName.setText(username);

        chkRemember.setChecked(pref.getBoolean("remember" , false));
    }
}