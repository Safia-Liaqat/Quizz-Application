package com.example.python_quizz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.color.holo_green_light;

public class Questions extends AppCompatActivity {
    private  TextView optionA,optionB,optionC,optionD;
    private TextView questioner,score,question;
    private TextView checkout1,checkout2;
int mamore =0;
int wronganswer=0;
    int corrective;
int qn=1;
    Button btn_next;
    Button btn_submit;
    int CurrentQuestion, CurrentOptionA, CurrentOptionB, CurrentOptionC, CurrentOptionD;
    private answersclass[] questionBank = new answersclass[]
            {
                    new answersclass(R.string.question_1, R.string.qustion_1_A, R.string.qustion_1_B, R.string.qustion_1_C, R.string.qustion_1_D, R.string.answer_1),
                    new answersclass(R.string.question_2, R.string.qustion_2_A, R.string.qustion_2_B, R.string.qustion_2_C, R.string.qustion_2_D, R.string.answer_2),
                    new answersclass(R.string.question_3, R.string.qustion_3_A, R.string.qustion_3_B, R.string.qustion_3_C, R.string.qustion_3_D, R.string.answer_3),
                    new answersclass(R.string.question_4, R.string.qustion_4_A, R.string.qustion_4_B, R.string.qustion_4_C, R.string.qustion_4_D, R.string.answer_4),
                    new answersclass(R.string.question_5, R.string.qustion_5_A, R.string.qustion_5_B, R.string.qustion_5_C, R.string.qustion_5_D, R.string.answer_5),
                    new answersclass(R.string.question_6,R.string.qustion_6_A,R.string.qustion_6_B,R.string.qustion_6_C,R.string.qustion_6_D,R.string.answer_6),
                    new answersclass(R.string.question_7,R.string.qustion_7_A,R.string.qustion_7_B,R.string.qustion_7_C,R.string.qustion_7_D,R.string.answer_7),
                    new answersclass(R.string.question_8,R.string.qustion_8_A,R.string.qustion_8_B,R.string.qustion_8_C,R.string.qustion_8_D,R.string.answer_8),
                    new answersclass(R.string.question_9,R.string.qustion_9_A,R.string.qustion_9_B,R.string.qustion_9_C,R.string.qustion_9_D,R.string.answer_9),
                    new answersclass(R.string.question_10,R.string.qustion_10_A,R.string.qustion_10_B,R.string.qustion_10_C,R.string.qustion_10_D,R.string.answer_10)

            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        question = findViewById(R.id.Question1);
      optionA=findViewById(R.id.optionA);
        optionB=findViewById(R.id.optionB);
        optionC=findViewById(R.id.optionC);
        optionD=findViewById(R.id.optionD);

        score=findViewById(R.id.text_view_score);

        questioner =findViewById(R.id.tv_Question_number);

        checkout1=findViewById(R.id.tv_selectedoption);
        checkout2=findViewById(R.id.tv_CorrectAnser);

        btn_submit=findViewById(R.id.btn_submit);
        btn_next=findViewById(R.id.btn_next);

        CurrentQuestion = questionBank[corrective].getQuestionId();
        question.setText(CurrentQuestion);
        CurrentOptionA = questionBank[corrective].getOptionA();
        optionA.setText(CurrentOptionA);
        CurrentOptionB = questionBank[corrective].getOptionB();
        optionB.setText(CurrentOptionB);
        CurrentOptionC = questionBank[corrective].getOptionC();
        optionC.setText(CurrentOptionC);
        CurrentOptionD = questionBank[corrective].getOptionD();
        optionD.setText(CurrentOptionD);
        optionA.setOnClickListener(v -> checkAnswer(CurrentOptionA));

        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(CurrentOptionB);

            }
        });

        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(CurrentOptionC);

            }
        });

        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(CurrentOptionD);

            }
        });




        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }


        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion();
            }
        });
    }

    @SuppressLint("ResourceAsColor")
    private void checkAnswer(int userSelection) {
int correctable=questionBank[corrective].getAnswerId();
checkout1.setText(userSelection);
checkout2.setText(correctable);
 String m=checkout1.getText().toString().trim();
 String n=checkout2.getText().toString().trim();
 if (m.equals(n))
 {
     Toast.makeText(getApplicationContext(),"Right",Toast.LENGTH_SHORT).show();
     //TextView.setBackgroundColor(holo_green_light);
     mamore = mamore +1;
 }
 else {
     Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_SHORT).show();
//     wronganswer=wronganswer+1;
 }
    }

    private void submit()
    {
        Intent submit=new Intent(Questions.this,Result1.class);
        startActivity(submit);

}

    private void updateQuestion() {
        corrective = (corrective + 1) % questionBank.length;
        if (corrective==0)
        {
            AlertDialog.Builder alert=new AlertDialog.Builder(this);
            alert.setTitle("Quizz Over");
            alert.setCancelable(false);
            alert.setMessage("Your Score"+ mamore+"Points");
            alert.setPositiveButton("close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.setNegativeButton("No ", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mamore=0;
                    qn=1;
                    score.setText("Score"+ mamore +"/"+questionBank.length);
                    questioner.setText(qn+ "/" +questionBank.length+"Question");

                }
            });
            alert.show();
        }

        CurrentQuestion = questionBank[corrective].getQuestionId();
        question.setText(CurrentQuestion);
        CurrentOptionA = questionBank[corrective].getOptionA();
        optionA.setText(CurrentOptionA);
        CurrentOptionB = questionBank[corrective].getOptionB();
        optionB.setText(CurrentOptionB);
        CurrentOptionC = questionBank[corrective].getOptionC();
        optionC.setText(CurrentOptionC);
        CurrentOptionD = questionBank[corrective].getOptionD();
        optionD.setText(CurrentOptionD);
        qn=qn+1;
        if (qn<=questionBank.length)
        {
            questioner.setText(qn+ "/" +questionBank.length+"Question");

        }
        score.setText("Score"+ mamore +"/"+questionBank.length);


    }

}