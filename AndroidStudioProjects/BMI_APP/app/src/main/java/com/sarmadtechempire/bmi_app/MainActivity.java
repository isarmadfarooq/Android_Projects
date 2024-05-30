package com.sarmadtechempire.bmi_app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editWeight, editHeightFt, editHeightIn;
    AppCompatButton calculate_BMI_Btn, clearBtn;
    TextView txtResult;
    LinearLayout llMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        editWeight = findViewById(R.id.editWeight);
        editHeightFt = findViewById(R.id.editHeightFt);
        editHeightIn = findViewById(R.id.editHeightIn);
        calculate_BMI_Btn = findViewById(R.id.calculate_BMI_Btn);
        clearBtn = findViewById(R.id.clearBtn);
        txtResult = findViewById(R.id.txtResult);
        llMain = findViewById(R.id.llMain);



        calculate_BMI_Btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                calculateBMI();

            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.llMain), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

        @SuppressLint("SetTextI18n")
        private void calculateBMI()
        {
            int wt = Integer.parseInt(editWeight.getText().toString());
            int ft = Integer.parseInt(editHeightFt.getText().toString());
            int In = Integer.parseInt(editHeightIn.getText().toString());

            int totalIn = ft * 12 + In;
            double totalCm = totalIn * 2.53;
            double totalMt = totalCm / 100;

            double bmi = wt / (totalMt * totalMt);

            if (bmi > 25) {
                txtResult.setText("You're OverWeight");
                llMain.setBackgroundColor(getResources().getColor(R.color.color_overWt));
            } else if (bmi < 18) {
                txtResult.setText("You're UnderWeight");
                llMain.setBackgroundColor(getResources().getColor(R.color.color_underWt));
            } else {
                txtResult.setText("You're Healthy!");
                llMain.setBackgroundColor(getResources().getColor(R.color.color_Healthy));
            }


    }

    @SuppressLint("SetTextI18n")
    private void clearFields()
    {
        editWeight.setText("");
        editHeightFt.setText("");
        editHeightIn.setText("");
        txtResult.setText("Result: ");
        llMain.setBackgroundColor(getResources().getColor(androidx.cardview.R.color.cardview_light_background));

    }
}
