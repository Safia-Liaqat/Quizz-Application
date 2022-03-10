package com.example.python_quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {
    private Button login;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button) findViewById(R.id.btn_login);
        signup = (Button) findViewById(R.id.btn_signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activitysignup();

            }
        });
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                activitylogin();

            }


        });
    }


    private void activitylogin(){
        Intent intent= new Intent(MainActivity.this, Login.class);
        startActivity(intent);
    }
    private void activitysignup(){
        Intent intent= new Intent(MainActivity.this, signUp.class);
        startActivity(intent);
    }



    }

