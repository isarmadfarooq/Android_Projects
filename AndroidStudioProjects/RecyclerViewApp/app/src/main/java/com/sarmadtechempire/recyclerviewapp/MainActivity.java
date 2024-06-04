package com.sarmadtechempire.recyclerviewapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView horizontalRecyclerView, verticalRecyclerView;

    ArrayList<HorizontalRecyclerModel> horizontalArr = new ArrayList<>();
    ArrayList<VerticalRecyclerModel> verticalArr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        horizontalRecyclerView = findViewById(R.id.horizontalRecyclerView);
        verticalRecyclerView = findViewById(R.id.verticalRecyclerView);

        HorizontalRecyclerArr();
        VerticalRecyclerArr();

        HorizontalRecyclerAdapter horizontalAdapter = new HorizontalRecyclerAdapter(this, horizontalArr);
        horizontalRecyclerView.setAdapter(horizontalAdapter);

        VerticalRecyclerAdapter verticalAdapter = new VerticalRecyclerAdapter(this, verticalArr);
        verticalRecyclerView.setAdapter(verticalAdapter);




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