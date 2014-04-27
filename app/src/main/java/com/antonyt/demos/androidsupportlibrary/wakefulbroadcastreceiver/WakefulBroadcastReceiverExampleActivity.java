package com.antonyt.demos.androidsupportlibrary.wakefulbroadcastreceiver;

import com.antonyt.demos.androidsupportlibrary.R;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class WakefulBroadcastReceiverExampleActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.wakeful_broadcast_receiver_example_activity);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                Intent intent = new Intent("com.antonyt.demos.androidsupportlibrary.wakefulAction");
                PendingIntent pendingIntent = PendingIntent
                        .getBroadcast(WakefulBroadcastReceiverExampleActivity.this, 0, intent, 0);
                alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 60 * 1000, pendingIntent);
            }
        });

    }
}
