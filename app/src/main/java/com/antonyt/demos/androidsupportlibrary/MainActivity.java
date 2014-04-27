package com.antonyt.demos.androidsupportlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.list);

        mListView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return ExampleType.values().length;
            }

            @Override
            public ExampleType getItem(int position) {
                return ExampleType.values()[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView;
                if (convertView == null) {
                    LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
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
                ExampleType exampleType = (ExampleType) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, exampleType.getClazz());
                startActivity(intent);
            }
        });

    }

}
