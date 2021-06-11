package com.gcit.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class proverbs_TwnetyFour extends AppCompatActivity {
    TextView proverb_text, count_text;
    CardView copy_btn, share_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proverbs__twnety_four);

        proverb_text = findViewById(R.id.proverbs_text);
        count_text = findViewById(R.id.count_text);

        copy_btn = findViewById(R.id.copyBtn);
        share_btn = findViewById(R.id.shareBtn);
    }
    public void copy(View view) {
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("text", proverb_text.getText().toString());

        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(clip);
        }
        Toast.makeText(getApplicationContext(), "copied", Toast.LENGTH_SHORT).show();
    }

    public void share(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, proverb_text.getText());
        startActivity(Intent.createChooser(intent, "Share dzongkha proverbs via:"));
    }
}