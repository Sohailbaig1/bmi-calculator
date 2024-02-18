package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bmicalculator.R;


public class MainActivity extends AppCompatActivity {
    private EditText editTextWeight, editTextHeightFeet, editTextHeightInches;
    private TextView textViewResult;
    private Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeightFeet = findViewById(R.id.editTextHeightFeet);
        editTextHeightInches = findViewById(R.id.editTextHeightInches);
        textViewResult = findViewById(R.id.textViewResult);
        buttonCalculate = findViewById(R.id.buttonCalculate);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightStr = editTextWeight.getText().toString();
        String heightFeetStr = editTextHeightFeet.getText().toString();
        String heightInchesStr = editTextHeightInches.getText().toString();

        if (!weightStr.isEmpty() && !heightFeetStr.isEmpty() && !heightInchesStr.isEmpty()) {
            float weight = Float.parseFloat(weightStr);
            int heightFeet = Integer.parseInt(heightFeetStr);
            int heightInches = Integer.parseInt(heightInchesStr);

            // Convert height from feet and inches to inches
            float heightInchesTotal = (heightFeet * 12) + heightInches;

            float weightKg = weight ;

            // Calculate BMI
            float heightMeters = heightInchesTotal * 0.0254f;
            float bmi = weightKg / (heightMeters * heightMeters);

            displayBMIResult(bmi);
        } else {
            textViewResult.setText("Please enter weight, height (feet), and height (inches)");
        }
    }

    private void displayBMIResult(float bmi) {
        String bmiText = "Your BMI is " + String.format("%.2f", bmi);
        textViewResult.setText(bmiText);
    }
}
