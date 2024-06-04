package com.sarmadtechempire.recyclerviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class HorizontalRecyclerAdapter extends RecyclerView.Adapter<HorizontalRecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<HorizontalRecyclerModel> horizontalArr;
    HorizontalRecyclerAdapter(Context context, ArrayList<HorizontalRecyclerModel> horizontalArr)
    {
        this.context = context;
        this.horizontalArr = horizontalArr;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item_horizontla_list_view = LayoutInflater.from(context).inflate(R.layout.item_horizontal_list_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(item_horizontla_list_view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.horizontalViewImage.setImageResource(horizontalArr.get(position).img);
        holder.horizontalViewTxtName.setText(horizontalArr.get(position).name);

    }

    @Override
    public int getItemCount() {
        return horizontalArr.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        CircleImageView horizontalViewImage;
        TextView horizontalViewTxtName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            horizontalViewImage = itemView.findViewById(R.id.horizontalViewImage);
            horizontalViewTxtName = itemView.findViewById(R.id.horizontalViewTxtName);

        }
    }
}
