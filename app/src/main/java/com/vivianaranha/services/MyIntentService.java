package com.vivianaranha.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by sooheib on 6/2/16.
 */
public class MyIntentService extends IntentService {


    public MyIntentService() {
        super("Intent Service");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Service Created", Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("IntentService", "Displaying a message");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show();
    }

}
