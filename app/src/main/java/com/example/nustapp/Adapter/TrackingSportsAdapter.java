package com.example.nustapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.nustapp.Interfaces.OnButtonClickListener;
import com.example.nustapp.ItemClasses.TrackingSportsData;
import com.example.nustapp.R;

import java.util.ArrayList;

public class TrackingSportsAdapter extends RecyclerView.Adapter<TrackingSportsAdapter.TrackingSportsViewHolder> {


    ArrayList<TrackingSportsData> items = new ArrayList<>();
    Context context;
    OnButtonClickListener mListener;

    public TrackingSportsAdapter(Context context ,ArrayList<TrackingSportsData> items) {
        this.items = items;
        this.context = context;
    }

    public void setOnButtonClickListener(OnButtonClickListener listener) {
        mListener = listener;
    }
    @NonNull
    @Override
    public TrackingSportsAdapter.TrackingSportsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tracking_items,parent,false);
        return new TrackingSportsAdapter.TrackingSportsViewHolder(view,mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackingSportsAdapter.TrackingSportsViewHolder holder, int position) {
        TrackingSportsData trackingSportsDataitem = items.get(position);
        String item1title = trackingSportsDataitem.getItem1Title();
        String item2title = trackingSportsDataitem.getItem2Title();
        holder.trackingitem1title.setText(item1title);
        holder.trackingitem2title.setText(item2title);
        Glide.with(context).load(trackingSportsDataitem.getItem1ImageUrl()).into(holder.trackingitem1image);
        Glide.with(context).load(trackingSportsDataitem.getItem2ImageUrl()).into(holder.trackingitem2image);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class TrackingSportsViewHolder extends RecyclerView.ViewHolder {

        ImageButton trackingitem1image;
        ImageButton trackingitem2image;

        TextView trackingitem1title;
        TextView trackingitem2title;
        CardView item1cardview;

        CardView item2cardview;

        public TrackingSportsViewHolder(@NonNull View itemView, OnButtonClickListener listener) {
            super(itemView);
            trackingitem1image = itemView.findViewById(R.id.trackingitem1image);
            trackingitem2image = itemView.findViewById(R.id.tracking2image);
            trackingitem1title = itemView.findViewById(R.id.trackingitem1title);
            trackingitem2title = itemView.findViewById(R.id.trackingitem2title);
            item1cardview = itemView.findViewById(R.id.trackingitem1);
            item2cardview = itemView.findViewById(R.id.trackingitem2);

            item1cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onButtonClick(position, "item1"); // Pass a tag or identifier to differentiate between the card views
                        }
                    }
                }
            });

            item2cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onButtonClick(position, "item2"); // Pass a tag or identifier to differentiate between the card views
                        }
                    }
                }
            });

        }
    }
}
