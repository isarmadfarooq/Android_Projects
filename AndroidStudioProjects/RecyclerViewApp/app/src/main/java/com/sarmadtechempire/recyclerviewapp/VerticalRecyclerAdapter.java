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

public class VerticalRecyclerAdapter extends RecyclerView.Adapter<VerticalRecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<VerticalRecyclerModel> verticalArr;

    VerticalRecyclerAdapter(Context context, ArrayList<VerticalRecyclerModel> verticalArr )
    {
        this.context = context;
        this.verticalArr = verticalArr;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item_vertical_list_view = LayoutInflater.from(context).inflate(R.layout.item_vertical_list_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(item_vertical_list_view);
        return viewHolder;
     }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.verticalListImage.setImageResource(verticalArr.get(position).img);
        holder.verticalListNameText.setText(verticalArr.get(position).name);
        holder.verticalListNumberText.setText(verticalArr.get(position).number);
    }

    @Override
    public int getItemCount() {
        return verticalArr.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView verticalListImage;
        TextView verticalListNameText, verticalListNumberText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            verticalListImage = itemView.findViewById(R.id.verticalListImage);
            verticalListNameText = itemView.findViewById(R.id.verticalListNameText);
            verticalListNumberText = itemView.findViewById(R.id.verticalListNumberText);
        }
    }
}
