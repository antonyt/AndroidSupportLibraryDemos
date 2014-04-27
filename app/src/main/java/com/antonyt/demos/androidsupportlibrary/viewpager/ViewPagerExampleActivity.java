package com.antonyt.demos.androidsupportlibrary.viewpager;

import com.antonyt.demos.androidsupportlibrary.R;
import com.antonyt.demos.androidsupportlibrary.fragment.ColorFragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

public class ViewPagerExampleActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_example_activity);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        PagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            private int[] colors = new int[]{Color.RED, Color.BLUE, Color.GREEN, Color.LTGRAY};

            @Override
            public Fragment getItem(int position) {
                return ColorFragment.newInstance(colors[position]);
            }

            @Override
            public int getCount() {
                return colors.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return String.valueOf(position);
            }
        };

        viewPager.setAdapter(adapter);
    }
}
