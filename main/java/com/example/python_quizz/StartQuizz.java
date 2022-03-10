package com.example.python_quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartQuizz extends AppCompatActivity {
    Button start_Quizz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quizz);
        start_Quizz = findViewById(R.id.btn_start_quizz);
        start_Quizz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start_Quizz_fucnt();
            }
        });
    }

    private void start_Quizz_fucnt() {
        Intent intent = new Intent(StartQuizz.this, Questions.class);
        startActivity(intent);
    }
}