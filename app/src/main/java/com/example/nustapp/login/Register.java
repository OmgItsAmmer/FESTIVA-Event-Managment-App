package com.example.nustapp.login;

import static android.widget.Toast.makeText;

import static com.example.nustapp.R.*;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

public class Register extends AppCompatActivity {
    Map<String, Object> users = GetUserInfo.users;
    EditText signUpEmailAddress, signUpPassword, confirmPassword;
    Button register;
    FirebaseAuth auth;
    FirebaseFirestore db = GetUserInfo.db;
    String user;
    String pass;
    String repass;
    boolean isRegistering = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_register);

        auth = FirebaseAuth.getInstance();
        signUpEmailAddress = findViewById(id.emailAddress);
        signUpPassword = findViewById(id.password);
        confirmPassword = findViewById(id.confirmPassword);
        register = findViewById(id.RegisterButton);

        register.setOnClickListener(v -> {
            user = signUpEmailAddress.getText().toString();
            pass = signUpPassword.getText().toString();
            repass = confirmPassword.getText().toString();

            signIn(user, pass, repass);
        });
    }

    public void signIn(String user, String pass, String repass) {
        if (user.isEmpty() || pass.isEmpty() || repass.isEmpty()) {
            Toast.makeText(Register.this, "Empty Credentials", Toast.LENGTH_SHORT).show();
        } else if (pass.length() < 6) {
            Toast.makeText(Register.this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
        } else if (!pass.equals(repass)) {
            Toast.makeText(Register.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
        } else {
            auth.createUserWithEmailAndPassword(user, pass).addOnSuccessListener(authResult -> {
                FirebaseUser firebaseUser = auth.getCurrentUser();
                if (firebaseUser != null) {
                    firebaseUser.sendEmailVerification().addOnSuccessListener(task1 -> {
                            makeText(Register.this, "Verification email sent", Toast.LENGTH_SHORT).show();
                            onResume();
                    }).addOnFailureListener(e -> {
                            makeText(Register.this, "Failed to send verification email", Toast.LENGTH_SHORT).show();
                            firebaseUser.delete();
                    });
                }
            }).addOnFailureListener(e -> {
                FirebaseUser firebaseUser = auth.getCurrentUser();
                if (e instanceof FirebaseAuthUserCollisionException) {
                    makeText(Register.this, "User Already Exists", Toast.LENGTH_SHORT).show();
                    recreate();
                } else {
                    makeText(Register.this, "User Not Created", Toast.LENGTH_SHORT).show();
                    recreate();
                }
                assert firebaseUser != null;
                firebaseUser.delete();
            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isRegistering) {
            FirebaseUser firebaseUser = auth.getCurrentUser();
            if (firebaseUser != null && isRegistering) { // Check if user is registering
                firebaseUser.reload().addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        if (firebaseUser.isEmailVerified()) {
                            Toast.makeText(Register.this, "Email verified", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Register.this, GetUserInfo.class));
                        } else {
                            Toast.makeText(Register.this, "Please respond to the verification email sent", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // Handle error
                        Toast.makeText(Register.this, "Failed to reload user", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
        else {}
    }

    @Override
    public void onPause() {
        super.onPause();
        isRegistering = true;
    }
}