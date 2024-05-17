package com.example.nustapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nustapp.Interfaces.OnButtonClickListener;
import com.example.nustapp.ItemClasses.TrackerSportsItemData;
import com.example.nustapp.R;

import java.util.ArrayList;

public class TrackerSportsAdapter extends RecyclerView.Adapter<TrackerSportsAdapter.TrackerSportsViewHolder> {

    ArrayList<TrackerSportsItemData> items  = new ArrayList<>();
    Context context;
    OnButtonClickListener mListener;


    public TrackerSportsAdapter(ArrayList<TrackerSportsItemData> items, Context context, OnButtonClickListener mListener) {
        this.items = items;
        this.context = context;
        this.mListener = mListener;
    }

    public void setOnButtonClickListener(OnButtonClickListener listener) {
        mListener = listener;
    }


    @NonNull
    @Override
    public TrackerSportsAdapter.TrackerSportsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tracker_item_layout,parent,false);
        return new TrackerSportsAdapter.TrackerSportsViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackerSportsAdapter.TrackerSportsViewHolder holder, @SuppressLint("RecyclerView") int position) {
        TrackerSportsItemData trackingSportsData = items.get(position);
        holder.groundName.setText(trackingSportsData.getGroundName());
        holder.groundStatus.setText("Players: " + trackingSportsData.getStatus());
        Boolean isExpandable = trackingSportsData.getExpandable();
        holder.reservation.setText("Reservation");
        holder.booking.setText("Booking");
        holder.reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    //    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mListener.onButtonClick(position, "reservation"); // Pass a tag or identifier to differentiate between the card views
                    }
                }
            }
        });

        holder.booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    // int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mListener.onButtonClick(position, "booking"); // Pass a tag or identifier to differentiate between the card views
                    }
                }
            }
        });

        holder.waiting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    // int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mListener.onButtonClick(position, "waiting"); // Pass a tag or identifier to differentiate between the card views
                    }
                }

            }
        });

        holder.cancelReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    // int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mListener.onButtonClick(position, "cancelreservation"); // Pass a tag or identifier to differentiate between the card views
                    }
                }

            }
        });


        if (trackingSportsData.isExpandable) {
            holder.expandableConstraintLayout.setVisibility(View.VISIBLE);
        } else {
            holder.expandableConstraintLayout.setVisibility(View.GONE);
        }

        holder.Trackerexpandablecardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                trackingSportsData.isExpandable = !trackingSportsData.isExpandable;
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class TrackerSportsViewHolder extends RecyclerView.ViewHolder {

        TextView groundName;
        TextView groundStatus;

        TextView avability;

        Button reservation;
        Button booking;
        Button waiting;
        Button cancelReservation;

        LinearLayout expnadableLinearlayoutTracker;

        ConstraintLayout expandableConstraintLayout;

        CardView Trackerexpandablecardview;
        public TrackerSportsViewHolder(@NonNull View itemView, OnButtonClickListener listener) {
            super(itemView);
            groundName = itemView.findViewById(R.id.groundname);
            groundStatus = itemView.findViewById(R.id.Trackerplayersno);
          //  avability = itemView.findViewById(R.id.trackerstatus);
            reservation = itemView.findViewById(R.id.reservationButton);
            booking = itemView.findViewById(R.id.booking);
            waiting = itemView.findViewById(R.id.waitingbtn);
            cancelReservation = itemView.findViewById(R.id.cancelreservation);
            expnadableLinearlayoutTracker = itemView.findViewById(R.id.TrackerextendableLinearLayout);
             expandableConstraintLayout = itemView.findViewById(R.id.Trackerextendableconstraintlayout);
            Trackerexpandablecardview = itemView.findViewById(R.id.Trackerexpandablecardview);



        }
    }
}
