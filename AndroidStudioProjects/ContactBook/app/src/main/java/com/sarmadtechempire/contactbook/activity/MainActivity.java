package com.sarmadtechempire.contactbook.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sarmadtechempire.contactbook.R;
import com.sarmadtechempire.contactbook.activity.adapter.HomeContactAdapter;
import com.sarmadtechempire.contactbook.activity.model.HomeContactRecyclerModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView verticalRecyclerView;
    FloatingActionButton btnOpenDialog;

    ArrayList<HomeContactRecyclerModel> contactArr = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        verticalRecyclerView = findViewById(R.id.verticalRecyclerView);
        btnOpenDialog = findViewById(R.id.btnOpenDialog);
        ContactRecyclerArray();

        HomeContactAdapter homeContactAdapter = new HomeContactAdapter(MainActivity.this, contactArr);
        verticalRecyclerView.setAdapter(homeContactAdapter);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void ContactRecyclerArray()
    {
        contactArr.add(new HomeContactRecyclerModel(R.drawable.pic1, "Sarmad Farooq", "0334-7872040"));
        contactArr.add(new HomeContactRecyclerModel(R.drawable.pic2, "Sarmad Farooq Dev","0334-7872040"));
        contactArr.add(new HomeContactRecyclerModel(R.drawable.pic3, "Sarmad Farooq Tech", "0334-7872040"));
        contactArr.add(new HomeContactRecyclerModel(R.drawable.pic4, "Areeb Farooq", "0323-6783235"));
        contactArr.add(new HomeContactRecyclerModel(R.drawable.pic5, "Junaid Sheikh", "0331-4805859"));
        contactArr.add(new HomeContactRecyclerModel(R.drawable.pic6, "Rana Abdur Rehman","0334-7142120"));
        contactArr.add(new HomeContactRecyclerModel(R.drawable.pic7, "Mufti Tariq Masood","0334-7298354"));
        contactArr.add(new HomeContactRecyclerModel(R.drawable.pic8, "Molana Tariq Jameel","0335-6298765"));
        contactArr.add(new HomeContactRecyclerModel(R.drawable.pic9, "Molana Ilyas Ghuman","0330-7686901"));
    }
}
