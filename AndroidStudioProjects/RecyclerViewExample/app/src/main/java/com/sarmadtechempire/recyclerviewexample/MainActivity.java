package com.sarmadtechempire.recyclerviewexample;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<ContactModel> arrContacts = new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerContact);


        ContactInfoArr();

        ContactListAdapter adapter = new ContactListAdapter(this, arrContacts);
        recyclerView.setAdapter(adapter) ;




//        How to set Layout Manager in RecyclerView in Activity
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void ContactInfoArr()
    {
        arrContacts.add(new ContactModel(R.drawable.pic1, "Sarmad Farooq", "0334-7872040"));
        arrContacts.add(new ContactModel(R.drawable.pic2, "Sarmad Farooq Dev","0334-7872040"));
        arrContacts.add(new ContactModel(R.drawable.pic3, "Sarmad Farooq Tech", "0334-7872040"));
        arrContacts.add(new ContactModel(R.drawable.pic4, "Areeb Farooq", "0323-6783235"));
        arrContacts.add(new ContactModel(R.drawable.pic5, "Junaid Sheikh", "0331-4805859"));
        arrContacts.add(new ContactModel(R.drawable.pic6,  "Rana Abdur Rehman","0334-7142120"));
        arrContacts.add(new ContactModel(R.drawable.pic7,  "Mufti Tariq Masood","0334-7298354"));
        arrContacts.add(new ContactModel(R.drawable.pic8,  "Molana Tariq Jameel","0335-6298765"));
        arrContacts.add(new ContactModel(R.drawable.pic9,  "Molana Ilyas Ghuman","0330-7686901"));

    }
}