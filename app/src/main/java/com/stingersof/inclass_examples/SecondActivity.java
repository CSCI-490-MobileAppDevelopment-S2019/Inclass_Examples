package com.stingersof.inclass_examples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.textView);
        String text = getIntent().getExtras().getString("travelData");
        textView.setText(text);


    }
}
