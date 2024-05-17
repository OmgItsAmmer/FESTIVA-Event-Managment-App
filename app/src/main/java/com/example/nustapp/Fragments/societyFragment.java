package com.example.nustapp.Fragments;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;


import com.example.nustapp.Activity.InfoActivity;
import com.example.nustapp.Activity.MainActivity;
import com.example.nustapp.Activity.SportTrackerActivity;

import com.bumptech.glide.Glide;

import com.example.nustapp.Activity.societyactivity;
import com.example.nustapp.Adapter.SeminarAdapter;
import com.example.nustapp.Adapter.TopSocietyAdapter;
import com.example.nustapp.Adapter.TripsAdapter;
import com.example.nustapp.Interfaces.OnButtonClickListener;
import com.example.nustapp.ItemClasses.SeminarItemData;
import com.example.nustapp.ItemClasses.TopSocietyData;
import com.example.nustapp.ItemClasses.TripItemData;
import com.example.nustapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Objects;

public class societyFragment extends Fragment implements OnButtonClickListener {

 //   StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("profileImages/").child(Objects.requireNonNull(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getEmail()));
RecyclerView topSocietyRecyclerView;

RecyclerView seminarRecyclerView;

RecyclerView triprecyclerView;

TripsAdapter tripsAdapter;

SeminarAdapter seminarAdapter;
TopSocietyAdapter topSocietyAdapter;

LinearLayout societyExpandableLinearlayout;

CardView  societyExpandableCardView;
ConstraintLayout expandableProfileLayoutSociety;

TextView expandableLastNameSociety;

TextView seeAllText;
ImageButton userImage;

DrawerLayout drawerLayout;
//CardView seeAllCardView;

    public societyFragment(){
        // require a empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_society, container, false);

        topSocietyRecyclerView = rootView.findViewById(R.id.topsocietrecyclerView);
        societyExpandableLinearlayout = rootView.findViewById(R.id.expandalbeLinearLayoutSociety);
        societyExpandableCardView = rootView.findViewById(R.id.cardviewExpandableSociety);
        expandableProfileLayoutSociety = rootView.findViewById(R.id.expandableprofilelayoutSociety);
        expandableLastNameSociety = rootView.findViewById(R.id.expandablelastnameSociety);
        seminarRecyclerView = rootView.findViewById(R.id.seminarRecyclerView);
        triprecyclerView = rootView.findViewById(R.id.tripsrecyclerview);
        seeAllText = rootView.findViewById(R.id.seeAllText);
        userImage = rootView.findViewById(R.id.userImage);
        drawerLayout = rootView.findViewById(R.id.my_drawer_layout);

        seeAllText.setOnClickListener(v -> {
          //  Toast.makeText(getActivity(), "hello", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getActivity(), societyactivity.class);
            startActivity(intent);
        });

     //   storageReference.getDownloadUrl().addOnSuccessListener(uri -> Glide.with(societyFragment.this).load(uri).into(userImage)).addOnFailureListener(e -> Toast.makeText(getActivity(), "Error loading image from Database", Toast.LENGTH_SHORT).show());




        societyExpandableLinearlayout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        societyExpandableCardView.setOnClickListener(v -> {
            int visibility = (expandableProfileLayoutSociety.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
            TransitionManager.beginDelayedTransition(societyExpandableLinearlayout, new AutoTransition());
            expandableProfileLayoutSociety.setVisibility(visibility);
            expandableLastNameSociety.setVisibility(visibility);
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
        topSocietyRecyclerView.setHasFixedSize(true);
        topSocietyRecyclerView.setItemViewCacheSize(20);
        topSocietyRecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false));

        SnapHelper snapHelper2 = new PagerSnapHelper();
        snapHelper2.attachToRecyclerView(topSocietyRecyclerView);


        // topSocietyRecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        //    membershipRecyclerView.setLayoutManager(layoutManager);
        //   trackingLinearLayout = new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false);
        //   membershipRecyclerView.setLayoutManager(membershipLayout);


        ArrayList<SeminarItemData> seminarItemData = getSeminarItemData();


        seminarAdapter = new SeminarAdapter( seminarItemData,requireContext().getApplicationContext());
        seminarRecyclerView.setAdapter(seminarAdapter);
        seminarAdapter.setOnButtonClickListener(this);
        seminarRecyclerView.setHasFixedSize(true);
        seminarRecyclerView.setItemViewCacheSize(20);
        seminarRecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false));
        SnapHelper snapHelper3 = new PagerSnapHelper();
        snapHelper3.attachToRecyclerView(seminarRecyclerView);



        // topSocietyRecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        //    membershipRecyclerView.setLayoutManager(layoutManager);
        //   trackingLinearLayout = new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false);
        //   membershipRecyclerView.setLayoutManager(membershipLayout);



        ArrayList<TripItemData> tripItemData = new ArrayList<>();

        TripItemData item7 = new TripItemData("Swat Valley","02/05/24","01/05/2024","NAC",R.drawable.trip1);
        TripItemData item8 = new TripItemData("Kashmir","02/05/24","01/05/2024","NAC",R.drawable.trip2);
        TripItemData item9 = new TripItemData("Joyland","02/05/24","01/05/2024","NAC",R.drawable.trip3);
        tripItemData.add(item7);
        tripItemData.add(item8);
        tripItemData.add(item9);

        tripsAdapter = new TripsAdapter( tripItemData,requireContext().getApplicationContext());
        triprecyclerView.setHasFixedSize(true);
        triprecyclerView.setAdapter(tripsAdapter);
        tripsAdapter.setOnButtonClickListener(this);
        triprecyclerView.setItemViewCacheSize(20);
        triprecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false));
//        SnapHelper snapHelper4 = new PagerSnapHelper();
//        snapHelper4.attachToRecyclerView(tripRecyclerView);

        //Extra
        // topSocietyRecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        //    membershipRecyclerView.setLayoutManager(layoutManager);
        //   trackingLinearLayout = new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false);
        //   membershipRecyclerView.setLayoutManager(membershipLayout);
         // postponeEnterTransition();


        return rootView;
    }

    @NonNull
    private static ArrayList<SeminarItemData> getSeminarItemData() {
        ArrayList<SeminarItemData> seminarItemData = new ArrayList<>();
        SeminarItemData item4 = new SeminarItemData("Gaming Technologies",R.drawable.ai,9000,"Ammer Saeed",R.color.red,R.drawable.mypic,"12:30","SEECS");

        SeminarItemData item5 = new SeminarItemData("Introduction to Virtual Reality",R.drawable.seminar2,1100,"Google",R.color.red,R.drawable.mypic3,"12:30","SEECS");
        SeminarItemData item6 = new SeminarItemData("Gesture Detection",R.drawable.seminar1,300,"Devsync",R.color.red,R.drawable.mypic,"12:30","SEECS");
        seminarItemData.add(item4);
        seminarItemData.add(item5);
        seminarItemData.add(item6);
        return seminarItemData;
    }


    @Override
    public void onButtonClick(int position, String tag) {
        if (tag.equals("seminar")  ) {
            //  Toast.makeText(requireActivity(), "Hello", Toast.LENGTH_SHORT).show();
            Toast.makeText(getActivity(), "Hello", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getActivity(), InfoActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onOneItemButtonClick(int position) {

    }


}
