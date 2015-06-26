package com.example.joaquin.charliesapp;

import android.support.v4.app.Fragment;

public class MoneyActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new MoneyFragment();
    }
}
