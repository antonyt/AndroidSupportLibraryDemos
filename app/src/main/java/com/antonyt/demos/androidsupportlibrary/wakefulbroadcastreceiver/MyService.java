package com.antonyt.demos.androidsupportlibrary.wakefulbroadcastreceiver;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyService extends IntentService {

    public MyService() {
        super("MyService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        for (int i = 0; i < 30; i++) {
            Log.d(MyService.class.getName(), "Doing work... " + i);
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
            }
        }

        Log.d(MyService.class.getName(), "Work complete!");

        MyBroadcastReceiver.completeWakefulIntent(intent);
    }
}
