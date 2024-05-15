package com.example.nustapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.example.nustapp.Adapter.CentralHubAdapter;
import com.example.nustapp.Adapter.SeeAllSocietiesAdapter;
import com.example.nustapp.Interfaces.OnButtonClickListener;
import com.example.nustapp.ItemClasses.CentralHubItemData;
import com.example.nustapp.R;

import java.io.*;
import java.util.ArrayList;

public class TrendFragments extends Fragment implements OnButtonClickListener {

    RecyclerView centralRecyclerView;
    
    CentralHubAdapter   centralHubAdapter;
    public TrendFragments(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_trend_fragments, container, false);
        centralRecyclerView = rootView.findViewById(R.id.centralRecyclerView);


        ArrayList<CentralHubItemData >  items = new ArrayList<>();
        CentralHubItemData item1 = new CentralHubItemData("TEKKEN 8",R.drawable.seminar1,900);
        CentralHubItemData item2 = new CentralHubItemData("Call of Duty",R.drawable.seminar1,669);
        CentralHubItemData item3 = new CentralHubItemData("Fifa 24",R.drawable.seminar1,700);
        items.add(item1);
        items.add(item2);
        items.add(item3);

        centralHubAdapter = new CentralHubAdapter( items,getActivity());
        centralRecyclerView.setAdapter(centralHubAdapter);
        centralHubAdapter.setOnButtonClickListener(this);
        // topSocietyRecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        //    membershipRecyclerView.setLayoutManager(layoutManager);
        //   trackinglinearlayout = new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        centralRecyclerView.setLayoutManager(layoutManager);
        //   membershipRecyclerView.setLayoutManager(membershipLayout);

        SnapHelper snapHelper4 = new PagerSnapHelper();
        snapHelper4.attachToRecyclerView(centralRecyclerView);

        return rootView;
       // View RootView =  inflater.inflate(R.layout.fragment_trend_fragments, container, false);
    }

    @Override
    public void onButtonClick(int position, String tag) {
        
    }

    @Override
    public void onOneItemButtonClick(int position) {

        Toast.makeText(getActivity(), "Tekken", Toast.LENGTH_SHORT).show();

    }
}
