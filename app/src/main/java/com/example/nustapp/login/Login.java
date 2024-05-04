package com.example.nustapp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nustapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;

import java.util.Objects;

public class Login extends AppCompatActivity {

    EditText emailAddress, password;
    Button registerButton;

            FirebaseAuth auth = FirebaseAuth.getInstance();

    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailAddress = findViewById(R.id.emailAddress);
        password = findViewById(R.id.password);
        Button RegisterButton = findViewById(R.id.register);
        Button LogInButton = findViewById(R.id.loginButton);

        if(auth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), com.example.nustapp.Activity.MainActivity.class));
       }

        LogInButton.setOnClickListener(v -> {
            String user = emailAddress.getText().toString();
            String pass = password.getText().toString();
            login(user, pass);
        });

        RegisterButton.setOnClickListener(v -> startActivity(new Intent(this, Register.class)));
    }

    //method for login
    public void login(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(Login.this, "Empty Credentials", Toast.LENGTH_SHORT).show();
        } else if (password.length() < 6) {
            Toast.makeText(Login.this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
        } else {
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    startActivity(new Intent(getApplicationContext(), com.example.nustapp.Activity.MainActivity.class));
                } else {
                    if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                        Toast.makeText(Login.this, "Invalid credentials. Please try again.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Login.this, "Login Failed: " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}