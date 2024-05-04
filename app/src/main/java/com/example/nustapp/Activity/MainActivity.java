package com.example.nustapp.Activity;

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

public class MainActivity extends AppCompatActivity implements  BottomNavigationView.OnNavigationItemSelectedListener {





    CardView temp;

    BottomNavigationView bottomNavigationView;

    societyFragment societyFragment = new societyFragment();
    SportsFragment sportsFragment = new SportsFragment();
    TrendFragments trendFragments = new TrendFragments();
    HomeFragment homeFragment = new HomeFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView
                .setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.Home);



        getWindow().setNavigationBarColor(getResources().getColor(R.color.babyblue));





    }
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }






    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int itemId = menuItem.getItemId();


        if (itemId == R.id.society && !(menuItem.isChecked())) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                 //   .setCustomAnimations(R.anim.enter_left_to_right,R.anim.exit_right_to_left,R.anim.exit_right_to_left,R.anim.exit_left_to_right)
                    .replace(R.id.flFragment, societyFragment)
                    .commit();

            return true;
        } else if (itemId == R.id.sports && !(menuItem.isChecked())) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                  //  .setCustomAnimations(R.anim.enter_left_to_right,R.anim.exit_right_to_left,R.anim.exit_right_to_left,R.anim.exit_left_to_right)
                    .replace(R.id.flFragment, sportsFragment)
                    .commit();

            return true;
        } else if (itemId == R.id.trends && !(menuItem.isChecked())) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                  //  .setCustomAnimations(R.anim.exit_right_to_left, R.anim.enter_left_to_right,R.anim.exit_right_to_left,R.anim.exit_left_to_right)
                    .replace(R.id.flFragment, trendFragments)
                    .commit();

            return true;
    }
        else if (itemId== R.id.Home) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                //    .setCustomAnimations(R.anim.enter_left_to_right,R.anim.exit_right_to_left,R.anim.exit_right_to_left,R.anim.exit_left_to_right)
                    .replace(R.id.flFragment, homeFragment)
                    .commit();


            return true;

        }
        {
            return false; // Return false for any unhandled menu items
        }
    }



}