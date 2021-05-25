package com.gcit.todo_21;

import android.os.AsyncTask;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.ref.WeakReference;
import java.util.Random;
import java.util.WeakHashMap;

public class SimpleAsyncTask extends AsyncTask<Void, Void, String> {
    private WeakReference<TextView> mFirst_text; //object is no longer used (generic), garbage collector will collect it

    public SimpleAsyncTask(TextView tv){
        mFirst_text = new WeakReference<>(tv);
    }

    @Override
    //String because onPost is string type
    protected String doInBackground(Void... voids) {
        Random r = new Random();
        int n = r.nextInt(11);
        int s = n * 200;

        try {
            Thread.sleep(s);
        }
        catch (InterruptedException e){
            e.printStackTrace(); //to print exception
        }
        return "Awake at last after sleeping for"+ s + "milliseconds!";
    }

    @Override
    protected void onPostExecute(String s) {
        mFirst_text.get().setText(s);
    }
}
