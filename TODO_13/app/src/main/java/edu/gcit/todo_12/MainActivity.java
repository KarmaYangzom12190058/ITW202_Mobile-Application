package edu.gcit.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_message = "edu.gcit.todo_12";
    String mssg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void donut(View view) {
        String mssg = "You Ordered a Donut!";
        Toast toast = Toast.makeText(this,mssg, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void icecream(View view) {
        String mssg = "You Ordered a IceCream!";
        Toast toast = Toast.makeText(this,mssg, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void froyo(View view) {
        String mssg = "You Ordered a Froyo!";
        Toast toast = Toast.makeText(this,mssg, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void shop(View view) {
        Intent obj = new Intent(MainActivity.this, OrderActivity.class);
        obj.putExtra(EXTRA_message, mssg);
        startActivity(obj);
    }
}