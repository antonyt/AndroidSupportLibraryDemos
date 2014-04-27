package com.antonyt.demos.androidsupportlibrary.navutils;

import com.antonyt.demos.androidsupportlibrary.R;
import com.antonyt.demos.androidsupportlibrary.fragment.ColorFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class NavUtilsExampleChildActivity extends ActionBarActivity {

    public static final String COLOR_KEY = "color";

    public static Intent newIntent(Context context, NavColor color) {
        Intent intent = new Intent(context, NavUtilsExampleChildActivity.class);
        intent.putExtra(COLOR_KEY, color);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.nav_utils_example_child_activity);

        NavColor color = (NavColor) getIntent().getSerializableExtra(COLOR_KEY);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, ColorFragment.newInstance(color.getColor()))
                    .commit();
        }

        TextView text = (TextView) findViewById(R.id.text);
        text.setText("Current: " + getString(color.getTitleResId()) + "\nClick to go to next");
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavColor next = NavColor.values()[new Random().nextInt(NavColor.values().length)];
                Intent intent = NavUtilsExampleChildActivity.newIntent(NavUtilsExampleChildActivity.this, next);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
