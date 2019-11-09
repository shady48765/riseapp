package com.example.rise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Bundle bundle = getIntent().getExtras();

        String uname = bundle.getString("uname");

        TextView user ;
        user = findViewById(R.id.user);

        switch (uname){
            case "harsh":
                user.setText(user.getText().toString().concat("Hello, Harsh"));
                break;
            case "anchal":
                user.setText(user.getText().toString().concat("Hello, Anchal"));
                break;
            case "swarmin":
                user.setText(user.getText().toString().concat("Hello, Swarmin"));
                break;
            case "vrinda":
                user.setText(user.getText().toString().concat("Hello, Vrinda"));
                break;
        }


    }

}
