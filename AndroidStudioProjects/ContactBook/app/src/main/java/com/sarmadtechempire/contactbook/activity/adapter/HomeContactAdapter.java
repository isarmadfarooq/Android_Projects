package com.sarmadtechempire.contactbook.activity.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.sarmadtechempire.contactbook.R;
import com.sarmadtechempire.contactbook.activity.NotificationUtils;
import com.sarmadtechempire.contactbook.activity.model.HomeContactRecyclerModel;

import java.util.ArrayList;

public class HomeContactAdapter extends RecyclerView.Adapter<HomeContactAdapter.ViewHolder> {

    Context context;
    ArrayList<HomeContactRecyclerModel> contactArr;
    private int lastPosition = - 1;


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

        setAnimation(holder.itemView, position);

        holder.btn_Dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = holder.getAdapterPosition();
                if (currentPosition == RecyclerView.NO_POSITION) {
                    return;
                }
                Intent iDial = new Intent(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel:" + contactArr.get(currentPosition).number));
                context.startActivity(iDial);

            }
        });

        holder.btn_Msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = holder.getAdapterPosition();
                if (currentPosition == RecyclerView.NO_POSITION) {
                    return;
                }
                Intent iMsg = new Intent(Intent.ACTION_SENDTO);
                iMsg.setData(Uri.parse("smsto:" +Uri.encode(contactArr.get(currentPosition).number)));
                iMsg.putExtra("sms_body", "Please solve this issue asap.");
                context.startActivity(iMsg);
            }
        });

        holder.btn_Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = holder.getAdapterPosition();
                if(currentPosition == RecyclerView.NO_POSITION)
                {
                    return;
                }
                Intent iEmail = new Intent(Intent.ACTION_SEND);
                iEmail.setType("message/rfc822");
                iEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"i.sarmadfarooq@gmail.com", "areebfarooq98@gmail.com"});
                iEmail.putExtra(Intent.EXTRA_SUBJECT, "Contact Issue");
                iEmail.putExtra(Intent.EXTRA_TEXT, "Please solve this issue asap.");
                context.startActivity(Intent.createChooser(iEmail, "Email via"));
            }
        });

        holder.btn_Share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = holder.getAdapterPosition();
                if(currentPosition == RecyclerView.NO_POSITION)
                {
                    return;
                }
                Intent iShare = new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT,"https://github.com/isarmadfarooq/Android_Projects/tree/main/AndroidStudioProjects/CustomDialogExample/app/src");
                context.startActivity(Intent.createChooser(iShare, "Share via"));

            }
        });

        holder.verticalListLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = holder.getAdapterPosition();
                if(currentPosition == RecyclerView.NO_POSITION)
                {
                    return;
                }

                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_add_edit_contact);

                EditText dialogEditTxtName = dialog.findViewById(R.id.dialogEdtTxtName);
                EditText dialogEditTxtNumber = dialog.findViewById(R.id.dialogEdtTxtNumber);
                AppCompatButton dialogBtnAction = dialog.findViewById(R.id.dialogBtnAction);
                TextView dialogTxtTitle = dialog.findViewById(R.id.dialogTxtTitle);

                dialogTxtTitle.setText(R.string.update_contact);
                dialogBtnAction.setText(R.string.update);

                dialogBtnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = dialogEditTxtName.getText().toString().trim();
                        String number = dialogEditTxtNumber.getText().toString().trim();

                        if(name.isEmpty())
                        {
                            Toast.makeText(context,"Please enter contact name",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if(number.isEmpty())
                        {
                            Toast.makeText(context,"Please enter contact number",Toast.LENGTH_SHORT).show();
                            return;
                        }

                        for(HomeContactRecyclerModel contact : contactArr)
                        {
                            if(contact.name.equals(name) && contact.number.equals(number))
                            {
                                Toast.makeText(context,"Contact already exists",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }

                        AlertDialog.Builder updateDialog = new AlertDialog.Builder(context);
                        updateDialog.setTitle("Update Contact?");
                        updateDialog.setIcon(R.drawable.baseline_update_24);
                        updateDialog.setMessage("Are you sure you want to update this contact?");

                        updateDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                contactArr.set(currentPosition, new HomeContactRecyclerModel(contactArr.get(currentPosition).img,name,number));
                                notifyItemChanged(currentPosition);
                                Toast.makeText(context,"Contact Updated",Toast.LENGTH_SHORT).show();
                                NotificationUtils.showNotification(context, "Contact Updated", "Name: " + name + ", Number: " + number, contactArr.get(currentPosition).img);

                            }
                        });

                        updateDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(context,"Contact Not Updated",Toast.LENGTH_SHORT).show();
                            }
                        });

                        updateDialog.show();
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });

        holder.verticalListLayout.setOnLongClickListener(new View.OnLongClickListener() {


            @Override
            public boolean onLongClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Contact")
                        .setMessage("Are you sure you want to delete ?")
                        .setIcon(R.drawable.icons8_delete)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int currentPosition = holder.getAdapterPosition();
                                if (currentPosition == RecyclerView.NO_POSITION) {
                                    return;
                                }
                                contactArr.remove(currentPosition);
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
        return contactArr.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView verticalListImage;
        TextView verticalListNameText;
        TextView verticalListNumberText;
        AppCompatButton btn_Dial, btn_Msg, btn_Email, btn_Share;
        RelativeLayout verticalListLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            verticalListImage = itemView.findViewById(R.id.verticalListImage);
            verticalListNameText = itemView.findViewById(R.id.verticalListNameText);
            verticalListNumberText = itemView.findViewById(R.id.verticalListNumberText);
            btn_Dial = itemView.findViewById(R.id.btn_Dial);
            btn_Msg = itemView.findViewById(R.id.btn_Msg);
            btn_Email = itemView.findViewById(R.id.btn_Email);
            btn_Share = itemView.findViewById(R.id.btn_Share);
            verticalListLayout = itemView.findViewById(R.id.verticalListLayout);
        }
    }

    private void setAnimation(View viewToAnimate, int position)
    {
        if(position>lastPosition) {
            Animation slideIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(slideIn);
            lastPosition = position;
        }

    }
}
