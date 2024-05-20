package com.example.nustapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nustapp.Adapter.TrackerSportsAdapter;
import com.example.nustapp.Adapter.TripsAdapter;
import com.example.nustapp.Interfaces.OnButtonClickListener;
import com.example.nustapp.ItemClasses.TrackerSportsItemData;
import com.example.nustapp.R;

import java.util.ArrayList;


public class SportTrackerActivity extends AppCompatActivity implements OnButtonClickListener {

    RecyclerView trackerrecyclerview;

    TrackerSportsAdapter trackerSportsAdapter;

    OnButtonClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sport_tracker);

        trackerrecyclerview = findViewById(R.id.trackerrecyclerview);
        Intent intent = getIntent();

        ArrayList<TrackerSportsItemData> trackerSportsItemData = new ArrayList<>();

        TrackerSportsItemData item1 = new TrackerSportsItemData("SNS GROUND", "9/11", true, false);
        TrackerSportsItemData item2 = new TrackerSportsItemData("HBL GROUND", "6/11", false, false);
        trackerSportsItemData.add(item1);
        trackerSportsItemData.add(item2);


        listener = this; // to initlize the listner for the sake of two buttons



        try {
            trackerSportsAdapter = new TrackerSportsAdapter(trackerSportsItemData, getApplicationContext(),listener);

            trackerrecyclerview.setAdapter(trackerSportsAdapter);
            trackerSportsAdapter.setOnButtonClickListener(listener);
            trackerrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        } catch (Exception e) {
            Toast.makeText(this, "" + e, Toast.LENGTH_SHORT).show();
        }


        // trackerrecyclerview.setItemViewCacheSize(20);
        // topSocietyRecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        //    membershipRecyclerView.setLayoutManager(layoutManager);
        //   trackinglinearlayout = new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false);
        //trackerrecyclerview.setHasFixedSize(true);
        //   membershipRecyclerView.setLayoutManager(membershipLayout);
        // SnapHelper snapHelper4 = new PagerSnapHelper();
        // snapHelper4.attachToRecyclerView(triprecyclerView);


    }


    // Method was changed on Saims request 5/19/2024
    @Override
    public void onButtonClick(int position, String tag) {

        if(tag.equals("reservation"))
        {
            Toast.makeText(this, "Reservation", Toast.LENGTH_SHORT).show();
        }
        else if (tag.equals("booking"))
        {
            Toast.makeText(this, "booking", Toast.LENGTH_SHORT).show();
        }
        else if (tag.equals("waiting"))
        {
            Toast.makeText(this, "Waiting", Toast.LENGTH_SHORT).show();
        }
        else if (tag.equals("cancelreservation"))
        {
            Toast.makeText(this, "Cancel Reservation", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "no item", Toast.LENGTH_SHORT).show();
        }
            


    }

    @Override
    public void onOneItemButtonClick(int position) {
     //  Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
    }
}