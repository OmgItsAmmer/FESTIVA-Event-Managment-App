package com.example.nustapp.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nustapp.Activity.MainActivity;
import com.example.nustapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Objects;

public class Login extends AppCompatActivity {
    public static ArrayList<String> RecentList=new ArrayList<>();
    EditText emailAddress, password;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseFirestore db=FirebaseFirestore.getInstance();
    public static String GLOBAL_EMAIL;


    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        // DocumentReference docRef=db.collection("users").document(GLOBAL_EMAIL);

        emailAddress = findViewById(R.id.emailAddress);
        password = findViewById(R.id.password);
        Button RegisterButton = findViewById(R.id.register);
        Button LogInButton = findViewById(R.id.loginButton);


        /*if (auth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), com.example.nustapp.Activity.MainActivity.class));
        }*/

        LogInButton.setOnClickListener(v -> {
            String user = emailAddress.getText().toString();
            String pass = password.getText().toString();
            GLOBAL_EMAIL = user;
            Toast.makeText(this, GLOBAL_EMAIL, Toast.LENGTH_SHORT).show();
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
                    String user = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getEmail();
                    if (user != null && !user.isEmpty()) {
                        Data(user); // Call Data() method with non-null user
                        startActivity(new Intent(this, MainActivity.class));
                    } else {
                        Toast.makeText(Login.this, "User email is null or empty", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                        Toast.makeText(Login.this, "Invalid credentials. Please try again.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Login.this, "Login Failed: " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    public void Data(String name){
        DocumentReference docRef=db.collection("users").document(name);
        docRef.get().addOnSuccessListener(documentSnapshot -> {
            Login.RecentList.clear();
            Login.RecentList.add(0, Objects.requireNonNull(documentSnapshot.get("item1")).toString());
            Login.RecentList.add(1, Objects.requireNonNull(documentSnapshot.get("item2")).toString());
            Login.RecentList.add(2, Objects.requireNonNull(documentSnapshot.get("item3")).toString());
            Login.RecentList.add(3, Objects.requireNonNull(documentSnapshot.get("item4")).toString());
            Login.RecentList.add(4, Objects.requireNonNull(documentSnapshot.get("item5")).toString());
            Login.RecentList.add(5, Objects.requireNonNull(documentSnapshot.get("item6")).toString());
            Toast.makeText(Login.this, "successful", Toast.LENGTH_SHORT).show();
        });
        //Toast.makeText(this,Login.RecentList.get(0) , Toast.LENGTH_SHORT).show();
    }
}