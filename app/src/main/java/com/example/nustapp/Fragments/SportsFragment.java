package com.example.nustapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.example.nustapp.Adapter.EventBannerAdapter;
import com.example.nustapp.Adapter.TrackingSportsAdapter;
import com.example.nustapp.ItemClasses.TrackingSportsData;
import com.example.nustapp.R;

import java.io.*;
import java.util.ArrayList;

public class SportsFragment extends Fragment {

    public SportsFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sports, container, false);
        RecyclerView trackingRecyclerView;
        TrackingSportsAdapter trackingSportsAdapter;
        LinearLayoutManager trackinglinearlayout;


        trackingRecyclerView = rootView.findViewById(R.id.trendingRecyclerview);


        //Sample Data
        ArrayList<TrackingSportsData> trackingSportsitems = new ArrayList<>();
        TrackingSportsData item1 = new TrackingSportsData("Cricket" , "Dance" , R.drawable.cricket , R.drawable.dance);
        TrackingSportsData item2 = new TrackingSportsData("Cricket" , "Dance" , R.drawable.cricket , R.drawable.dance);
        TrackingSportsData item3 = new TrackingSportsData("Cricket" , "Dance" , R.drawable.cricket , R.drawable.dance);
        trackingSportsitems.add(item1);
        trackingSportsitems.add(item2);
        trackingSportsitems.add(item3);
        trackingSportsitems.add(item3);
        trackingSportsitems.add(item3);
        trackingSportsitems.add(item3);
        /////////

        trackingSportsAdapter = new TrackingSportsAdapter(requireContext().getApplicationContext(), trackingSportsitems);
        trackingRecyclerView.setAdapter(trackingSportsAdapter);
        trackinglinearlayout = new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false);
        trackingRecyclerView.setLayoutManager(trackinglinearlayout);
        SnapHelper snapHelper1 = new PagerSnapHelper(); // or LinearSnapHelper() for smoother scrolling
        snapHelper1.attachToRecyclerView(trackingRecyclerView);



        return rootView;
    }
}
