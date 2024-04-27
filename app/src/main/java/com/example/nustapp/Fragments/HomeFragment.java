package com.example.nustapp.Fragments;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.nustapp.Activity.MainActivity;
import com.example.nustapp.Adapter.EventBannerAdapter;
import com.example.nustapp.Adapter.PoductAdapter;
import com.example.nustapp.ItemClasses.EventBannerData;
import com.example.nustapp.ItemClasses.ProductData;
import com.example.nustapp.R;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.example.nustapp.Adapter.EventBannerAdapter;
import com.example.nustapp.Adapter.PoductAdapter;
import com.example.nustapp.Fragments.HomeFragment;
import com.example.nustapp.Fragments.SportsFragment;
import com.example.nustapp.Fragments.TrendFragments;
import com.example.nustapp.Fragments.societyFragment;
import com.example.nustapp.Interfaces.OnButtonClickListener;
import com.example.nustapp.ItemClasses.EventBannerData;
import com.example.nustapp.ItemClasses.ProductData;
import com.example.nustapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;


public class HomeFragment extends Fragment implements  OnButtonClickListener{
    public DrawerLayout drawerLayout;

    public ImageButton actionBarDrawerToggle;
    RecyclerView productrecyclerView;
    RecyclerView eventRecyclerView;
    EventBannerAdapter eventBannerAdapter;
    LinearLayoutManager bannerlinearlayout;
    ConstraintLayout invisibleconstraintlayout;
    PoductAdapter poductAdapter;
    LinearLayoutManager layoutManager;

    public HomeFragment() {
         
    }




    //Drawer(imp)

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        drawerLayout = rootView.findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = rootView.findViewById(R.id.togglebutton);
        productrecyclerView = rootView.findViewById(R.id.productrecyclerview);
        eventRecyclerView = rootView.findViewById(R.id.eventsrecyclerview);

        actionBarDrawerToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });
        //Drawer

        //Sample Data for recyclerView
        ArrayList<ProductData> items = new ArrayList<>();
        ProductData item1 = new ProductData("Sports", "Societies", R.drawable.girl, R.drawable.girl, false, false);
        ProductData item2 = new ProductData("Sports", "Societies", R.drawable.girl, R.drawable.girl, false, false);
        ProductData item3 = new ProductData("Sports", "Societies", R.drawable.girl, R.drawable.girl, false, false);
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item3);
        items.add(item3);
        ////////////////

        // Sample Data for event RecyclerView
        ArrayList<EventBannerData> eventBanneritems = new ArrayList<>();
        EventBannerData item4 = new EventBannerData("Gaming Event", R.drawable.banner_1large, false, 9, "The roar of the dropship engines fades as you land in the sprawli");
        EventBannerData item5 = new EventBannerData("Meow Event", R.drawable.banner_2, false, 69, "The roar of the dropship engines fades as you land in the sprawling desert of World's Edge.  Pinging a nearby triple take sniper, you scramble for high ground with your teammates, a caustic main laying down noxious traps and a nimble Wraith flanking your advance.");
        EventBannerData item6 = new EventBannerData("Mango Event", R.drawable.banner_1large, false, 96, "The roar of the dropship engines fades as you land in the sprawling desert of World's Edge.  Pinging a nearby triple take sniper, you scramble for high ground with your teammates, a caustic main laying down noxious traps and a nimble Wraith flanking your advance.");
        eventBanneritems.add(item4);
        eventBanneritems.add(item5);
        eventBanneritems.add(item6);
        eventBanneritems.add(item6);
        eventBanneritems.add(item6);


        poductAdapter = new PoductAdapter(requireContext().getApplicationContext(), items);
         poductAdapter.setOnButtonClickListener(this);
        productrecyclerView.setAdapter(poductAdapter);
        layoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false);
        productrecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        productrecyclerView.setLayoutManager(layoutManager);
        SnapHelper snapHelper = new PagerSnapHelper(); // or LinearSnapHelper() for smoother scrolling
        snapHelper.attachToRecyclerView(productrecyclerView);


////////second Recycler view (Event banner)
        // Assuming eventRecyclerView is properly initialized
        eventBannerAdapter = new EventBannerAdapter(requireContext().getApplicationContext(), eventBanneritems);
        eventRecyclerView.setAdapter(eventBannerAdapter);
        bannerlinearlayout = new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false);
        eventRecyclerView.setLayoutManager(bannerlinearlayout);
        SnapHelper snapHelper1 = new PagerSnapHelper(); // or LinearSnapHelper() for smoother scrolling
        snapHelper1.attachToRecyclerView(eventRecyclerView);
        return rootView;
    }

    @Override
    public void onButtonClick(int position, String tag) { // tag is Differenting rows while positon differentiating columnes

        if (tag.equals("item1")  ) {
            Toast.makeText(requireActivity(), "Hello", Toast.LENGTH_SHORT).show();
        } else if (tag.equals("item2")) {
            Toast.makeText(requireActivity(), "Meow" + position, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onButtonClick(int position) {

    }

    @Override
    public void LayoutListner(View view) {

    }
}