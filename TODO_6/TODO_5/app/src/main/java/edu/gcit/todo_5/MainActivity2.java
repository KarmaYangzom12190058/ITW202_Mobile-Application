package edu.gcit.todo_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    public static final String EXTRA_replyMessage = "edu.gcit.todo_4Reply";
    private EditText reply_Message;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent obj = getIntent();
        String message = obj.getStringExtra(MainActivity.EXTRA_message);
        TextView text = findViewById(R.id.Display_message);
        text.setText(message);
        reply_Message = findViewById(R.id.ReplyText);
        Log.d(LOG_TAG, "onCreate");
    }

    public void Reply(View view) {
        Intent obj1 = new Intent();
        String message_reply = reply_Message.getText().toString();
        obj1.putExtra(EXTRA_replyMessage, message_reply);
        setResult(RESULT_OK, obj1);
        finish();
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }
}