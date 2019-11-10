package com.example.rise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class second extends AppCompatActivity {

    String uname , data;
    EditText data1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Bundle bundle = getIntent().getExtras();

        uname = bundle.getString("uname");

        TextView user;

        user = findViewById(R.id.user);
        data1 = findViewById(R.id.data);
        switch (uname) {
            case "harsh":
                user.setText(user.getText().toString().concat("Hello, Harsh"));
                break;
            case "anchal":
                user.setText(user.getText().toString().concat("Hello, Anchal"));
                break;
            case "swarnim":
                user.setText(user.getText().toString().concat("Hello, Swarmin"));
                break;
            case "vrinda":
                user.setText(user.getText().toString().concat("Hello, Vrinda"));
                break;
        }


    }

    public void submit(View view) throws InterruptedException {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        data = data1.getText().toString();

        if (data.equals("")) {
            Toast.makeText(getApplicationContext(), "Enter Valid Input", Toast.LENGTH_LONG).show();
            v.vibrate(70);
            TimeUnit.MILLISECONDS.sleep(250);
            v.vibrate(70);
        }
        else
            {
            v.vibrate(75);
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy :hh:mm:ss");
            Date date = new Date();
            String newdate = dateFormat.format(date).toString();
            myRef.child(uname).child(newdate).setValue(data);
            data1.setText("");
            Toast.makeText(getApplicationContext(), "Response Submitted", Toast.LENGTH_LONG).show();
            data1.setHint("Add new Task");
        }
    }
}