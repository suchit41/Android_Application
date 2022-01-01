package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.jar.Attributes;

public class Login extends AppCompatActivity {
Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
 Login= findViewById(R.id.Login);
 Login.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         MainActivity obj = new MainActivity();
         obj.setVisible(true);

     }
 });
    }
}