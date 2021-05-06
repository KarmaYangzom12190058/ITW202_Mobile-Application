package edu.gcit.todo_12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_message = "edu.gcit.todo_12";
    String mssg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void DisplayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void donut(View view) {
        mssg = getString(R.string.order_D);
        DisplayToast(mssg);
    }

    public void icecream(View view) {
        mssg = getString(R.string.order_I);
        DisplayToast(mssg);
    }

    public void froyo(View view) {
        mssg = getString(R.string.order_F);
        DisplayToast(mssg);
    }

    public void shop(View view) {
        Intent obj = new Intent(this, OrderActivity.class);
        obj.putExtra(EXTRA_message, mssg);
        startActivity(obj);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflates the menu; this adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.menu_file, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_order:
                Intent in = new Intent(this,OrderActivity.class);
                in.putExtra(EXTRA_message, mssg);
                startActivity(in);
                return true;

            case R.id.action_contact:
                DisplayToast("You selected Contact!");
                return true;

            case R.id.action_favourite:
                DisplayToast("You selected Favourite!");
                return true;
            case R.id.action_status:
                DisplayToast("You selected Status!");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}