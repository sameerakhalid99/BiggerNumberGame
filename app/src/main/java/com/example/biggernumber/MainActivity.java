package com.example.biggernumber;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int count=0;
    private int r1, r2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        giveNewRandom();
    }

    private void giveNewRandom() {
        if(count==5) {
            count=0;
            Toast.makeText(MainActivity.this, "You won!", Toast.LENGTH_LONG).show();
        }
        else {
            Random rand = new Random();
            r1 = rand.nextInt(10);
            //for fix the display the same numbers problem
            while (true) {
                r2 = rand.nextInt(10);
                if (r1 != r2) break;
            }
        }
        Button b1 = (Button) findViewById(R.id.buttonL);
        b1.setText(Integer.toString(r1));
        Button b2 = (Button) findViewById(R.id.buttonR);
        b2.setText(Integer.toString(r2));
    }

    public void onClickLeft(View view) {
        if(r1 > r2) {
            count++;
        }
        else {
            count--;
        }
        TextView txt = (TextView) findViewById(R.id.Result);
        txt.setText("Points: "+count);
        giveNewRandom();
    }

    public void onClickRight(View view) {
        if(r1 < r2) {
            count++;
        }
        else {
            count--;
        }
        TextView txt = (TextView) findViewById(R.id.Result);
        txt.setText("Points: "+count);
        giveNewRandom();
    }
}

