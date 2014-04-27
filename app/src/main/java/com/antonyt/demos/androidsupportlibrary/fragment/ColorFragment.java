package com.antonyt.demos.androidsupportlibrary.fragment;

import com.antonyt.demos.androidsupportlibrary.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ColorFragment extends Fragment {

    public static final String COLOR_KEY = "color";

    private int mColor;

    public static ColorFragment newInstance(int color) {
        ColorFragment fragment = new ColorFragment();
        Bundle args = new Bundle();
        args.putInt(COLOR_KEY, color);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mColor = getArguments().getInt(COLOR_KEY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.color_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getView().setBackgroundColor(mColor);
    }
}
