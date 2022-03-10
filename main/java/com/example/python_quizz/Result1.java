package com.example.python_quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result1 extends AppCompatActivity {
    Button btn_tryAgain;
    TextView tv_correct_ans,tv_wrong_ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result1);
        tv_correct_ans=findViewById(R.id.tv_CorrectAnser);
        tv_wrong_ans=findViewById(R.id.tv_wrong_ans);
        btn_tryAgain=findViewById(R.id.btn_tryagain);

        String score=getIntent().getStringExtra("Score");
        String wrongAnswer=getIntent().getStringExtra("WrongAnswers");

        tv_correct_ans.setText(score);
        tv_wrong_ans.setText(wrongAnswer);

        btn_tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try_again();
            }
        });
    }
    private void try_again()
    {
        Intent intent=new Intent(Result1.this,StartQuizz.class);
        startActivity(intent);
    }
    }
