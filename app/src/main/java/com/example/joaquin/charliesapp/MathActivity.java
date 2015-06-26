package com.example.joaquin.charliesapp;

import android.support.v4.app.Fragment;

public class MathActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new MathFragment();
    }
}
