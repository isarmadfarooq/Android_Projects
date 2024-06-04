package com.sarmadtechempire.recyclerviewapp;

import android.app.Dialog;
import android.os.Bundle;
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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView horizontalRecyclerView, verticalRecyclerView;
    FloatingActionButton btnOpenDialog;

    VerticalRecyclerAdapter verticalAdapter;
    ArrayList<HorizontalRecyclerModel> horizontalArr = new ArrayList<>();
    ArrayList<VerticalRecyclerModel> verticalArr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        horizontalRecyclerView = findViewById(R.id.horizontalRecyclerView);
        verticalRecyclerView = findViewById(R.id.verticalRecyclerView);
        btnOpenDialog = findViewById(R.id.btnOpenDialog);

        HorizontalRecyclerArr();
        VerticalRecyclerArr();

        HorizontalRecyclerAdapter horizontalAdapter = new HorizontalRecyclerAdapter(this, horizontalArr);
        horizontalRecyclerView.setAdapter(horizontalAdapter);

       verticalAdapter = new VerticalRecyclerAdapter(this, verticalArr);
        verticalRecyclerView.setAdapter(verticalAdapter);

        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_lay);

                EditText edtName = dialog.findViewById(R.id.edtName);
                EditText edtNumber = dialog.findViewById(R.id.edtNumber);
                AppCompatButton btnAction = dialog.findViewById(R.id.btnAction);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = "", number = "";
                        if(!edtName.getText().toString().isEmpty()) {
                             name = edtName.getText().toString();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this,"Please Enter Contact Name!",Toast.LENGTH_SHORT).show();
                        }

                        if(!edtNumber.getText().toString().isEmpty())
                        {
                             number = edtNumber.getText().toString();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this,"Please Enter Contact Number!",Toast.LENGTH_SHORT).show();
                        }

                        verticalArr.add(new VerticalRecyclerModel(name, number));

                        verticalAdapter.notifyItemInserted(verticalArr.size()-1);

                        verticalRecyclerView.scrollToPosition(verticalArr.size()-1);

                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void HorizontalRecyclerArr()
    {
        horizontalArr.add(new HorizontalRecyclerModel(R.drawable.pic1,"Sarmad Farooq"));
        horizontalArr.add(new HorizontalRecyclerModel(R.drawable.pic2,"Sarmad Farooq Dev"));
        horizontalArr.add(new HorizontalRecyclerModel(R.drawable.pic3,"Sarmad Farooq Tech"));
        horizontalArr.add(new HorizontalRecyclerModel(R.drawable.pic4,"Areeb Farooq"));
        horizontalArr.add(new HorizontalRecyclerModel(R.drawable.pic5,"Junaid Sheikh"));
        horizontalArr.add(new HorizontalRecyclerModel(R.drawable.pic6,"Rana Abdur Rehman"));
        horizontalArr.add(new HorizontalRecyclerModel(R.drawable.pic7,"Mufti Tariq Masood"));
        horizontalArr.add(new HorizontalRecyclerModel(R.drawable.pic8,"Molana Tariq Jameel"));
        horizontalArr.add(new HorizontalRecyclerModel(R.drawable.pic9,"Molana Ilyas Ghuman"));
    }

    private void VerticalRecyclerArr()
    {
        verticalArr.add(new VerticalRecyclerModel(R.drawable.pic1, "Sarmad Farooq", "0334-7872040"));
        verticalArr.add(new VerticalRecyclerModel(R.drawable.pic2, "Sarmad Farooq Dev","0334-7872040"));
        verticalArr.add(new VerticalRecyclerModel(R.drawable.pic3, "Sarmad Farooq Tech", "0334-7872040"));
        verticalArr.add(new VerticalRecyclerModel(R.drawable.pic4, "Areeb Farooq", "0323-6783235"));
        verticalArr.add(new VerticalRecyclerModel(R.drawable.pic5, "Junaid Sheikh", "0331-4805859"));
        verticalArr.add(new VerticalRecyclerModel(R.drawable.pic6,  "Rana Abdur Rehman","0334-7142120"));
        verticalArr.add(new VerticalRecyclerModel(R.drawable.pic7,  "Mufti Tariq Masood","0334-7298354"));
        verticalArr.add(new VerticalRecyclerModel(R.drawable.pic8,  "Molana Tariq Jameel","0335-6298765"));
        verticalArr.add(new VerticalRecyclerModel(R.drawable.pic9,  "Molana Ilyas Ghuman","0330-7686901"));

    }

}