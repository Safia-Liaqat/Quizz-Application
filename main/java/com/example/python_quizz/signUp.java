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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signUp extends AppCompatActivity {
    EditText firstname, email, pasword, confrimpasword;
    Button signup, signIn;
    FirebaseAuth fauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signup = findViewById(R.id.buttonsign);
        signIn = findViewById(R.id.buttonlogIN);
        firstname = findViewById(R.id.editTextTextPersonName);
        email = findViewById(R.id.EDTEmail);
        pasword = findViewById(R.id.editTextTextPassword);
        confrimpasword = findViewById(R.id.editTextTextPassword2);


signIn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }
});
signup.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String FirstName= firstname.getText().toString();
        String Email=email.getText().toString();
        String Passwrod=pasword.getText().toString();
        String confirmPassword=confrimpasword.getText().toString();
        fauth=FirebaseAuth.getInstance();
        if (FirstName.isEmpty())
        {
            firstname.setError("First Name is required");
            return;
        }

        if (Email.isEmpty())
        {
            email.setError("Last Name is required");
            return;

        }
        if (Passwrod.isEmpty())
        {
            pasword.setError("Password  is required");
            return;

        }
        if (confirmPassword.isEmpty())
        {
            confrimpasword.setError("confirm Password is required");
            return;

        }
        if (!Passwrod.equals(confirmPassword))
        {
            confrimpasword.setError("Password Doesn't Match");
            return;
        }
        Toast.makeText(signUp.this,"Data is validated",Toast.LENGTH_SHORT).show();
        fauth.createUserWithEmailAndPassword(Email,Passwrod).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                startActivity(new Intent(getApplicationContext(),StartQuizz.class));
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(signUp.this,e.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

    }
});
    }
}
