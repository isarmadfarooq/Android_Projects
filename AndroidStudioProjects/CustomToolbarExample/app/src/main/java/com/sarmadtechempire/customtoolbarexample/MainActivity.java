package com.sarmadtechempire.customtoolbarexample;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolBar);

        // Step 1: Set up the toolbar
        setSupportActionBar(toolbar);

        // Step 2: Enable the home button
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("My Toolbar");
        }

        toolbar.setSubtitle("My Subtitle");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.opt_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.opt_new) {
            Toast.makeText(this, "Created new file", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.opt_open) {
            Toast.makeText(this, "File open", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.opt_save) {
            Toast.makeText(this, "File saved", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == android.R.id.home) {
            // Handle the home button click
            Toast.makeText(this, "Home button clicked", Toast.LENGTH_SHORT).show();
            // Optional: Navigate up to the parent activity or finish the current activity
             onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
