package com.sarmadtechempire.recyclerviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ViewHolder> {

    Context context;
    ArrayList<ContactModel> arrContacts;

    ContactListAdapter(Context context, ArrayList<ContactModel> arrContacts)
    {
        this.context = context;
        this.arrContacts = arrContacts;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item_contactlist_view =LayoutInflater.from(context).inflate(R.layout.item_contact_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(item_contactlist_view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.Contact_Image.setImageResource(arrContacts.get(position).img);
        holder.txtName.setText(arrContacts.get(position).name);
        holder.txtNumber.setText(arrContacts.get(position).number);

    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtName, txtNumber;
        ImageView Contact_Image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            Contact_Image = itemView.findViewById(R.id.Contact_Image);
        }
    }
}
