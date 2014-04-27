package com.antonyt.demos.androidsupportlibrary.sharing;

import com.antonyt.demos.androidsupportlibrary.R;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class SharingTargetExampleActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharing_target_example_activity);

        TextView textView = (TextView) findViewById(R.id.text);
        ImageView imageView = (ImageView) findViewById(R.id.icon);

        ShareCompat.IntentReader from = ShareCompat.IntentReader.from(this);
        CharSequence callingApplicationLabel = from.getCallingApplicationLabel();
        Drawable callingActivityIcon = from.getCallingActivityIcon();

        textView.setText("From: " + callingApplicationLabel);
        imageView.setImageDrawable(callingActivityIcon);

    }
}
