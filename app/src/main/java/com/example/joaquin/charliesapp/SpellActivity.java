package com.example.joaquin.charliesapp;

import android.support.v4.app.Fragment;

public class SpellActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new SpellFragment();
    }
}
