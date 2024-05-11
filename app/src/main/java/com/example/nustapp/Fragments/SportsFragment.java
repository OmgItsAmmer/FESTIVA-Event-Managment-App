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

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.bumptech.glide.Glide;
import com.example.nustapp.Activity.SportTrackerActivity;
import com.example.nustapp.Adapter.MembershipAdapter;
import com.example.nustapp.Adapter.TrackingSportsAdapter;
import com.example.nustapp.Interfaces.OnButtonClickListener;
import com.example.nustapp.ItemClasses.MembershipItemData;
import com.example.nustapp.ItemClasses.TrackingSportsData;
import com.example.nustapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Objects;

public class SportsFragment extends Fragment implements OnButtonClickListener {

    ImageButton userImage;
    public SportsFragment(){

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sports, container, false);
        RecyclerView trackingRecyclerView;
        RecyclerView membershipRecyclerView;
        MembershipAdapter membershipAdapter;
        TrackingSportsAdapter trackingSportsAdapter;
        LinearLayoutManager trackingLinearLayout;
        LinearLayoutManager membershipLayout;
        CardView cardViewExpandable;
        ConstraintLayout expandableProfileLayout;
        LinearLayout expandableLinearLayout;
        TextView expandableLastName;

        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("profileImages/").child(Objects.requireNonNull(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getEmail()));


        expandableLastName = rootView.findViewById(R.id.expandablelastname);
        trackingRecyclerView = rootView.findViewById(R.id.trendingRecyclerview);
        membershipRecyclerView = rootView.findViewById(R.id.MembershipRecyclerView);
        cardViewExpandable = rootView.findViewById(R.id.cardviewExpandable);
        expandableProfileLayout = rootView.findViewById(R.id.expandableprofilelayout);
        expandableLinearLayout = rootView.findViewById(R.id.expandalbeLinearLayout);
        userImage = rootView.findViewById(R.id.userImage);

        storageReference.getDownloadUrl().addOnSuccessListener(uri -> Glide.with(SportsFragment.this).load(uri).into(userImage)).addOnFailureListener(e -> Toast.makeText(getActivity(), "Error loading image from Database", Toast.LENGTH_SHORT).show());

        expandableLinearLayout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        cardViewExpandable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int visibility = (expandableProfileLayout.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
                TransitionManager.beginDelayedTransition(expandableLinearLayout, new AutoTransition());
                expandableProfileLayout.setVisibility(visibility);
                expandableLastName.setVisibility(visibility);
            }
        });






        //Sample Data
        ArrayList<TrackingSportsData> trackingSportsitems = new ArrayList<>();
        TrackingSportsData item1 = new TrackingSportsData("Cricket" , "Dance" , R.drawable.cricket , R.drawable.dance);
        TrackingSportsData item2 = new TrackingSportsData("Cricket" , "Dance" , R.drawable.cricket , R.drawable.dance);
        TrackingSportsData item3 = new TrackingSportsData("Cricket" , "Dance" , R.drawable.cricket , R.drawable.dance);
        trackingSportsitems.add(item1);
        trackingSportsitems.add(item2);
        trackingSportsitems.add(item3);
        /////////

        trackingSportsAdapter = new TrackingSportsAdapter(requireContext().getApplicationContext(), trackingSportsitems);
        trackingRecyclerView.setAdapter(trackingSportsAdapter);
        trackingSportsAdapter.setOnButtonClickListener(this);
        trackingLinearLayout = new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false);
        trackingRecyclerView.setLayoutManager(trackingLinearLayout);
        SnapHelper snapHelper1 = new PagerSnapHelper(); // or LinearSnapHelper() for smoother scrolling
        snapHelper1.attachToRecyclerView(trackingRecyclerView);

        ArrayList<MembershipItemData> membershipItemData = new ArrayList<>();

        MembershipItemData item4 = new MembershipItemData("Swimming pool", R.drawable.swim, false, 700);
        MembershipItemData item5 = new MembershipItemData("Saddle Club", R.drawable.horseriding, false, 800);
        MembershipItemData item6 = new MembershipItemData("Gym", R.drawable.gym, false, 1100 );

        membershipItemData.add(item4);
        membershipItemData.add(item5);
        membershipItemData.add(item6);

        membershipAdapter = new MembershipAdapter(requireContext().getApplicationContext(), membershipItemData);
        membershipRecyclerView.setAdapter(membershipAdapter);
        membershipAdapter.setOnButtonClickListener(this);
        membershipRecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
    //    membershipRecyclerView.setLayoutManager(layoutManager);
     //   trackingLinearLayout = new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false);
     //   membershipRecyclerView.setLayoutManager(membershipLayout);
        SnapHelper snapHelper2 = new PagerSnapHelper(); // or LinearSnapHelper() for smoother scrolling
        snapHelper2.attachToRecyclerView(membershipRecyclerView);


    //    postponeEnterTransition();

        return rootView;
    }

    @Override
    public void onButtonClick(int position, String tag) {
        if (tag.equals("item1")  ) {
          //  Toast.makeText(requireActivity(), "Hello", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getActivity(),SportTrackerActivity.class);
            startActivity(intent);
        } else if (tag.equals("item2")) {
            Toast.makeText(requireActivity(), "Meow", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onOneItemButtonClick(int position) {

    }


}
