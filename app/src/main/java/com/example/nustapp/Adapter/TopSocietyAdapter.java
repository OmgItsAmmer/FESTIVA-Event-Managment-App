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
import com.example.nustapp.ItemClasses.TopSocietyData;
import com.example.nustapp.R;

import java.util.ArrayList;

public class TopSocietyAdapter extends RecyclerView.Adapter<TopSocietyAdapter.TopSocietyViewHolder> {

    ArrayList<TopSocietyData> items = new ArrayList<>();
    Context context;

    public TopSocietyAdapter(Context context,ArrayList<TopSocietyData> items ) {
        this.items = items;
        this.context = context;
    }

    OnButtonClickListener mListener;



    public void setOnButtonClickListener(OnButtonClickListener listener) {
        mListener = listener;
    }
    @NonNull
    @Override
    public TopSocietyAdapter.TopSocietyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.top_societies_item,parent,false);
        return new TopSocietyAdapter.TopSocietyViewHolder(view, mListener);

    }

    @Override
    public void onBindViewHolder(@NonNull TopSocietyAdapter.TopSocietyViewHolder holder, int position) {
        TopSocietyData topSocietyData = items.get(position);
        String eventTitle = topSocietyData.getEventTitle();
        holder.topSocietyEventTitle.setText(eventTitle);
        int membersNo = topSocietyData.getInterestedOrMembers();
        holder.topSocietyMembersNo.setText("Members: " + membersNo);

        int bannerUrl = topSocietyData.getImageUrl();
        int HiringUrl = topSocietyData.getHiringUrl();

        Glide.with(context).load(topSocietyData.getImageUrl()).into(holder.topSocietyimage);


        boolean HiringFlag = topSocietyData.isHiringflag();

        if(HiringFlag)
        {
            Glide.with(context).load(topSocietyData.getHiringUrl()).into(holder.topSocietyHiring);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class TopSocietyViewHolder extends RecyclerView.ViewHolder {

        TextView topSocietyEventTitle;

        TextView topSocietyMembersNo;

        ImageView topSocietyimage;

        ImageView topSocietyHiring;


        public TopSocietyViewHolder(@NonNull View itemView, OnButtonClickListener listener) {
            super(itemView);

            topSocietyEventTitle = itemView.findViewById(R.id.topsocietyeventtitle);
            topSocietyMembersNo = itemView.findViewById(R.id.topsocietyintresetedtxt);
             topSocietyimage= itemView.findViewById(R.id.topsocietybannerImage);
             topSocietyHiring= itemView.findViewById(R.id.topsocietyhiringimage);
        }
    }
}
