package com.example.rise;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class admin extends AppCompatActivity {
    Button enter ;
    EditText sname;
    String name;
    Bundle bundle = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Bundle bundle = getIntent().getExtras();
        String uname = bundle.getString("uname");

        sname = findViewById(R.id.sname);
        sname.getText().toString().trim().toLowerCase();
    }
    public void sdet(View view) {
        if (sname.getText().toString().trim().toLowerCase().equals("harsh") || sname.getText().toString().trim().toLowerCase().equals("swarnim") || sname.getText().toString().trim().toLowerCase().equals("anchal") || sname.getText().toString().trim().toLowerCase().equals("vrinda")) {
            bundle.putString("sname", sname.getText().toString().trim().toLowerCase());
            final Intent i = new Intent(admin.this, studentdata.class);
            i.putExtras(bundle);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(i);
                }
            }, 0);
        }
        else
            Toast.makeText(getApplicationContext(),"Invalid",Toast.LENGTH_LONG).show();
    }
}