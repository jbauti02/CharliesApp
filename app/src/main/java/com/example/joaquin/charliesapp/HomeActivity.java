package com.example.joaquin.charliesapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class HomeActivity extends FragmentActivity {

    RadioGroup diffGroup;
    RadioButton easyRadio, mediumRadio, hardRadio;
    String diffKey = "difficulty";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        diffGroup = (RadioGroup)findViewById(R.id.difficulty_group);
        diffGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                easyRadio = (RadioButton)findViewById(R.id.easy_radio);
                mediumRadio = (RadioButton)findViewById(R.id.medium_radio);
                hardRadio = (RadioButton)findViewById(R.id.hard_radio);

                if(mediumRadio.isChecked()) {
                    diffKey = "medium";
                } else if(hardRadio.isChecked()) {
                    diffKey = "hard";
                } else {
                    diffKey = "easy";
                }
            }
        });
    }

    public void getMoney(View view) {
        Intent intent = new Intent(this, MoneyActivity.class);
        intent.putExtra(Integer.toString(R.string.diff_key), diffKey);
        startActivity(intent);
    }

    public void getMath(View view) {
        Intent intent = new Intent(this, MathActivity.class);
        intent.putExtra(Integer.toString(R.string.diff_key), diffKey);
        startActivity(intent);
    }

    public void getClock(View view) {
        Intent intent = new Intent(this, ClockActivity.class);
        intent.putExtra(Integer.toString(R.string.diff_key), diffKey);
        startActivity(intent);
    }

    public void getSpelling(View view) {
        Intent intent = new Intent(this, SpellActivity.class);
        intent.putExtra(Integer.toString(R.string.diff_key), diffKey);
        startActivity(intent);
    }

}
