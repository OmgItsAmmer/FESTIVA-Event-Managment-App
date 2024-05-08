package com.example.nustapp.ItemClasses;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nustapp.Activity.MainActivity;
import com.example.nustapp.R;

public class TrackerSportsItemData extends AppCompatActivity {

    private String groundName;

    private String status;

    private Boolean availability;









    Button reservationButton;
    public Boolean isExpandable;

    public TrackerSportsItemData(String groundName, String status, Boolean availability,Boolean isExpandable) {
        this.setGroundName(groundName);
        this.setStatus(status);
        this.setAvailability(availability);
        this.isExpandable = isExpandable;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        reservationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setReservationButton();
                reservationButton.setEnabled(false);
                Toast.makeText(TrackerSportsItemData.this, "successful", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public Boolean getExpandable() {
        return isExpandable;
    }

    public void setExpandable(Boolean expandable) {
        isExpandable = expandable;
    }

    public String getGroundName() {
        return groundName;
    }

    public void setGroundName(String groundName) {
        this.groundName = groundName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public void setReservationButton() {
        new CountDownTimer(3000,1000){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

            }
        };
    }
}