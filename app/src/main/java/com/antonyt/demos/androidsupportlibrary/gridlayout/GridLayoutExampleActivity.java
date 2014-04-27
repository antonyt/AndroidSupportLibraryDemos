package com.antonyt.demos.androidsupportlibrary.gridlayout;

import com.antonyt.demos.androidsupportlibrary.R;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayout;

public class GridLayoutExampleActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_layout_activity);

        GridLayout gridLayout = (GridLayout) findViewById(R.id.grid_layout);

    }
}
