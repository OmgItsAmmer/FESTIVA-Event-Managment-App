package com.example.nustapp.Interfaces;

import android.view.View;

public interface OnButtonClickListener {
    void onButtonClick(int position,String tag);
    void onButtonClick(int position);

    void LayoutListner(View view);
}
