package com.example.mymessageapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginSign extends AppCompatActivity {
    TextInputLayout email,password;
    Button logq, sinunu;
    FirebaseAuth authww;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sign);

         email = findViewById(R.id.email);
         password = findViewById(R.id.password);
        logq = findViewById(R.id.gwewwe);
        sinunu = findViewById(R.id.wwnnw);

        authww = FirebaseAuth.getInstance();

        logq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ema = email.getEditText().getText().toString();
                String qqa = password.getEditText().getText().toString();

                authww.signInWithEmailAndPassword(ema,qqa).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(LoginSign.this, MainActivity.class));
                        } else {
                            Toast.makeText(LoginSign.this, "Login not successfull", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        sinunu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ema = email.getEditText().getText().toString();
                String qqa = password.getEditText().getText().toString();

                authww.createUserWithEmailAndPassword(ema,qqa).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()){
                           Toast.makeText(LoginSign.this, "Signed in successfully", Toast.LENGTH_SHORT).show();
                       } else {
                           Toast.makeText(LoginSign.this, "Signed in failed", Toast.LENGTH_SHORT).show();
                       }
                    }
                });
            }
        });

    }
}