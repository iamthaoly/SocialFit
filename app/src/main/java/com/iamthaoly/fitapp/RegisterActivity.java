package com.iamthaoly.fitapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    TextView txtLogIn;
    EditText edtEmail, edtPassword;
    Button btnReg;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        addControls();
        addEvents();
        if(auth.getCurrentUser() != null) {
            Intent intent = new Intent(RegisterActivity.this, MenuActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void addControls() {
        auth = FirebaseAuth.getInstance();

        btnReg = findViewById(R.id.btnRegister);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        txtLogIn = findViewById(R.id.txtLogin);
    }

    private void addEvents() {
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString();
                String pass = edtPassword.getText().toString();
                if(email.isEmpty()) {
                    edtEmail.setError("Please enter a valid email!");
                    edtEmail.requestFocus();
                }
                else if(pass.isEmpty() || pass.length() < 6) {
                    edtPassword.setError("Please enter a valid password!");
                    edtPassword.requestFocus();
                }
                else {
                    auth.createUserWithEmailAndPassword(email, pass)
                            .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(!task.isSuccessful()) {
                                        Toast.makeText(RegisterActivity.this, "Register failed", Toast.LENGTH_LONG);
                                    }
                                    else{
                                        Toast.makeText(RegisterActivity.this, "Register successful", Toast.LENGTH_SHORT);
//                                        Intent intent = new Intent()
                                        Intent intent = new Intent(RegisterActivity.this, MenuActivity.class);
                                        startActivity(intent);
                                    }
                                }
                            });
                }
            }
        });

        txtLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
