package edu.gcit.counterhomework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int num;
    private TextView count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);

        if (savedInstanceState != null){
            num = savedInstanceState.getInt("count_num");
            count.setText(String.valueOf(num));
        }
    }
    public void Count(View view){
        num++;
        count.setText(""+num);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count_num", num);
    }
}