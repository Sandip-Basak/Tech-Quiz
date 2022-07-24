package com.example.techquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    public static final String EXTRA_NAME = "com.example.techquiz.extra.NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_click();
            }
        });
    }
    public void button_click(){
        editText = findViewById(R.id.name);
        String name = editText.getText().toString();
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(EXTRA_NAME, name);
        startActivity(intent);
    }
}