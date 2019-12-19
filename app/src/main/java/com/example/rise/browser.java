package com.example.rise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class browser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        WebView b = findViewById(R.id.browser);
        Bundle bundle = getIntent().getExtras();
        String link = "https://";
        String link1 = bundle.getString("link");
        link = link.concat(link1.toString());
        b.loadUrl(link);
        Toast.makeText(getApplicationContext(),link,Toast.LENGTH_LONG).show();

    }
}
