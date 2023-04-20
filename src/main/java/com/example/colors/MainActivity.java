package com.example.colors;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private EditText redInput;
    private EditText greenInput;
    private EditText blueInput;
    private TextView colorView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        redInput = findViewById(R.id.red_input);
        greenInput = findViewById(R.id.green_input);
        blueInput = findViewById(R.id.blue_input);
        colorView = findViewById(R.id.color_view);
        Button updateButton = findViewById(R.id.update_button);
        updateButton.setOnClickListener(v -> updateColor());
    }
    private void updateColor() {
        try {
            int red = Integer.parseInt(redInput.getText().toString(), 16);
            int green = Integer.parseInt(greenInput.getText().toString(), 16);
            int blue = Integer.parseInt(blueInput.getText().toString(), 16);
            String hexRed = String.format("%02X", red);
            String hexGreen = String.format("%02X", green);
            String hexBlue = String.format("%02X", blue);
            String hexColor = "#" + hexRed + hexGreen + hexBlue;
            colorView.setBackgroundColor(Color.parseColor(hexColor));
            colorView.setBackgroundColor(Color.parseColor(hexColor));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
        } catch (IllegalArgumentException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}