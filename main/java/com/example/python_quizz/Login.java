package com.example.python_quizz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    Button buttonlog, buttoncreate;
    EditText Email, Password;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonlog = findViewById(R.id.buttonlog);
        buttoncreate = findViewById(R.id.buttoncreate);
        firebaseAuth = FirebaseAuth.getInstance();
        Email = findViewById(R.id.editTextTextEmailAddress);
        Password = findViewById(R.id.editTextTextPassword3);
        buttoncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, signUp.class);
                startActivity(intent);
            }
        });

        buttonlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Email.getText().toString().isEmpty()) {
                    Email.setError("Email not found");
                    return;
                }

                if (Password.getText().toString().isEmpty()) {
                    Password.setError("Password not found");
                    return;
                }
                firebaseAuth.signInWithEmailAndPassword(Email.getText().toString(), Password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        startActivity(new Intent(getApplicationContext(), StartQuizz.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


    }
@Override
    protected void onStart(){
        super.onStart();
        if (FirebaseAuth.getInstance().getCurrentUser()!=null)
        {
            startActivity(new Intent(getApplicationContext(), StartQuizz.class));
            finish();
        }
}

}
