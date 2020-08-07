package com.rs.example1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.tvTitle);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null){

            textView.setText(bundle.getString("title"));

        }
    }
}