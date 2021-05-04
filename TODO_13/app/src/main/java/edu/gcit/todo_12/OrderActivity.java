package edu.gcit.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

    }

    public void radiobot(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.sameDay:
                DisplayToast(getString(R.string.sameday));
                break;

            case R.id.nextDay:
                DisplayToast(getString(R.string.nextday));
                break;

            case R.id.pickUp:
                DisplayToast(getString(R.string.pickup));
                break;

            default:
                break;
        }
    }

    public void DisplayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}