package com.antonyt.demos.androidsupportlibrary.notifications;

import com.antonyt.demos.androidsupportlibrary.R;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.TextView;

public class NotificationsExampleActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications_example_activity);

        TextView text = (TextView) findViewById(R.id.text);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                Notification notification = makeNotification();
                notificationManager.notify(1, notification);
            }
        });
    }

    private Notification makeNotification() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);

        PendingIntent pendingIntent = PendingIntent.getActivity(NotificationsExampleActivity.this, 0, new Intent(),
                PendingIntent.FLAG_UPDATE_CURRENT);

        return new NotificationCompat.Builder(this)
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(bitmap))
                .addAction(R.drawable.ic_launcher, "Action Button 1", pendingIntent)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle("Notification example title")
                .setContentText("Notification example text")
                .setContentIntent(pendingIntent)
                .build();
    }
}
