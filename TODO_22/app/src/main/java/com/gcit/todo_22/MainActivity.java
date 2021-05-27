package com.gcit.todo_22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText bookInput;
    private TextView titleText;
    private TextView authorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookInput = findViewById(R.id.bookInput);
        titleText = findViewById(R.id.titleText);
        authorText = findViewById(R.id.authorText);
    }

    public void searchBooks(View view) {
        String queryString = bookInput.getText().toString();

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connectivityManager != null){
            networkInfo = connectivityManager.getActiveNetworkInfo();
        }

        if (networkInfo != null && networkInfo.isConnected() && queryString.length() != 0){
            new FetchBooks(titleText, authorText).execute(queryString);
            authorText.setText("");
            titleText.setText("loading...");
        }
        else{
            if (queryString.length() == 0){
                authorText.setText("");
                titleText.setText("No search term!");
            }
            else {
                authorText.setText("");
                titleText.setText("No network!");
            }
        }

    }
}