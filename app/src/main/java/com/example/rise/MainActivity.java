package com.example.rise;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    EditText uname ,password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button browser = findViewById(R.id.lbutton);

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




    public void login(View view) throws InterruptedException {

        uname = findViewById(R.id.uname);
        String user = uname.getText().toString().trim().toLowerCase();

        password = findViewById(R.id.pwd);
        String pwd = password.getText().toString().trim().toLowerCase();

        if ((user.equals("harsh") && pwd.equals("rise"))||(user.equals("swarnim") && pwd.equals("swarnim@123"))||(user.equals("vrinda") && pwd.equals("rise"))||(user.equals("achal") && pwd.equals("achalsingh"))||(user.equals("rupali") && pwd.equals("rupali@123"))){
            Toast.makeText(getApplicationContext(),"login successful",Toast.LENGTH_LONG).show();
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(75);
            Bundle bundle = new Bundle();
            bundle.putString("uname",user);
            final Intent i = new Intent(MainActivity.this,second.class);
            i.putExtras(bundle);
            finish();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(i);
                }
            },0);
        }
        else if ((user.equals("krypton") && pwd.equals("nimda"))||(user.equals("ajinkya") && pwd.equals("nimda"))||(user.equals("vaibhav") && pwd.equals("nimda"))||(user.equals("usama") && pwd.equals("nimda"))||(user.equals("gayatri") && pwd.equals("nimda"))||(user.equals("nikhil") && pwd.equals("nimda"))||(user.equals("shady") && pwd.equals("nimda"))){
            Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_LONG).show();
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(75);
            Bundle bundle = new Bundle();
            bundle.putString("uname",user);
            final Intent i = new Intent(MainActivity.this,admin.class);
            i.putExtras(bundle);
            finish();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(i);
                }
            },0);
        }
        else
        {
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(70);
            TimeUnit.MILLISECONDS.sleep(250);
            v.vibrate(70);
            Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_LONG).show();
        }
    }

}
