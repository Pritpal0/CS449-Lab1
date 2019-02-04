package com.example.umpirebuddy;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private int ballCounter = 0;
    private int strikeCounter = 0;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void strikeButtonOnClick(View V){
        TextView Strike = (TextView) findViewById(R.id.StrikeViewCounter);
        TextView Ball = (TextView) findViewById(R.id.BallViewCounter);
        if (strikeCounter >=2 ){
            strikemessage();
            strikeCounter = 0;
            ballCounter = 0;
            Ball.setText("Ball: " + ballCounter);
            Strike.setText("Strike: " + strikeCounter);
        }
        else {

            strikeCounter++;
            Strike.setText("Strike: " + strikeCounter);
        }
    }

     public void BallButtonOnClick(View V){
         TextView Strike = (TextView) findViewById(R.id.StrikeViewCounter);
         TextView Ball = (TextView) findViewById(R.id.BallViewCounter);
        if (ballCounter >= 3){
            ballmessage();
            ballCounter =0;
            strikeCounter =0;
            Ball.setText("Ball: " + ballCounter);
            Strike.setText("Strike: " + strikeCounter);
        }
        else {
            ballCounter++;
            Ball.setText("Ball: " + ballCounter);
        }

    }

    public void ballmessage(){
        AlertDialog.Builder ballAlert = new AlertDialog.Builder(MainActivity.this);
        ballAlert.setTitle("Walk!");
        ballAlert.setMessage("Player Walk's!");
        ballAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        ballAlert.show();
    }

    public void strikemessage(){
        AlertDialog.Builder strikeAlert = new AlertDialog.Builder(MainActivity.this);
        strikeAlert.setTitle("Strike!");
        strikeAlert.setMessage("Player is Out!");
        strikeAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        strikeAlert.show();
    }
}

