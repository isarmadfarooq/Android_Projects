package com.sarmadtechempire.contactbook.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sarmadtechempire.contactbook.R;
import com.sarmadtechempire.contactbook.activity.model.HomeContactRecyclerModel;

import java.util.ArrayList;

public class HomeContactAdapter extends RecyclerView.Adapter<HomeContactAdapter.ViewHolder> {

    Context context;
    ArrayList<HomeContactRecyclerModel> contactArr;
     public HomeContactAdapter(Context context, ArrayList<HomeContactRecyclerModel> contactArr)
    {
        this.context = context;
        this.contactArr = contactArr;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View homeContactRecyclerModel = LayoutInflater.from(context).inflate(R.layout.item_vertical_list_view,parent,false);
        return new ViewHolder(homeContactRecyclerModel);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.verticalListImage.setImageResource(contactArr.get(position).img);
        holder.verticalListNameText.setText(contactArr.get(position).name);
        holder.verticalListNumberText.setText(contactArr.get(position).number);

    }

    @Override
    public int getItemCount() {
        return contactArr.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView verticalListImage;
        TextView verticalListNameText;
        TextView verticalListNumberText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            verticalListImage = itemView.findViewById(R.id.verticalListImage);
            verticalListNameText = itemView.findViewById(R.id.verticalListNameText);
            verticalListNumberText = itemView.findViewById(R.id.verticalListNumberText);
        }
    }
}
