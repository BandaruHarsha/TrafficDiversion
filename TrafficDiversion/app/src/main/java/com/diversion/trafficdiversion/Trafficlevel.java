package com.diversion.trafficdiversion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

public class Trafficlevel extends AppCompatActivity {

    Button checkDiversion;
    LinearLayout linLayout;
    ImageView trafficImageView;

    int i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trafficlevel);


        final int min = 0;
         final int max = 2;

        checkDiversion = (Button) findViewById(R.id.check);
        linLayout = (LinearLayout) findViewById(R.id.lin_layout);
        trafficImageView  = (ImageView) findViewById(R.id.trafic_police);
        trafficImageView.setVisibility(View.GONE);
        linLayout.setVisibility(View.VISIBLE);

        checkDiversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random r = new Random();
                i1 = r.nextInt(max - min + 1) + min;


                if(i1==1){
                    Toast.makeText(Trafficlevel.this,"Please take a diversion",Toast.LENGTH_SHORT).show();
                    trafficImageView.setImageResource(R.drawable.diversion);
                    trafficImageView.setVisibility(View.VISIBLE);
                    linLayout.setVisibility(View.GONE);
                } else {
                    Toast.makeText(Trafficlevel.this,"Please don't take diversion",Toast.LENGTH_SHORT).show();
                    trafficImageView.setImageResource(R.drawable.greensignal);
                    trafficImageView.setVisibility(View.VISIBLE);
                    linLayout.setVisibility(View.GONE);
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_trafficlevel, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
