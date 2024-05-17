package com.example.nustapp.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nustapp.Activity.MainActivity;
import com.example.nustapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GetUserInfo extends AppCompatActivity {
    public static Map<String, Object> users = new HashMap<>();
    public static FirebaseFirestore db = FirebaseFirestore.getInstance();
    public final int REQUEST_CODE = 101;
    EditText cms, firstName, lastName;
    Button submit;
    ImageView image;
    ProgressBar progressBar;
    Uri imageUri;
    String cmsID, fName, lName;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_info);

        cms = findViewById(R.id.CMS_IDEditText);
        firstName = findViewById(R.id.firstNameEditText);
        lastName = findViewById(R.id.lastNameEditText);
        submit = findViewById(R.id.submit);
        image = findViewById(R.id.imageView);
       // progressBar = findViewById(R.id.progressBar);



        submit.setOnClickListener(v -> {
            cmsID = cms.getText().toString();
            fName = firstName.getText().toString();
            lName = lastName.getText().toString();
            if (cmsID.isEmpty() || fName.isEmpty() || lName.isEmpty()) {
                Toast.makeText(GetUserInfo.this, "Empty Credentials", Toast.LENGTH_SHORT).show();
            }
            else if(imageUri == null){
                Toast.makeText(GetUserInfo.this, "No image selected", Toast.LENGTH_SHORT).show();
            }
            else {
                //Create a new user with a first and last name
                users.put("CMS_ID", cmsID);
                users.put("First Name", fName);
                users.put("Last Name", lName);
                users.put("item1", "Cricket");
                users.put("item2", "Football");
                users.put("item3", "Badminton");
                users.put("item4", "Squash");
                users.put("item5", "Hockey");
                users.put("item6", "Fut sal");
                users.put("imageURI", imageUri.toString());
            }
            db.collection("users").document(Objects.requireNonNull(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getEmail())).set(users).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(this, "Data stored successfully", Toast.LENGTH_SHORT).show();

                        progressBar.setVisibility(ProgressBar.VISIBLE);

                    }
                    else {
                        Toast.makeText(this, "Error adding data", Toast.LENGTH_SHORT).show();
                    }
                });
            uploadImage();
            users.clear();
        });

        //setting profile image
        image.setOnClickListener(v -> {
            Intent getImageIntent = new Intent(Intent.ACTION_PICK);
            getImageIntent.setType("image/*");
            startActivityForResult(getImageIntent, REQUEST_CODE);
        });
    }

    //getting profile image from user gallery
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            imageUri = data.getData();
            image.setImageURI(imageUri);
        }
        else {
            Toast.makeText(this, "No image selected", Toast.LENGTH_SHORT).show();
        }
    }

    private void uploadImage() {
   //     ProgressBar progressBar = new ProgressBar(this);
    //    progressBar.setVisibility(ProgressBar.VISIBLE);
    //    progressBar.setProgress(0);
        //    progressBar.setMax(100);

        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("profileImages/").child(Objects.requireNonNull(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getEmail()));
        storageReference.putFile(imageUri).addOnSuccessListener(taskSnapshot -> {
           // progressBar.setVisibility(ProgressBar.INVISIBLE);
            Toast.makeText(this, "Image uploaded successfully", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));
        }).addOnFailureListener(e -> {
            FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
            if (firebaseUser != null) {
                firebaseUser.delete();
            }
         //   progressBar.setVisibility(ProgressBar.INVISIBLE);
            Toast.makeText(this, "Image upload failed", Toast.LENGTH_SHORT).show();
        });
    }
}