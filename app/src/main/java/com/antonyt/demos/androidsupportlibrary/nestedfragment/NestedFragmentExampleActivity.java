package com.antonyt.demos.androidsupportlibrary.nestedfragment;

import com.antonyt.demos.androidsupportlibrary.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class NestedFragmentExampleActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.nested_fragment_example_activity);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, new ParentFragment())
                    .commit();
        }
    }
}
