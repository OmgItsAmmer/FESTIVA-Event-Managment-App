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
import com.example.nustapp.ItemClasses.SeminarItemData;
import com.example.nustapp.ItemClasses.TopSocietyData;
import com.example.nustapp.R;

import java.util.ArrayList;

public class SeminarAdapter extends RecyclerView.Adapter<SeminarAdapter.SeminarViewHolder> {

    ArrayList<SeminarItemData> items = new ArrayList<>();
    Context context;
    OnButtonClickListener mListener;

    public SeminarAdapter(ArrayList<SeminarItemData> items, Context context) {
        this.items = items;
        this.context = context;
    }

    public void setOnButtonClickListener(OnButtonClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public SeminarAdapter.SeminarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.seminar_item_layout,parent,false);
        return new SeminarAdapter.SeminarViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SeminarAdapter.SeminarViewHolder holder, int position) {
        SeminarItemData seminarItemData = items.get(position);
        String eventTitle = seminarItemData.getEventTitle();
        holder.seminarEventTitle.setText(eventTitle);
        int membersNo = seminarItemData.getInterestedOrMembers();
        holder.seminarEnrolled.setText("Enrolled: " + membersNo);
        int bannerColor = seminarItemData.getBannerColor();
       //  holder.BannerColor.setBackgroundColor(bannerColor); (not working yet)
        String seminarTiming = seminarItemData.getTimingSeminar();
        String seminarAddress = seminarItemData.getSeminarAddress();
        holder.seminarAddress.setText("Address: " +seminarAddress);
        holder.timingSeminar.setText("Timing: " +seminarTiming);
        String authorName = seminarItemData.getAuthorName();
        holder.authorName.setText(authorName);
      //  int bannerUrl = seminarItemData.getImageUrl();
      //  int profilePic = seminarItemData.getProflePic(); (coded inside Glide)

        Glide.with(context).load(seminarItemData.getImageUrl()).into(holder.Banner);
        Glide.with(context).load(seminarItemData.getProflePic()).into(holder.profilePic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class SeminarViewHolder extends RecyclerView.ViewHolder {

        TextView authorName;
        TextView seminarEnrolled;

        TextView timingSeminar;

        TextView seminarEventTitle;

        TextView seminarAddress;

        ImageView profilePic;

        ImageView Banner;
        CardView BannerColor;
        public SeminarViewHolder(@NonNull View itemView, OnButtonClickListener listener) {
            super(itemView);
            seminarEventTitle = itemView.findViewById(R.id.seminareventtitle);
            authorName = itemView.findViewById(R.id.seminarauthorname);
            timingSeminar = itemView.findViewById(R.id.seminartiming);
            seminarAddress = itemView.findViewById(R.id.seminaraddress);
            profilePic = itemView.findViewById(R.id.seminarprofilepic);
            Banner = itemView.findViewById(R.id.seminarbannerImage);
            BannerColor = itemView.findViewById(R.id.seminarcardlayout);
            seminarEnrolled =itemView.findViewById(R.id.seminarintresetedtxt);

        }
    }
}
