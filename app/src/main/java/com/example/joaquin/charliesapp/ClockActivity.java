package com.example.joaquin.charliesapp;

import android.support.v4.app.Fragment;

public class ClockActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ClockFragment();
    }
}
