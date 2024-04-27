package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;


public class Register extends AppCompatActivity {
    EditText emailaddresssignup, passwordsignup, confirmpassword;
    Button registersignup;
    //FirebaseDatabase rootNode;
    FirebaseAuth auth;
    //HashMap<String, String> userMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        auth = FirebaseAuth.getInstance();
        emailaddresssignup = findViewById(R.id.EmailaddressSignUp);
        passwordsignup = findViewById(R.id.passwordsignup);
        confirmpassword = findViewById(R.id.confirmpassword);
        registersignup = findViewById(R.id.registersignupbtn);


        registersignup.setOnClickListener(v -> {
            String user = emailaddresssignup.getText().toString();
            String pass = passwordsignup.getText().toString();
            String repass = confirmpassword.getText().toString();

            validateSignInData(user, pass, repass);
            createAndVerifyUser(user, pass);

        });
    }

    /*rootNode = FirebaseDatabase.getInstance();
    userMap.put("email", user);
    userMap.put("password", pass);
    rootNode.getReference().child("Users").setValue(userMap).addOnCompleteListener(task -> {
        if (task.isSuccessful()) {
            Toast.makeText(Register.this, "Data written successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(Register.this, "Failed to write data: " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
        }
    });*/
    public void validateSignInData(String user, String pass, String repass) {
        if (user.isEmpty() || pass.isEmpty() || repass.isEmpty()) {
            Toast.makeText(Register.this, "Empty Credentials", Toast.LENGTH_SHORT).show();
        } else if (pass.length() < 6) {
            Toast.makeText(Register.this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
        } else if (!pass.equals(repass)) {
            Toast.makeText(Register.this, "Password does not match", Toast.LENGTH_SHORT).show();
        }
            // Continue with registration process
        }

    public boolean checkUserExists(String email) {
        FirebaseUser user = auth.getCurrentUser();
        if (user != null && user.getEmail().equals(email)) {
            Toast.makeText(Register.this, "User Already Exists", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return false;
        }
    }

    public void createAndVerifyUser(String user, String pass) {
        if (checkUserExists(user)) {
            Toast.makeText(this, "User Already Exists", Toast.LENGTH_SHORT).show();
            return;
        } else {
            auth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    FirebaseUser firebaseUser = auth.getCurrentUser();
                    if (firebaseUser != null) {
                        firebaseUser.sendEmailVerification().addOnCompleteListener(task1 -> {
                            if (!task1.isSuccessful()) {
                                Toast.makeText(Register.this, "Failed to send verification email", Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(Register.this, HomeActivity.class));
                            }
                        });
                    }
                }
                else {
                    Toast.makeText(Register.this, "User not created", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
