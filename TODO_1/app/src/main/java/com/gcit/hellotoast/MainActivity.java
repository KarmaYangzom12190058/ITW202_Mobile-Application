package com.gcit.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toast(View v){
        String message = "Hello Toast!";
        Toast t = Toast.makeText(this, message, Toast.LENGTH_SHORT );
        t.show();
    }
    @SuppressLint("SetTextI18n")
    public void count(View v){
        count++;
        TextView text = (TextView)findViewById(R.id.textView);
        text.setText(""+count);
    }
}