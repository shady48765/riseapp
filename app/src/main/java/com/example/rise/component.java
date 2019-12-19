package com.example.rise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Vibrator;
import android.widget.Spinner;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class component extends AppCompatActivity {

    Spinner s1,s2,s3;
    Bundle bundle= new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component);

        String[] arraySpinner = new String[] {"Capacitor","Diode","Triode","Resistor"};
        s1 = (Spinner) findViewById(R.id.spinner01);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spinner_list,arraySpinner);
        adapter.setDropDownViewResource(R.layout.spinner_list);
        s1.setAdapter(adapter);

        String[] arraySpinner2 = new String[] {"Select"};
        s2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 =new ArrayAdapter<String>(this,R.layout.spinner_list,arraySpinner2);
        adapter2.setDropDownViewResource(R.layout.spinner_list);
        s2.setAdapter(adapter2);

        String[] arraySpinner3 =new String[] {"Select"};
        s3 =(Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter3 =new ArrayAdapter<String>(this,R.layout.spinner_list,arraySpinner3);
        adapter3.setDropDownViewResource(R.layout.spinner_list);
        s3.setAdapter(adapter3);

    }

    public void Se1(View view) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(70);
        String[] arraySpinner2 = new String[] {"SMD","SMT"};
        s2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 =new ArrayAdapter<String>(this,R.layout.spinner_list,arraySpinner2);
        adapter2.setDropDownViewResource(R.layout.spinner_list);
        s2.setAdapter(adapter2);
    }
    public void Se2(View view){
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(70);
        String[] arraySpinner3={""};
        if(s1.getSelectedItem().equals("Capacitor") && (s2.getSelectedItem().equals("SMD")||s2.getSelectedItem().equals("SMT")))
        {
            arraySpinner3 = new String[]{"120uF", "500uF", "1000uF", "4000uF"};
        }
        if(s1.getSelectedItem().equals("Diode") && (s2.getSelectedItem().equals("SMD")||s2.getSelectedItem().equals("SMT")))
        {
            arraySpinner3 = new String[]{"50W", "500W", "1000W"};
        }
        if(s1.getSelectedItem().equals("Triode") && (s2.getSelectedItem().equals("SMD")||s2.getSelectedItem().equals("SMT")))
        {
            arraySpinner3 = new String[]{"34W", "50W", "90W" , "1000W"};
        }
        if(s1.getSelectedItem().equals("Resistor") && (s2.getSelectedItem().equals("SMD")||s2.getSelectedItem().equals("SMT")))
        {
            arraySpinner3 = new String[]{"10K", "100K", "1000K", "5M"};
        }


        s3 =(Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter3 =new ArrayAdapter<String>(this,R.layout.spinner_list,arraySpinner3);
        adapter3.setDropDownViewResource(R.layout.spinner_list);
        s3.setAdapter(adapter3);
        bundle.putString("s3",s3.getSelectedItem().toString());
    }

    public void enter(View view) throws InterruptedException {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Component");

        if(s2.getSelectedItem().toString().equals("Select")||s3.getSelectedItem().toString().equals("Select"))
        {
            Toast.makeText(getApplicationContext(),"Please Select Valid Component",Toast.LENGTH_LONG).show();
            v.vibrate(70);
            TimeUnit.MILLISECONDS.sleep(250);
            v.vibrate(70);
        }


        else if((s1.getSelectedItem().toString().equals("Capacitor") && (s3.getSelectedItem().toString().equals("120uF")||s3.getSelectedItem().toString().equals("500uF")||s3.getSelectedItem().toString().equals("1000uF")||s3.getSelectedItem().toString().equals("4000uF")))||(s1.getSelectedItem().toString().equals("Diode") && (s3.getSelectedItem().toString().equals("50W")||s3.getSelectedItem().toString().equals("500W")||s3.getSelectedItem().toString().equals("1000W")))||s1.getSelectedItem().toString().equals("Triode") && (s3.getSelectedItem().toString().equals("34W")||s3.getSelectedItem().toString().equals("50W")||s3.getSelectedItem().toString().equals("90W")||s3.getSelectedItem().toString().equals("1000W"))||s1.getSelectedItem().toString().equals("Resistor") && (s3.getSelectedItem().toString().equals("10K")||s3.getSelectedItem().toString().equals("100K")||s3.getSelectedItem().toString().equals("1000K")||s3.getSelectedItem().toString().equals("5M")))
        {

            Toast.makeText(getApplicationContext(), s1.getSelectedItem().toString() + " " + s2.getSelectedItem().toString() + " " + s3.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
            v.vibrate(70);
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy :hh:mm:ss");
            Date date = new Date();
            String newdate = dateFormat.format(date).toString();
            myRef.child(s1.getSelectedItem().toString()).child(s2.getSelectedItem().toString()).child(newdate).setValue(s3.getSelectedItem().toString());

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.risewhite)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.risewhite))
                    .setContentTitle("Component Entered")
                    .setContentText(s1.getSelectedItem().toString() + " " + s2.getSelectedItem().toString() + " " + s3.getSelectedItem().toString())
                    .setAutoCancel(true)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

//            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.EMPTY);
//            PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
//            builder.setContentIntent(pendingIntent);
//

            NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(1,builder.build());


            String[] arraySpinner = new String[] {"Capacitor","Diode","Triode","Resistor"};
            s1 = (Spinner) findViewById(R.id.spinner01);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spinner_list,arraySpinner);
            adapter.setDropDownViewResource(R.layout.spinner_list);
            s1.setAdapter(adapter);

            String[] arraySpinner2 = new String[] {"Select"};
            s2 = (Spinner) findViewById(R.id.spinner2);
            ArrayAdapter<String> adapter2 =new ArrayAdapter<String>(this,R.layout.spinner_list,arraySpinner2);
            adapter2.setDropDownViewResource(R.layout.spinner_list);
            s2.setAdapter(adapter2);

            String[] arraySpinner3 =new String[] {"Select"};
            s3 =(Spinner) findViewById(R.id.spinner3);
            ArrayAdapter<String> adapter3 =new ArrayAdapter<String>(this,R.layout.spinner_list,arraySpinner3);
            adapter3.setDropDownViewResource(R.layout.spinner_list);
            s3.setAdapter(adapter3);
        }

        else
        {
            Toast.makeText(getApplicationContext(),"Please Select Valid Component",Toast.LENGTH_LONG).show();
            v.vibrate(70);
            TimeUnit.MILLISECONDS.sleep(250);
            v.vibrate(70);

            String[] arraySpinner = new String[] {"Capacitor","Diode","Triode","Resistor"};
            s1 = (Spinner) findViewById(R.id.spinner01);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spinner_list,arraySpinner);
            adapter.setDropDownViewResource(R.layout.spinner_list);
            s1.setAdapter(adapter);

            String[] arraySpinner2 = new String[] {"Select"};
            s2 = (Spinner) findViewById(R.id.spinner2);
            ArrayAdapter<String> adapter2 =new ArrayAdapter<String>(this,R.layout.spinner_list,arraySpinner2);
            adapter2.setDropDownViewResource(R.layout.spinner_list);
            s2.setAdapter(adapter2);

            String[] arraySpinner3 =new String[] {"Select"};
            s3 =(Spinner) findViewById(R.id.spinner3);
            ArrayAdapter<String> adapter3 =new ArrayAdapter<String>(this,R.layout.spinner_list,arraySpinner3);
            adapter3.setDropDownViewResource(R.layout.spinner_list);
            s3.setAdapter(adapter3);
        }

    }

}
