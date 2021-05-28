package edu.gcit.todo_23;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {

    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + "ACTION_CUSTOM_BROADCAST";


    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();

        if (intentAction != null){
            String ToastMessage = " ";

            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    ToastMessage = "Power Connected!";
                    break;

                case Intent.ACTION_POWER_DISCONNECTED:
                    ToastMessage = "Power Disconnected!";
                    break;

                case ACTION_CUSTOM_BROADCAST:
                    ToastMessage = "Custom Broadcast Received";
                    break;

            }
            //to display toast
            Toast.makeText(context, ToastMessage, Toast.LENGTH_SHORT).show();
        }
    }
}