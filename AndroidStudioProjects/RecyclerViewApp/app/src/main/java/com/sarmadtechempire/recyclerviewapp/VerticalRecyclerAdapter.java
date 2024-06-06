package com.sarmadtechempire.recyclerviewapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VerticalRecyclerAdapter extends RecyclerView.Adapter<VerticalRecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<VerticalRecyclerModel> verticalArr;

    VerticalRecyclerAdapter(Context context, ArrayList<VerticalRecyclerModel> verticalArr) {
        this.context = context;
        this.verticalArr = verticalArr;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item_vertical_list_view = LayoutInflater.from(context).inflate(R.layout.item_vertical_list_view, parent, false);
        return new ViewHolder(item_vertical_list_view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.verticalListImage.setImageResource(verticalArr.get(position).img);
        holder.verticalListNameText.setText(verticalArr.get(position).name);
        holder.verticalListNumberText.setText(verticalArr.get(position).number);

        holder.vertical_list_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = holder.getAdapterPosition();
                if (currentPosition == RecyclerView.NO_POSITION) {
                    return;
                }

                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_update_lay);

                EditText edtName = dialog.findViewById(R.id.edtName);
                EditText edtNumber = dialog.findViewById(R.id.edtNumber);
                AppCompatButton btnAction = dialog.findViewById(R.id.btnAction);
                TextView txtTitle = dialog.findViewById(R.id.txtTitle);

                txtTitle.setText(R.string.update_contact);
                btnAction.setText(R.string.update);

                edtName.setText(verticalArr.get(currentPosition).name);
                edtNumber.setText(verticalArr.get(currentPosition).number);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = edtName.getText().toString().trim();
                        String number = edtNumber.getText().toString().trim();

                        if (name.isEmpty()) {
                            Toast.makeText(context, "Please Enter Contact Name!", Toast.LENGTH_SHORT).show();
                            return; // Exit if name is empty
                        }

                        if (number.isEmpty()) {
                            Toast.makeText(context, "Please Enter Contact Number!", Toast.LENGTH_SHORT).show();
                            return; // Exit if number is empty
                        }

                        verticalArr.set(currentPosition, new VerticalRecyclerModel(verticalArr.get(currentPosition).img, name, number));
                        notifyItemChanged(currentPosition);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        holder.vertical_list_layout.setOnLongClickListener(new View.OnLongClickListener() {
            int currentPosition = holder.getAdapterPosition();
            @Override
            public boolean onLongClick(View v) {
                AlertDialog .Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Contact")
                        .setMessage("Are you sure you want to delete ?")
                        .setIcon(R.drawable.icons8_delete)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                verticalArr.remove(currentPosition);
                                notifyItemRemoved(currentPosition);

                            }
                        })

                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                builder.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return verticalArr.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView verticalListImage;
        TextView verticalListNameText, verticalListNumberText;
        RelativeLayout vertical_list_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            verticalListImage = itemView.findViewById(R.id.verticalListImage);
            verticalListNameText = itemView.findViewById(R.id.verticalListNameText);
            verticalListNumberText = itemView.findViewById(R.id.verticalListNumberText);
            vertical_list_layout = itemView.findViewById(R.id.vertical_list_layout);
        }
    }
}
