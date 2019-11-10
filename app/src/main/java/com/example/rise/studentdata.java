package com.example.rise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class studentdata extends AppCompatActivity {


    private ValueEventListener value_event_listener;
    String sname, mAkun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentdata);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Bundle bundle = getIntent().getExtras();
        sname = bundle.getString("sname");

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

                switch (sname){
                    case "harsh":
                        Toast.makeText(getApplicationContext(), sname, Toast.LENGTH_LONG).show();
                        break;
                    case "anchal":
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
