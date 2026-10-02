package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView time;
    private TextView date;
    private TextView mHelloTextView;
    private EditText mNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mHelloTextView = findViewById(R.id.tVHello);
        mNameEditText = findViewById(R.id.eTName);
        time = findViewById(R.id.time);
        date = findViewById(R.id.date);

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss z", Locale.getDefault());

        // Format current date and time
        String currentDateString = dateFormat.format(new Date());
        String currentTimeString = timeFormat.format(new Date());

        // Set formatted text to TextViews
        date.setText("Date: " + currentDateString);
        time.setText("Time: " + currentTimeString);

    }

    public void onClick(View view) {
        if (mNameEditText.getText().length() == 0) {
            mHelloTextView.setText("Здравствуй, Мир!");
        } else {
            mHelloTextView.setText("Привет, " + mNameEditText.getText());
        }
    }
}