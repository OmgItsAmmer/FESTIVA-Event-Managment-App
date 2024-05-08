package com.example.nustapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nustapp.Adapter.TrackerSportsAdapter;
import com.example.nustapp.Interfaces.OnButtonClickListener;
import com.example.nustapp.ItemClasses.TrackerSportsItemData;
import com.example.nustapp.R;

import java.util.ArrayList;


public class SportTrackerActivity extends AppCompatActivity {

    RecyclerView trackerrecyclerview;

    TrackerSportsAdapter trackerSportsAdapter;

    OnButtonClickListener listener;
    Button reservation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sport_tracker);

        trackerrecyclerview = findViewById(R.id.trackerrecyclerview);
        Intent intent = getIntent();

        ArrayList<TrackerSportsItemData> trackerSportsItemData = new ArrayList<>();

        TrackerSportsItemData item1 = new TrackerSportsItemData("SNS GROUND","9/11",true,false);
        TrackerSportsItemData item2 = new TrackerSportsItemData("HBL GROUND","6/11",false,false);
        trackerSportsItemData.add(item1);
        trackerSportsItemData.add(item2);


        try{
            trackerSportsAdapter = new TrackerSportsAdapter( trackerSportsItemData,getApplicationContext());

            trackerrecyclerview.setAdapter(trackerSportsAdapter);
            trackerSportsAdapter.setOnButtonClickListener(listener);
            trackerrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        }
        catch (Exception e)
        {
            Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
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
}