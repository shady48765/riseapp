package com.example.rise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;


public class studentdata extends AppCompatActivity {



    String sname , date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentdata);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Bundle bundle = getIntent().getExtras();
        sname = bundle.getString("sname");

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        date = myRef.child(sname).getKey();

                switch (sname){
                    case "harsh":
                       // Toast.makeText(getApplicationContext(), date, Toast.LENGTH_LONG).show();
                        String link = myRef.child(sname).getDatabase().toString();
                        Bundle bundle1 = new Bundle();
                        bundle1.putString("link",link);
                        final Intent i = new Intent(studentdata.this,browser.class);
                        i.putExtras(bundle1);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(i);
                            }
                        },0);
                        break;
                    case "achal":
                        Toast.makeText(getApplicationContext(), sname, Toast.LENGTH_LONG).show();
                        break;
                    case "swarnim":
                        Toast.makeText(getApplicationContext(), sname, Toast.LENGTH_LONG).show();
                        break;
                    case "vrinda":
                        Toast.makeText(getApplicationContext(), sname, Toast.LENGTH_LONG).show();
                        break;
                }
    }
}
