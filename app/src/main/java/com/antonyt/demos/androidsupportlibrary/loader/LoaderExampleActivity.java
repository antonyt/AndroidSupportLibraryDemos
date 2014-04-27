package com.antonyt.demos.androidsupportlibrary.loader;

import com.antonyt.demos.androidsupportlibrary.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.widget.TextView;

public class LoaderExampleActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<String> {

    private String mMessage;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loader_example_activity);
        mTextView = (TextView) findViewById(R.id.text);
        updateMessage();

        getSupportLoaderManager().initLoader(0, null, this);
    }

    private void updateMessage() {
        if (mMessage == null) {
            mTextView.setText("Message not loaded");
        } else {
            mTextView.setText(mMessage);
        }
    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        return new AsyncTaskLoader<String>(this) {

            private String mData;

            @Override
            public String loadInBackground() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
                mData = "Load Complete";
                return mData;
            }

            @Override
            protected void onStartLoading() {
                if (mData != null) {
                    deliverResult(mData);
                } else {
                    forceLoad();
                }
            }
        };
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        mMessage = data;
        updateMessage();
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {
        mMessage = null;
        updateMessage();
    }
}
