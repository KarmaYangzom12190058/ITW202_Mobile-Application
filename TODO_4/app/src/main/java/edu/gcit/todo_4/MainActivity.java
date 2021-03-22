package edu.gcit.todo_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_message = "edu.gcit.todo_4";

    public static int TextRequest = 1;
    private EditText Send_Message;
    private TextView reply_header;
    private TextView reply_message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Send_Message = findViewById(R.id.sendText);
        reply_header = findViewById(R.id.ReplyText);
        reply_message = findViewById(R.id.DisplayReply);
    }

    public void Send(View view) {
        Intent obj = new Intent(this, MainActivity2.class);
        String message = Send_Message.getText().toString();
        obj.putExtra(EXTRA_message, message);
        startActivityForResult(obj, TextRequest);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TextRequest){
            if(resultCode == RESULT_OK){
                String final_message = data.getStringExtra(MainActivity2.EXTRA_replyMessage);
                reply_header.setVisibility(View.VISIBLE);
                reply_message.setText(final_message);
                reply_message.setVisibility(View.VISIBLE);
            }
        }
    }
}