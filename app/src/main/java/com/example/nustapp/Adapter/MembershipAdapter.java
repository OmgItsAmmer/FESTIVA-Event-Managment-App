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
import com.example.nustapp.ItemClasses.MembershipItemData;
import com.example.nustapp.R;

import java.util.ArrayList;

public class MembershipAdapter extends RecyclerView.Adapter<MembershipAdapter.MembershipViewHolder> {

    ArrayList<MembershipItemData> items = new ArrayList<>();

    Context context;

    OnButtonClickListener mListener;

    public MembershipAdapter(Context context,ArrayList<MembershipItemData> items) {
        this.items = items;
        this.context = context;
    }

    public void setOnButtonClickListener(OnButtonClickListener listener) {
        mListener = listener;
    }


    @NonNull
    @Override
    public MembershipAdapter.MembershipViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.membership_item,parent,false);
        return new MembershipAdapter.MembershipViewHolder(view,mListener);


    }

    @Override
    public void onBindViewHolder(@NonNull MembershipAdapter.MembershipViewHolder holder, int position) {

        MembershipItemData membershipItemData = items.get(position);
        String eventTitle = membershipItemData.getMembersshipEventTitle();
        holder.membershipEventTitle.setText(eventTitle);
        int intresetedNo = membershipItemData.getMembersshipNo();
        holder.membershipIntresetedtxt.setText("Members Joined: " + intresetedNo);
        Glide.with(context).load(membershipItemData.getMembersshipBannerUrl()).into(holder.membershipBannerImage);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MembershipViewHolder extends RecyclerView.ViewHolder {

        ImageView membershipBannerImage;

        TextView membershipEventTitle;

        TextView membershipIntresetedtxt;
        RelativeLayout membershipExpandableLayout;
        public MembershipViewHolder(@NonNull View itemView, OnButtonClickListener listener) {
            super(itemView);
            membershipBannerImage = itemView.findViewById(R.id.membersshipbannerImage);

            membershipEventTitle = itemView.findViewById(R.id.membersshipeventtitle);
            membershipIntresetedtxt = itemView.findViewById(R.id.membersshipintresetedtxt);
            membershipExpandableLayout = itemView.findViewById(R.id.membersshipExpandableLayout);
        }
    }
}
