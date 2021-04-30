package edu.gcit.todo_11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView text;

    //array to store colors
    private String[] textcolorArray = {"red", "green", "blue", "pink", "orange", "yellow", "seagreen", "brown", "grey", "magenta"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textView);
    }

    public void changeColor(View view) {
        Random rn = new Random();
        String colorName = textcolorArray[rn.nextInt(10)];

        int colourResourceName = getResources().getIdentifier(colorName, "color", getApplicationContext().getPackageName());

        //int colorRes = getResources().getColor(colourResourceName, this.getTheme());
        int colorRes = ContextCompat.getColor(this, colourResourceName);
        text.setTextColor(colorRes);
    }
}