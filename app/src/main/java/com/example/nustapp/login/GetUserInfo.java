package com.example.nustapp.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nustapp.Activity.MainActivity;
import com.example.nustapp.R;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class GetUserInfo extends AppCompatActivity {
    public static Map<String, Object> users = new HashMap<>();
    public static FirebaseFirestore db = FirebaseFirestore.getInstance();
    EditText cms, firstName, lastName;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_info);
        //getting email address from sign in activity
        Intent intent = getIntent();
        String userEmailAddress = intent.getStringExtra("email");

        cms = findViewById(R.id.CMS_IDEditText);
        firstName = findViewById(R.id.firstNameEditText);
        lastName = findViewById(R.id.lastNameEditText);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(v -> {
            String cmsID = cms.getText().toString();
            String fName = firstName.getText().toString();
            String lName = lastName.getText().toString();

            if (cmsID.isEmpty() || fName.isEmpty() || lName.isEmpty()) {
                Toast.makeText(GetUserInfo.this, "Empty Credentials", Toast.LENGTH_SHORT).show();
            }
            else {
                //Create a new user with a first and last name
                users.put("CMS_ID", cmsID);
                users.put("First Name", fName);
                users.put("Last Name", lName);
                db.collection("users").document(userEmailAddress).set(users).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(this, "Data stored successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(this, MainActivity.class));
                    } else {
                        Log.w("TAG", "Error adding document", task.getException());
                    }
                });
            }
                        users.clear();
        });
    }
}