package com.sarmadtechempire.listexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Spinner spinner;

    AutoCompleteTextView autoCompleteTextView;

    int[] arrNo = new int[]{1,2,3,4,5};
    ArrayList<String> arrName = new ArrayList<>();
    ArrayList<String> arrIds = new ArrayList<>();

    ArrayList<String> arrLanguages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        spinner = findViewById(R.id.spinner);
        autoCompleteTextView = findViewById(R.id.autoCompleteTv);

        arrName.add("SarmadFarooq");
        arrName.add("AreebFarooq");
        arrName.add("SaadFarooq");
        arrName.add("Junaid");
        arrName.add("Ali");
        arrName.add("WaqasSajid");
        arrName.add("Shoaib");
        arrName.add("Waqar");
        arrName.add("Ahmad");
        arrName.add("Arslan");
        arrName.add("Wajid");
        arrName.add("Kamran");
        arrName.add("Umar");
        arrName.add("Sami");
        arrName.add("Adil");
        arrName.add("Sameer");
        arrName.add("Afan");
        arrName.add("Saif");
        arrName.add("Jalal");
        arrName.add("Anwar");

        arrIds.add("ATM_Card");
        arrIds.add("Bus Card");
        arrIds.add("office Card");
        arrIds.add("Emergency Card");
        arrIds.add("Hospital Card");
        arrIds.add("ID Card");
        arrIds.add("Passenger Card");


        // Autocomplete ArrayList

        arrLanguages.add("English");
        arrLanguages.add("Urdu");
        arrLanguages.add("Arabic");
        arrLanguages.add("French");
        arrLanguages.add("Spanish");
        arrLanguages.add("German");
        arrLanguages.add("Portuguese");


        // Adapter for Spinner
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, arrIds);
        spinner.setAdapter(spinnerAdapter);

        // Adapter for list
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, arrName);
        listView.setAdapter(adapter);

        // Adapter for Autocomplete

        ArrayAdapter<String> autoCompAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, arrLanguages);
        autoCompleteTextView.setAdapter(autoCompAdapter);
        autoCompleteTextView.setThreshold(1);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==0)
                {
                    Toast.makeText(MainActivity.this,"Clicked First Item", Toast.LENGTH_SHORT).show();
                }

            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}