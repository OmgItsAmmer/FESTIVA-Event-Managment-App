package com.example.nustapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.nustapp.Interfaces.OnButtonClickListener;
import com.example.nustapp.ItemClasses.ProductData;
import com.example.nustapp.ItemClasses.SeeAllSocietiesItemData;
import com.example.nustapp.R;

import java.util.ArrayList;

public class SeeAllSocietiesAdapter extends RecyclerView.Adapter<SeeAllSocietiesAdapter.SeeAllSocietyViewHolder> {

    ArrayList<SeeAllSocietiesItemData> items = new ArrayList<>();

    Context context;

    public SeeAllSocietiesAdapter(ArrayList<SeeAllSocietiesItemData> items, Context context) {
        this.items = items;
        this.context = context;
    }

    OnButtonClickListener mListener; // not in constructor



    public void setOnButtonClickListener(OnButtonClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public SeeAllSocietiesAdapter.SeeAllSocietyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.seeall_societies_item_layout,parent,false);
        return new SeeAllSocietiesAdapter.SeeAllSocietyViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SeeAllSocietiesAdapter.SeeAllSocietyViewHolder holder, int position) {

        SeeAllSocietiesItemData seeAllSocietiesItemData = items.get(position);
        holder.societyTitle.setText(seeAllSocietiesItemData.getSocietyName());
        Glide.with(context).load(seeAllSocietiesItemData.getBannerURl()).into(holder.banner);
        Glide.with(context).load(seeAllSocietiesItemData.getHiringUrl()).into(holder.hiringImage);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class SeeAllSocietyViewHolder extends RecyclerView.ViewHolder {

        TextView societyTitle;
        ImageView banner;
        ImageView hiringImage;
        public SeeAllSocietyViewHolder(@NonNull View itemView,OnButtonClickListener listener) {
            super(itemView);
            societyTitle = itemView.findViewById(R.id.seeallsocietytitle);
            banner = itemView.findViewById(R.id.seeallsocietyiamge);
            hiringImage = itemView.findViewById(R.id.seeallsocietyhiring);

        }
    }
}
