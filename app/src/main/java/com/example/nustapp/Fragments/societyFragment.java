package com.example.nustapp.Fragments;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.nfc.NfcAntennaInfo;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.example.nustapp.Activity.societyactivity;
import com.example.nustapp.Adapter.MembershipAdapter;
import com.example.nustapp.Adapter.SeminarAdapter;
import com.example.nustapp.Adapter.TopSocietyAdapter;
import com.example.nustapp.Adapter.TripsAdapter;
import com.example.nustapp.Interfaces.OnButtonClickListener;
import com.example.nustapp.ItemClasses.SeminarItemData;
import com.example.nustapp.ItemClasses.TopSocietyData;
import com.example.nustapp.ItemClasses.TripItemData;
import com.example.nustapp.R;

import java.util.ArrayList;

public class societyFragment extends Fragment implements OnButtonClickListener {

RecyclerView topSocietyRecyclerView;

RecyclerView seminarRecyclerView;

RecyclerView triprecyclerView;

TripsAdapter tripsAdapter;

SeminarAdapter seminarAdapter;
TopSocietyAdapter topSocietyAdapter;

LinearLayout societyExpandableLinearlayout;

CardView  societyExpandableCardView;
ConstraintLayout expandableprofilelayoutSociety;

TextView expandablelastnameSociety;

TextView seealltxt;

    public societyFragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_society, container, false);

        topSocietyRecyclerView = rootView.findViewById(R.id.topsocietrecyclerView);
        societyExpandableLinearlayout = rootView.findViewById(R.id.expandalbeLinearLayoutSociety);
        societyExpandableCardView = rootView.findViewById(R.id.cardviewExpandableSociety);
        expandableprofilelayoutSociety = rootView.findViewById(R.id.expandableprofilelayoutSociety);
        expandablelastnameSociety = rootView.findViewById(R.id.expandablelastnameSociety);
        seminarRecyclerView = rootView.findViewById(R.id.seminarRecyclerView);
        triprecyclerView = rootView.findViewById(R.id.tripsrecyclerview);
        seealltxt = rootView.findViewById(R.id.seealltxt);



        societyExpandableLinearlayout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        societyExpandableCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int visiblilty = (expandableprofilelayoutSociety.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
                TransitionManager.beginDelayedTransition(societyExpandableLinearlayout, new AutoTransition());
                expandableprofilelayoutSociety.setVisibility(visiblilty);
                expandablelastnameSociety.setVisibility(visiblilty);
            }
        });


        seealltxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), societyactivity.class); //May cause error
            }
        });




        //SampleData
        ArrayList<TopSocietyData> topSocietyData = new ArrayList<>();
        TopSocietyData item1 = new TopSocietyData("ACM",R.drawable.acm,900,R.drawable.hiring,true);
        TopSocietyData item2 = new TopSocietyData("NCSC",R.drawable.gym,1100,R.drawable.hiring,false);
        TopSocietyData item3 = new TopSocietyData("Yes",R.drawable.swim,250,R.drawable.hiring,true);
        topSocietyData.add(item1);
        topSocietyData.add(item2);
        topSocietyData.add(item3);

        topSocietyAdapter = new TopSocietyAdapter(requireContext().getApplicationContext(), topSocietyData);
        topSocietyRecyclerView.setAdapter(topSocietyAdapter);
        topSocietyAdapter.setOnButtonClickListener(this);
       // topSocietyRecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        //    membershipRecyclerView.setLayoutManager(layoutManager);
        //   trackinglinearlayout = new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false);
        topSocietyRecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false));
        //   membershipRecyclerView.setLayoutManager(membershipLayout);
        SnapHelper snapHelper2 = new PagerSnapHelper();
        snapHelper2.attachToRecyclerView(topSocietyRecyclerView);

        ArrayList<SeminarItemData> seminarItemData = getSeminarItemData();


        seminarAdapter = new SeminarAdapter( seminarItemData,requireContext().getApplicationContext());
        seminarRecyclerView.setAdapter(seminarAdapter);
        seminarAdapter.setOnButtonClickListener(this);
        // topSocietyRecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        //    membershipRecyclerView.setLayoutManager(layoutManager);
        //   trackinglinearlayout = new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false);
        seminarRecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false));
        //   membershipRecyclerView.setLayoutManager(membershipLayout);
        SnapHelper snapHelper3 = new PagerSnapHelper();
        snapHelper3.attachToRecyclerView(seminarRecyclerView);


        ArrayList<TripItemData> tripItemData = new ArrayList<>();

        TripItemData item7 = new TripItemData("Swat Valley","02/05/24","01/05/2024","NAC",R.drawable.trip1);
        TripItemData item8 = new TripItemData("Kashmir","02/05/24","01/05/2024","NAC",R.drawable.trip2);
        TripItemData item9 = new TripItemData("Joyland","02/05/24","01/05/2024","NAC",R.drawable.trip3);
        tripItemData.add(item7);
        tripItemData.add(item8);
        tripItemData.add(item9);

        tripsAdapter = new TripsAdapter( tripItemData,requireContext().getApplicationContext());
        triprecyclerView.setAdapter(tripsAdapter);
        tripsAdapter.setOnButtonClickListener(this);
        // topSocietyRecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        //    membershipRecyclerView.setLayoutManager(layoutManager);
        //   trackinglinearlayout = new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false);
        triprecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false));
        //   membershipRecyclerView.setLayoutManager(membershipLayout);
        SnapHelper snapHelper4 = new PagerSnapHelper();
        snapHelper4.attachToRecyclerView(triprecyclerView);


        return rootView;
    }

    @NonNull
    private static ArrayList<SeminarItemData> getSeminarItemData() {
        ArrayList<SeminarItemData> seminarItemData = new ArrayList<>();
        SeminarItemData item4 = new SeminarItemData("AI by Deep Learning",R.drawable.ai,9000,"Ammer Saeed",R.color.red,R.drawable.mypic,"12:30","SEECS");
        SeminarItemData item5 = new SeminarItemData("AI by Deep Learning",R.drawable.swim,9000,"Ammer Saeed",R.color.red,R.drawable.mypic3,"12:30","SEECS");
        SeminarItemData item6 = new SeminarItemData("AI by Deep Learning",R.drawable.ai,9000,"Ammer Saeed",R.color.red,R.drawable.mypic,"12:30","SEECS");
        seminarItemData.add(item4);
        seminarItemData.add(item5);
        seminarItemData.add(item6);
        return seminarItemData;
    }


    @Override
    public void onButtonClick(int position, String tag) {

    }

    @Override
    public void onOneItemButtonClick(int position) {

    }


}
