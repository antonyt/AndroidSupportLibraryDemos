package com.antonyt.demos.androidsupportlibrary.nestedfragment;

import com.antonyt.demos.androidsupportlibrary.R;
import com.antonyt.demos.androidsupportlibrary.fragment.ColorFragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ParentFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.parent_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState == null) {
            getChildFragmentManager()
                    .beginTransaction()
                    .add(R.id.top_container, ColorFragment.newInstance(Color.RED))
                    .add(R.id.bottom_container, ColorFragment.newInstance(Color.BLUE))
                    .commit();
        }
    }
}
