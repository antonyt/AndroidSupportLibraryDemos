package com.antonyt.demos.androidsupportlibrary.wakefulbroadcastreceiver;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

public class MyBroadcastReceiver extends WakefulBroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(MyBroadcastReceiver.class.getName(), "onReceive");
        Intent service = new Intent(context, MyService.class);
        startWakefulService(context, service);
    }
}
