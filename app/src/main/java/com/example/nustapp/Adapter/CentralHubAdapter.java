package com.example.nustapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.nustapp.Interfaces.OnButtonClickListener;
import com.example.nustapp.ItemClasses.CentralHubItemData;
import com.example.nustapp.R;

import java.util.ArrayList;

public class CentralHubAdapter extends RecyclerView.Adapter<CentralHubAdapter.CentralHubViewHolder> {


    ArrayList <CentralHubItemData> items = new ArrayList<>();
    Context context;

    public CentralHubAdapter(ArrayList<CentralHubItemData> items, Context context) {
        this.items = items;
        this.context = context;
    }

    OnButtonClickListener mListener; // not in constructor



    public void setOnButtonClickListener(OnButtonClickListener listener) {
        mListener = listener;
    }



    @NonNull
    @Override
    public CentralHubAdapter.CentralHubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.central_hub_item,parent,false);
        return new CentralHubAdapter.CentralHubViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CentralHubAdapter.CentralHubViewHolder holder, int position) {

        CentralHubItemData itemData = items.get(position);
        String eventTitle = itemData.getEventTitle();
        int imageUrl = itemData.getImageUrl();
        holder.centralTitle.setText(eventTitle);
        Glide.with(context).load(imageUrl).into(holder.centralImageUrl);


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class CentralHubViewHolder extends RecyclerView.ViewHolder {

        ImageView centralImageUrl;

        TextView centralTitle;
        CardView centralcardview;
        public CentralHubViewHolder(@NonNull View itemView, OnButtonClickListener listener) {
            super(itemView);
            centralTitle = itemView.findViewById(R.id.centraltitle);
            centralImageUrl = itemView.findViewById(R.id.centralimage);
            centralcardview = itemView.findViewById(R.id.centralcardview);

            centralcardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {

                            listener.onOneItemButtonClick(position); // Pass a tag or identifier to differentiate between the card views
                        }
                    }
                }
            });



        }
    }
}
