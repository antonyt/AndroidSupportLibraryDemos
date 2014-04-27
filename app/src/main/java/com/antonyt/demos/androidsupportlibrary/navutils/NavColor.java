package com.antonyt.demos.androidsupportlibrary.navutils;

import com.antonyt.demos.androidsupportlibrary.R;

import android.graphics.Color;

public enum NavColor {

    RED(R.string.red, Color.RED),
    GREEN(R.string.green, Color.GREEN),
    BLUE(R.string.blue, Color.BLUE);

    private final int mTitleResId;
    private final int mColor;

    NavColor(int titleResId, int color) {
        mTitleResId = titleResId;
        mColor = color;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getColor() {
        return mColor;
    }
}
