package edu.gcit.tod0_8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private EditText openWebsite;
    private EditText openLocation;
    private EditText shareText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openWebsite = findViewById(R.id.website);
        openLocation = findViewById(R.id.location);
        shareText = findViewById(R.id.shareText);
    }

    public void open_Website(View view) {
        String text1 = openWebsite.getText().toString();
        Uri url = Uri.parse(text1);
        Intent obj = new Intent(Intent.ACTION_VIEW, url);
        if (obj.resolveActivity(getPackageManager()) != null){
            startActivity(obj);
        }
        else{
            Log.d("Implicit Intent", "Error!");
        }
    }

    public void open_Location(View view) {
        String text2 = openLocation.getText().toString();
        Uri url = Uri.parse("geo:0,0?q="+text2);
        Intent obj2 = new Intent(Intent.ACTION_VIEW, url);
        if (obj2.resolveActivity(getPackageManager()) != null){
            startActivity(obj2);
        }
        else{
            Log.d("Implicit Intent", "Error!");
        }
    }

    public void share_Text(View view) {
        String text3 = shareText.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(text3)
                .startChooser();
    }
}