package com.example.techquiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class ScoreCard extends AppCompatActivity {
    TextView textView;
    TextView remarks;
    TextView highScore;

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_card);
        Intent intent = getIntent();
        String score = intent.getStringExtra(MainActivity2.EXTRA_SCORE);
        int r = Integer.parseInt(score);
        String name = intent.getStringExtra(MainActivity2.EXTRA_PLAYER).toUpperCase(Locale.ROOT);
        remarks = findViewById(R.id.textView3);
        textView = findViewById(R.id.textView2);
        highScore = findViewById(R.id.textView4);
        SharedPreferences sp = getSharedPreferences("HighScore",MODE_PRIVATE);
        int high = sp.getInt("score", 0);
        String hm = sp.getString("name","");
        if(r>high){
            highScore.setText("High Score : "+name+" - "+r);
            SharedPreferences.Editor ed = sp.edit();
            ed.putString("name",name);
            ed.putInt("score",r);
            ed.apply();
        }
        else{
            highScore.setText("High Score : "+hm+" - "+high);
        }
        switch(r){
            case 0:
            case 1:
            case 2:
            case 3:remarks.setText("Bad");
                   break;
            case 4:
            case 5:
            case 6:
            case 7:remarks.setText("Average");
                   break;
            case 8:
            case 9:remarks.setText("Brilliant");
                   break;
            case 10:remarks.setText("God Like");
                    break;
            default:remarks.setText("Don't Cheat");
        }
        textView.setText(name+" YOUR SCORE IS "+score+"/10");
    }
}