package com.example.nustapp.Activity;

import static androidx.core.content.ContentProviderCompat.requireContext;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.example.nustapp.Adapter.SeeAllSocietiesAdapter;
import com.example.nustapp.Adapter.TripsAdapter;
import com.example.nustapp.Interfaces.OnButtonClickListener;
import com.example.nustapp.ItemClasses.SeeAllSocietiesItemData;
import com.example.nustapp.R;

import java.util.ArrayList;

public class societyactivity extends AppCompatActivity implements  OnButtonClickListener {
    RecyclerView seeallrecyclerview;
    SeeAllSocietiesAdapter seeAllSocietiesAdapter;

    OnButtonClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_societyactivity);
        seeallrecyclerview = findViewById(R.id.seeallrecyclerview);

        Intent intent = getIntent();

        ArrayList<SeeAllSocietiesItemData> seeAllSocietiesItemData = getSeeAllSocietiesItemData();

        seeAllSocietiesAdapter = new SeeAllSocietiesAdapter( seeAllSocietiesItemData,getApplicationContext());
        seeallrecyclerview.setAdapter(seeAllSocietiesAdapter);
        seeAllSocietiesAdapter.setOnButtonClickListener(this);
        // topSocietyRecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        //    membershipRecyclerView.setLayoutManager(layoutManager);
        //   trackinglinearlayout = new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        seeallrecyclerview.setLayoutManager(layoutManager);
        //   membershipRecyclerView.setLayoutManager(membershipLayout);

        SnapHelper snapHelper4 = new PagerSnapHelper();
        snapHelper4.attachToRecyclerView(seeallrecyclerview);
        
        
        



    }

    @NonNull
    private static ArrayList<SeeAllSocietiesItemData> getSeeAllSocietiesItemData() {
        ArrayList<SeeAllSocietiesItemData> seeAllSocietiesItemData  = new ArrayList<>();
        SeeAllSocietiesItemData item1 = new SeeAllSocietiesItemData("ACM",R.drawable.acm,R.drawable.hiring);
        SeeAllSocietiesItemData item2 = new SeeAllSocietiesItemData("ACM",R.drawable.trip2,R.drawable.hiring);
        SeeAllSocietiesItemData item3 = new SeeAllSocietiesItemData("ACM",R.drawable.trip1,R.drawable.hiring);
        seeAllSocietiesItemData.add(item1);
        seeAllSocietiesItemData.add(item2);
        seeAllSocietiesItemData.add(item3);
        return seeAllSocietiesItemData;
    }

    @Override
    public void onButtonClick(int position, String tag) {
        
    }

    @Override
    public void onOneItemButtonClick(int position) {
        Toast.makeText(this, "Position " + position, Toast.LENGTH_SHORT).show();
    }
}