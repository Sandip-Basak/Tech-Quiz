package com.example.techquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    public String[] questions = {"1: When was the first computer invented?","\t\n" +
            "2: '.MOV' extension refers usually to what kind of file?","\t\n" +
            "3: 'OS' computer abbreviation usually means ?","4: Who invented flexible photographic film?","5: When was the DVD introduced?","\t\n" +
            "6. Who co-founded Hotmail in 1996 and then sold the company to Microsoft?","7. What does the term PLC stand for?"," \t\n" +
            "8. 'CD' computer abbreviation usually means ?","\t\n" +
            "9. Where is the headquarters of Intel located?"," \t\n" +
            "10. Who co-created the UNIX operating system in 1969 with Dennis Ritchie?"};
    public String[] a = {"1965","Image File","Order of Significance","Leonardo da Vinci","1990","Ada Byron Lovelace","Programmable Lift Computer","Compact Disc","Tucson, Arizona","Bjarne Stroustrup"};
    public String[] b = {"1893","Animation/movie file","Open Software","Linda Eastman","1970","Ray Tomlinson","Program List Control","Copy Density","Santa Clara, California","Steve Wozniak"};
    public String[] c = {"1943","Audio File","Optical Sensor","Louis Daguerre","1995","Shawn Fanning","Programmable Logic Controller","Change Data","Redmond, Washington","Niklaus Wirth"};
    public String[] d = {"1935","MS Office Document","Operating System","George Eastman","2000","Sabeer Bhatia","Piezo Lamp Connector","Command Description","Richmond, Virginia","Ken Thompson"};
    public String[] answers = {"c","b","d","d","c","d","c","a","b","d"};
    public int index = 0;
    public int score = 0;
    public int  hint = 2;
    TextView question;
    Button option1;
    Button option2;
    Button option3;
    Button option4;
    Button lifeline;
    public static final String EXTRA_SCORE = "com.example.techquiz.EXTRA.scorecard";
    public static final String EXTRA_PLAYER = "com.example.techquiz.EXTRA.player";
    String name;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        question = findViewById(R.id.textView);
        option1 = findViewById(R.id.button6);
        option2 = findViewById(R.id.button3);
        option3 = findViewById(R.id.button4);
        option4 = findViewById(R.id.button5);
        lifeline = findViewById(R.id.button2);
        Intent intent = getIntent();
        name = intent.getStringExtra(MainActivity.EXTRA_NAME);
        question.setText(questions[0]);
        option1.setText(a[0]);
        option2.setText(b[0]);
        option3.setText(c[0]);
        option4.setText(d[0]);
        lifeline.setText("Life Line :"+hint);
        lifeline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hint > 0) {
                    hint--;
                    switch (answers[index]) {
                        case "a":
                            Toast.makeText(MainActivity2.this, "The answer is " + a[index], Toast.LENGTH_SHORT).show();
                            break;
                        case "b":
                            Toast.makeText(MainActivity2.this, "The answer is " + b[index], Toast.LENGTH_SHORT).show();
                            break;
                        case "c":
                            Toast.makeText(MainActivity2.this, "The answer is " + c[index], Toast.LENGTH_SHORT).show();
                            break;
                        case "d":
                            Toast.makeText(MainActivity2.this, "The answer is " + d[index], Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            Toast.makeText(MainActivity2.this, "answer not found", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity2.this, "No Life Line left", Toast.LENGTH_SHORT).show();
                }
                lifeline.setText("Life Line :"+hint);
                if (hint==0){
                    lifeline.setBackgroundColor(getResources().getColor(R.color.red));
                }
            }
        });
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answers[index].equals("a")) {
                    score++;
                    option1.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else {
                    option1.setBackgroundColor(getResources().getColor(R.color.red));
                }
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(index==9) {
                            scorecard();
                        }
                        else {
                            index++;
                            nextQuestion();
                        }
                    }
                },300);
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answers[index].equals("b")) {
                    score++;
                    option2.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else{
                    option2.setBackgroundColor(getResources().getColor(R.color.red));
                }
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(index==9) {
                            scorecard();
                        }
                        else {
                            index++;
                            nextQuestion();
                        }
                    }
                },300);
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answers[index].equals("c")) {
                    score++;
                    option3.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else {
                    option3.setBackgroundColor(getResources().getColor(R.color.red));
                }
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(index==9) {
                            scorecard();
                        }
                        else {
                            index++;
                            nextQuestion();
                        }
                    }
                },300);
            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answers[index].equals("d")) {
                    score++;
                    option4.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else {
                    option4.setBackgroundColor(getResources().getColor(R.color.red));
                }
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(index==9) {
                            scorecard();
                        }
                        else {
                            index++;
                            nextQuestion();
                        }
                    }
                },300);
            }
        });
    }
    public void scorecard(){
        String s = ""+score;
        Intent intent = new Intent(this, ScoreCard.class);
        intent.putExtra(EXTRA_SCORE, s);
        intent.putExtra(EXTRA_PLAYER, name);
        startActivity(intent);
        finish();
    }
    public void nextQuestion(){
        option1.setBackgroundColor(getResources().getColor(R.color.white));
        option2.setBackgroundColor(getResources().getColor(R.color.white));
        option3.setBackgroundColor(getResources().getColor(R.color.white));
        option4.setBackgroundColor(getResources().getColor(R.color.white));
        question.setText(questions[index]);
        option1.setText(a[index]);
        option2.setText(b[index]);
        option3.setText(c[index]);
        option4.setText(d[index]);

    }
}