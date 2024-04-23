package com.example.nustapp.Adapter;

import android.content.Context;
import android.graphics.Color;
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
import com.example.nustapp.ItemClasses.ProductData;
import com.example.nustapp.R;

import java.util.ArrayList;

public class PoductAdapter extends RecyclerView.Adapter<PoductAdapter.ProductViewHolder> {

    ArrayList<ProductData> items = new ArrayList<>();
    Context context;

    OnButtonClickListener mListener; // not in constructor

    public PoductAdapter(Context context, ArrayList<ProductData> items) {
        this.items = items;
        this.context = context;
    }

    public void setOnButtonClickListener(OnButtonClickListener listener) {
        mListener = listener;
    }


    @NonNull
    @Override
    public PoductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.productitem,parent,false);
        return new PoductAdapter.ProductViewHolder(view, mListener);

    }

    @Override
    public void onBindViewHolder(@NonNull PoductAdapter.ProductViewHolder holder, int position) {
        ProductData itemData = items.get(position);
        String item1title = itemData.getItem1title();
        String item2title = itemData.getItem2title();
        Boolean item1Status = itemData.getItem1lightStatus();
        Boolean item2Status = itemData.getItem2lightStatus();
        holder.item1title.setText(item1title);
        holder.item2title.setText(item2title);

        holder.item1Status.setTextColor(Color.BLACK);
        holder.item2Status.setTextColor(Color.BLACK);

        //Extra
        holder.item1Status.setText("");
        holder.item2Status.setText("");
//

        Glide.with(context).load(itemData.getFirstImageUrl()).into(holder.item1Image);
        Glide.with(context).load(itemData.getSecondImageUrl()).into(holder.item2Image); // create viewholder variable item1Image
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{

        ImageView item1Image;
        ImageView item2Image;

        TextView item1title;
        TextView item2title;

        TextView item1Status;
        TextView item2Status;
        CardView item1cardview;
        CardView item2cardview;
        public ProductViewHolder(@NonNull View itemView,OnButtonClickListener listener) {
            super(itemView);
            item1Image = itemView.findViewById(R.id.item1image);
            item2Image = itemView.findViewById(R.id.item2image);
            item1title = itemView.findViewById(R.id.item1titleproduct);
            item2title = itemView.findViewById(R.id.item2titleproduct);
            item1Status = itemView.findViewById(R.id.item1Status);
            item2Status = itemView.findViewById(R.id.item2Status);
            item1cardview = itemView.findViewById(R.id.item1cardview);
            item2cardview = itemView.findViewById(R.id.item2cardview);

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
