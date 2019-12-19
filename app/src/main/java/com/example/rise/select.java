package com.example.rise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class select extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        ImageView rise = findViewById(R.id.rise);

        rise.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(), "Opening Browser", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), browser.class);
                startActivity(i);
                return false;

            }
        });
    }




    public void comp(View view){
        Toast.makeText(getApplicationContext(),"Enter The Component ",Toast.LENGTH_LONG).show();
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(75);
        final Intent i = new Intent(select.this,component.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(i);
            }
        },0);
    }

    public void log(View view){
        Toast.makeText(getApplicationContext(),"Welcome!",Toast.LENGTH_LONG).show();
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(75);
        final Intent i = new Intent(select.this,MainActivity.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(i);
            }
        },0);
    }
}
