package com.sarmadtechempire.contactbook.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sarmadtechempire.contactbook.R;
import com.sarmadtechempire.contactbook.activity.adapter.HomeContactAdapter;
import com.sarmadtechempire.contactbook.activity.model.HomeContactRecyclerModel;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    RecyclerView verticalRecyclerView;
    FloatingActionButton btnOpenDialog;

    HomeContactAdapter homeContactAdapter;

    ArrayList<HomeContactRecyclerModel> contactArr = new ArrayList<>();
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        verticalRecyclerView = findViewById(R.id.verticalRecyclerView);
        btnOpenDialog = findViewById(R.id.btnOpenDialog);



        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Open Dialog Button Clicked");

                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_add_edit_contact);

                EditText dialogEditTxtName = dialog.findViewById(R.id.dialogEdtTxtName);
                EditText dialogEditTxtNumber = dialog.findViewById(R.id.dialogEdtTxtNumber);
                AppCompatButton dialogBtnAction = dialog.findViewById(R.id.dialogBtnAction);

                dialogBtnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d(TAG, "Dialog Button Action Clicked");

                        String name = "", number = "";

                        name = dialogEditTxtName.getText().toString().trim();
                        number = dialogEditTxtNumber.getText().toString().trim();

                        if (name.isEmpty()) {
                            Toast.makeText(MainActivity.this, "Please Enter Correct Name!", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (number.isEmpty()) {
                            Toast.makeText(MainActivity.this, "Please Enter Correct Number!", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        // Adding the new contact
                        contactArr.add(new HomeContactRecyclerModel(R.drawable.pic10, name, number));
                        homeContactAdapter.notifyItemInserted(contactArr.size() - 1);
                        verticalRecyclerView.scrollToPosition(contactArr.size() - 1);
                        dialog.dismiss();
                    }
                });

                dialog.show();

            }
        });

        ContactRecyclerArray();

        homeContactAdapter = new HomeContactAdapter(MainActivity.this, contactArr);
        verticalRecyclerView.setAdapter(homeContactAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void ContactRecyclerArray() {
        contactArr.add(new HomeContactRecyclerModel(R.drawable.pic1, "Sarmad Farooq", "0334-7872040"));
        contactArr.add(new HomeContactRecyclerModel(R.drawable.pic2, "Sarmad Farooq Dev", "0334-7872040"));
        contactArr.add(new HomeContactRecyclerModel(R.drawable.pic3, "Sarmad Farooq Tech", "0334-7872040"));
        contactArr.add(new HomeContactRecyclerModel(R.drawable.pic4, "Areeb Farooq", "0323-6783235"));
        contactArr.add(new HomeContactRecyclerModel(R.drawable.pic5, "Junaid Sheikh", "0331-4805859"));
        contactArr.add(new HomeContactRecyclerModel(R.drawable.pic6, "Rana Abdur Rehman", "0334-7142120"));
        contactArr.add(new HomeContactRecyclerModel(R.drawable.pic7, "Mufti Tariq Masood", "0334-7298354"));
        contactArr.add(new HomeContactRecyclerModel(R.drawable.pic8, "Molana Tariq Jameel", "0335-6298765"));
        contactArr.add(new HomeContactRecyclerModel(R.drawable.pic9, "Molana Ilyas Ghuman", "0330-7686901"));
    }
}

