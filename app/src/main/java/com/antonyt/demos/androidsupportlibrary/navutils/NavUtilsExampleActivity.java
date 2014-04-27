package com.antonyt.demos.androidsupportlibrary.navutils;

import com.antonyt.demos.androidsupportlibrary.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class NavUtilsExampleActivity extends ActionBarActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        setContentView(R.layout.nav_utils_example_activity);

        mListView = (ListView) findViewById(R.id.list);

        mListView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return NavColor.values().length;
            }

            @Override
            public NavColor getItem(int position) {
                return NavColor.values()[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView;
                if (convertView == null) {
                    LayoutInflater inflater = LayoutInflater.from(NavUtilsExampleActivity.this);
                    textView = (TextView) inflater.inflate(R.layout.simple_row, parent, false);
                } else {
                    textView = (TextView) convertView;
                }

                textView.setText(getItem(position).getTitleResId());
                return textView;
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NavColor color = (NavColor) parent.getItemAtPosition(position);
                Intent intent = NavUtilsExampleChildActivity.newIntent(NavUtilsExampleActivity.this, color);
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
