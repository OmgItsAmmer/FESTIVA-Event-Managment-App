package com.example.nustapp.Fragments;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import com.example.nustapp.Activity.SportTrackerActivity;
import com.example.nustapp.Adapter.MembershipAdapter;
import com.example.nustapp.Adapter.TrackingSportsAdapter;
import com.example.nustapp.Interfaces.OnButtonClickListener;
import com.example.nustapp.ItemClasses.MembershipItemData;
import com.example.nustapp.ItemClasses.TrackingSportsData;
import com.example.nustapp.R;

import java.util.ArrayList;

public class SportsFragment extends Fragment implements OnButtonClickListener {

    public SportsFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sports, container, false);
        RecyclerView trackingRecyclerView;
        RecyclerView membershipRecyclerView;
        MembershipAdapter membershipAdapter;
        TrackingSportsAdapter trackingSportsAdapter;
        LinearLayoutManager trackinglinearlayout;
        LinearLayoutManager membershipLayout;
        CardView cardViewExpandable;
        ConstraintLayout ExpandableprofileLayout;
        LinearLayout ExpandableLinearLayout;
        TextView expandablelastname;


        expandablelastname = rootView.findViewById(R.id.expandablelastname);
        trackingRecyclerView = rootView.findViewById(R.id.trendingRecyclerview);
        membershipRecyclerView = rootView.findViewById(R.id.MembershipRecyclerView);
        cardViewExpandable = rootView.findViewById(R.id.cardviewExpandable);
        ExpandableprofileLayout = rootView.findViewById(R.id.expandableprofilelayout);
        ExpandableLinearLayout = rootView.findViewById(R.id.expandalbeLinearLayout);


        ExpandableLinearLayout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        cardViewExpandable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int visiblilty = (ExpandableprofileLayout.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
                TransitionManager.beginDelayedTransition(ExpandableLinearLayout, new AutoTransition());
                ExpandableprofileLayout.setVisibility(visiblilty);
                expandablelastname.setVisibility(visiblilty);
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
        trackinglinearlayout = new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false);
        trackingRecyclerView.setLayoutManager(trackinglinearlayout);
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
     //   trackinglinearlayout = new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false);
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
