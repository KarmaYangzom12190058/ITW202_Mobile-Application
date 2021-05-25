package com.gcit.todo_21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mFirst_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirst_text = findViewById(R.id.first_text);
    }

    public void startTask(View view) {
        mFirst_text.setText("Napping!");
        new SimpleAsyncTask(mFirst_text).execute();
    }
}