package com.sarmadtechempire.customtoastexample;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnToast = findViewById(R.id.btnToast);


//        Default Toast
//        Toast.makeText(MainActivity.this, "This is my first toast", Toast.LENGTH_SHORT).show();
        // Custom Toast

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast = new Toast(MainActivity.this);
                View view = getLayoutInflater().inflate(R.layout.custom_toast_layout, null);
                toast.setView(view);



                TextView textView = view.findViewById(R.id.txtMsg);

                Log.d("TAG", "onClick: "+textView.getText());


                textView.setText(R.string.message_sent_successfully);

                toast.setDuration(Toast.LENGTH_LONG);

                toast.setGravity(Gravity.CENTER,0,0);

                toast.show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
