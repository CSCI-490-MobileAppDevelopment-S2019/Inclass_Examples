package com.stingersof.inclass_examples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    Button button2;
    Button button3;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        button = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        textView = findViewById(R.id.demoTextView);

        button.setOnClickListener(this);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // This is what button 2 would do
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(editText.getText());
            }
        });

    }


    @Override
    public void onClick(View view) {
        // Intent with data to send to SecondActivity
        Intent i = new Intent(getApplicationContext(), SecondActivity.class);
        i.putExtra("travelData", editText.getText().toString());
        startActivity(i);


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String textString = textView.getText().toString();
        outState.putString("textViewKey", textString);

    }

    @Override
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);

        String textString = bundle.getString("textViewKey");
        textView.setText(textString);

    }
}
