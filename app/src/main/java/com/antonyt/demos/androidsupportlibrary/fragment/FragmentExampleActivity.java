package com.antonyt.demos.androidsupportlibrary.fragment;

import com.antonyt.demos.androidsupportlibrary.R;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Random;

public class FragmentExampleActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_example_activity);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.top_container, ColorFragment.newInstance(Color.RED))
                    .add(R.id.bottom_container, ColorFragment.newInstance(Color.BLUE))
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Change Bottom Fragment");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int[] colors = new int[]{Color.GREEN, Color.LTGRAY, Color.MAGENTA};
        int randomColor = colors[new Random().nextInt(colors.length)];

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.bottom_container, ColorFragment.newInstance(randomColor))
                .addToBackStack(null)
                .commit();
        getSupportFragmentManager().executePendingTransactions();

        Toast.makeText(FragmentExampleActivity.this,
                "Backstack depth = " + getSupportFragmentManager().getBackStackEntryCount(), Toast.LENGTH_SHORT).show();

        return true;
    }
}