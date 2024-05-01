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
import com.example.nustapp.ItemClasses.TripItemData;
import com.example.nustapp.R;

import java.util.ArrayList;

public class TripsAdapter extends RecyclerView.Adapter<TripsAdapter.TripsViewHolder> {

    ArrayList<TripItemData> items = new ArrayList<>();
    Context context;

    OnButtonClickListener mListener;

    public void setOnButtonClickListener(OnButtonClickListener listener) {
        mListener = listener;
    }

    public TripsAdapter(ArrayList<TripItemData> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public TripsAdapter.TripsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.trips_item_layout,parent,false);
        return new TripsAdapter.TripsViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TripsAdapter.TripsViewHolder holder, int position) {
        TripItemData tripItemData = items.get(position);
        String tripTitle = tripItemData.getTripTitle();
        String tripDate = tripItemData.getTripDate();
        String tripDateValid = tripItemData.getValidTripDate();
        String tripBy = tripItemData.getTripBy();
        holder.tripTitle.setText(tripTitle);
        holder.tripDate.setText(tripDate);
        holder.tripValidTill.setText(tripDateValid);
        holder.tripBy.setText(tripBy);

        Glide.with(context).load(tripItemData.getImageUrl()).into(holder.tripImage);





    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class TripsViewHolder extends RecyclerView.ViewHolder {

        TextView tripTitle;

        TextView tripDate;
        TextView tripValidTill;

        TextView tripBy;

        ImageView tripImage;
        public TripsViewHolder(@NonNull View itemView,OnButtonClickListener listener) {
            super(itemView);
            tripTitle = itemView.findViewById(R.id.triptitle);
            tripDate = itemView.findViewById(R.id.tripdate);
            tripBy = itemView.findViewById(R.id.tripby);
            tripValidTill = itemView.findViewById(R.id.tripvalidtill);
            tripImage  = itemView.findViewById(R.id.tripImage);

        }
    }
}
