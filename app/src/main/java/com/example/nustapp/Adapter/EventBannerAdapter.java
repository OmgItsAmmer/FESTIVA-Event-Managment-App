package com.example.nustapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.nustapp.Interfaces.OnButtonClickListener;
import com.example.nustapp.ItemClasses.EventBannerData;
import com.example.nustapp.R;

import java.util.ArrayList;

public class EventBannerAdapter extends RecyclerView.Adapter<EventBannerAdapter.EventBannerViewHolder> {

    ArrayList<EventBannerData> items = new ArrayList<>();
    Context context;
    OnButtonClickListener mListener;

    public EventBannerAdapter(Context context, ArrayList<EventBannerData> items) {
        this.items = items;
        this.context = context;
    }

    public void setOnButtonClickListener(OnButtonClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public EventBannerAdapter.EventBannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.event_banner_item, parent, false);
        return new EventBannerAdapter.EventBannerViewHolder(view, mListener);


    }

    @Override
    public void onBindViewHolder(@NonNull EventBannerAdapter.EventBannerViewHolder holder, int position) {
        EventBannerData itemData = items.get(position);
        String eventTitle = itemData.getEventTitle();
        int intresetedNo = itemData.getIntresetedNo();
        int bannerUrl = itemData.getBannerUrl();
        holder.eventTitle.setText(eventTitle);
        String eventDesription = itemData.getEventdesription();
        holder.eventDescription.setText(eventDesription);
        holder.intresetedtxt.setText("Intreseted: " + intresetedNo);
        Glide.with(context).load(itemData.getBannerUrl()).into(holder.bannerImage);
        boolean isExpandable = itemData.isExpandable();
        if (isExpandable) {
            holder.eventDescription.setVisibility(View.VISIBLE);
        } else {
            holder.eventDescription.setVisibility(View.GONE);
        }

        holder.ExpandableLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                itemData.isExpandable = !itemData.isExpandable;
                notifyDataSetChanged();
            }
        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class EventBannerViewHolder extends RecyclerView.ViewHolder {
        ImageView bannerImage;
        TextView eventDescription;
        TextView eventTitle;


        TextView intresetedtxt;
        RelativeLayout ExpandableLayout;

        public EventBannerViewHolder(@NonNull View itemView, OnButtonClickListener listener) {
            super(itemView);
            bannerImage = itemView.findViewById(R.id.bannerImage);
            eventDescription = itemView.findViewById(R.id.eventdesription);
            eventTitle = itemView.findViewById(R.id.eventtitle);
            intresetedtxt = itemView.findViewById(R.id.intresetedtxt);
            ExpandableLayout = itemView.findViewById(R.id.ExpandableLayout);
        }
    }
}

