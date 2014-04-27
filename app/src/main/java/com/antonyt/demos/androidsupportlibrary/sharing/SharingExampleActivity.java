package com.antonyt.demos.androidsupportlibrary.sharing;

import com.antonyt.demos.androidsupportlibrary.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SharingExampleActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sharing_example_activity);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = makeIntentBuilder().getIntent();
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem shareItem = menu.add("Share");
        ShareCompat.configureMenuItem(shareItem, makeIntentBuilder());
        MenuItemCompat.setShowAsAction(shareItem, MenuItemCompat.SHOW_AS_ACTION_ALWAYS);

        return super.onCreateOptionsMenu(menu);

    }

    private ShareCompat.IntentBuilder makeIntentBuilder() {
        return ShareCompat.IntentBuilder.from(SharingExampleActivity.this)
                .setText("This is the text to share")
                .setSubject("This is the subject")
                .setType("text/plain");
    }
}
