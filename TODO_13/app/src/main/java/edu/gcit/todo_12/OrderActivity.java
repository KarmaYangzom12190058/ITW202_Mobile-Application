package edu.gcit.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        textview = findViewById(R.id.mes);
        Intent in = getIntent();
        String message = in.getStringExtra(MainActivity.EXTRA_message);
        textview.setText(message);

        spinner = findViewById(R.id.spinner);
        if(spinner!=null){
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.phone_label, R.layout.support_simple_spinner_dropdown_item);
        if(spinner != null){
            spinner.setAdapter(adapter);
        }
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String message = parent.getItemAtPosition(position).toString();
        DisplayToast(message);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        ///
    }
}