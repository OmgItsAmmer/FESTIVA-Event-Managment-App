package com.example.nustapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.nustapp.Interfaces.OnButtonClickListener;
import com.example.nustapp.R;

public class societyFragment extends Fragment implements OnButtonClickListener {

    public societyFragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_society, container, false);
    }


    @Override
    public void onButtonClick(int position, String tag) {

    }

    @Override
    public void onButtonClick(int position) {

    }

    @Override
    public void LayoutListner(View view) {

    }
}
