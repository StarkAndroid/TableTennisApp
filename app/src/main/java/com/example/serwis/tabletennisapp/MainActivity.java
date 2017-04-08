package com.example.serwis.tabletennisapp;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.button;
import static android.R.attr.duration;
import static android.R.id.button1;
import static android.R.id.button2;
import static android.R.id.text1;

public class MainActivity extends AppCompatActivity {
    int scoreA;
    int scoreB;
    int netA;
    int netB;
    int scoreTotal;
    int matchScoreA;
    int matchScoreB;
    TextView image1;
    TextView image2;
    TextView text1;
    TextView text2;
    TextView text3;
    TextView text4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView) findViewById(R.id.scoreA);
        text2 = (TextView) findViewById(R.id.matchscoreA);
        text3 = (TextView) findViewById(R.id.scoreB);
        text4 = (TextView) findViewById(R.id.matchscoreB);
        image1 = (TextView) findViewById(R.id.serveA);
        image2 = (TextView) findViewById(R.id.serveB);

        resetScores();

        Button button1 = (Button) findViewById(R.id.pointA);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (scoreA<10){
                    AgainsPoint();
                    checkServe();
            }
            else if (matchScoreA<3) {AgainsGem();
                    checkServe();
                }
            else {  Toast toast = Toast.makeText(getApplicationContext(), "Player A wins!", Toast.LENGTH_LONG);
                    toast.show();
                    resetScores();
                    checkServe();
                }
        }

    });
        Button button3 = (Button) findViewById(R.id.netA);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        if (netA == 0)
                            netA = 1;
                        else if (netA==1 && scoreB<10){
                            netA=0;
                            BgainsPoint();
                            checkServe();
                            }
                         else if (netA==1 && scoreB==10 && matchScoreB<3) {
                            BgainsGem();
                           checkServe();
                        }
                        else {
                            Toast toast = Toast.makeText(getApplicationContext(), "Player B wins!", Toast.LENGTH_LONG);
                            toast.show();
                            resetScores();
                            checkServe();
                        }
                    }
                });
        Button button2 = (Button) findViewById(R.id.pointB);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (scoreB<10){
                    BgainsPoint();
                    scoreTotal = scoreA + scoreB;
                    checkServe();
                }
                else if (matchScoreB<3) {BgainsGem();
                    checkServe();
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Player B wins!", Toast.LENGTH_LONG);
                    toast.show();
                    resetScores();
                    checkServe();
                }
            }

        });
        Button button4 = (Button) findViewById(R.id.netB);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (netB==0)
                    netB = 1;
                else if (netB==1 && scoreA<10){
                    netB=0;
                    AgainsPoint();
                   checkServe();
                }
                else if (netB==1 && scoreA==10 && matchScoreA<3) {
                    AgainsGem();
                   checkServe();
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Player A wins!", Toast.LENGTH_LONG);
                    toast.show();
                    resetScores();
                    checkServe();
                }
            }
        });
        Button button5 = (Button) findViewById(R.id.reset);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             resetScores();
            }
        });
}


void AgainsPoint(){
    scoreA = scoreA + 1;
    text1.setText(""+scoreA);
    scoreTotal = scoreA + scoreB;
}
void BgainsPoint (){
    scoreB = scoreB + 1;
    text3.setText(""+scoreB);
}
void AgainsGem(){
    scoreB = 0;
    scoreA = 0;
    matchScoreA= matchScoreA + 1;
    text1.setText(""+scoreA);
    text3.setText(""+scoreB);
    text2.setText(""+matchScoreA);
    scoreTotal = scoreA + scoreB;
}
void BgainsGem(){
    scoreB = 0;
    scoreA = 0;
    matchScoreB= matchScoreB + 1;
    text1.setText(""+scoreA);
    text3.setText(""+scoreB);
    text4.setText(""+matchScoreB);
    scoreTotal = scoreA + scoreB;
}
void checkServe (){
    if (scoreTotal % 2 == 0){
        if (image1.getVisibility()==View.VISIBLE){
            image1.setVisibility(View.INVISIBLE);
            image2.setVisibility(View.VISIBLE);
        }
        else {
            image1.setVisibility(View.VISIBLE);
            image2.setVisibility(View.INVISIBLE);
        }
    }
}
void resetScores(){
    scoreA=0;
    text1.setText(""+scoreA);
    netA=0;
    matchScoreA=0;
    text2.setText(""+matchScoreA);
    scoreB=0;
    text3.setText(""+scoreB);
    netB=0;
    matchScoreB=0;
    scoreTotal = 0;

    text4.setText(""+matchScoreB);
    image1.setVisibility(View.VISIBLE);
    image2.setVisibility(View.INVISIBLE);
}
}

