package com.example.rise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class studentdata extends AppCompatActivity {



    String sname , date , str;

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
                        myRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                showdata(dataSnapshot);
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
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


    private void showdata(DataSnapshot dataSnapshot) {
        TextView textView = findViewById(R.id.textview);
        for(DataSnapshot ds : dataSnapshot.getChildren()){
            studentinfo obj = new studentinfo();
                    obj.setinfo(ds.child(sname).getValue(studentinfo.class).getinfo());
                    str = ds.child(sname).child("12-11-2019 :12:36:12:").getValue(studentinfo.class).getinfo();
                    textView.setText(str);

        }
    }
}
