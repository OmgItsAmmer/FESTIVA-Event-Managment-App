package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private Button registerbtn, Loginbtn;
    EditText emailaddress, password;
    FirebaseAuth auth = FirebaseAuth.getInstance();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailaddress = findViewById(R.id.Emailaddress);
        password = findViewById(R.id.password);
        registerbtn = findViewById(R.id.register);
        Loginbtn = findViewById(R.id.loginbtn);//was giving error

        String user = emailaddress.getText().toString();
        String pass = password.getText().toString();

        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = emailaddress.getText().toString();
                String pass = password.getText().toString();
                validateLogInData(user, pass);
                login(user, pass);

            }
        });

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerintent = new Intent(getApplicationContext(), Register.class);
                startActivity(registerintent);
            }
        });
    }

    /*public void Openregister(View view){
        Intent registerintent = new Intent(getApplicationContext(), Register.class);
        startActivity(registerintent);

    }*/

    //method for login
    public void login(String email, String password) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Login Failed: " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void validateLogInData(String user, String pass) {
        if (user.isEmpty() || pass.isEmpty()) {
            Toast.makeText(MainActivity.this, "Empty Credentials", Toast.LENGTH_SHORT).show();
        } else if (pass.length() < 6) {
            Toast.makeText(MainActivity.this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
        }
            // Continue with login process
        }

    }