package com.example.joaquin.charliesapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by J on 6/23/2015.
 */
public class MoneyFragment extends Fragment {

    private View view;
    private int moneyNum = 0;
    Money money;
    MoneySet moneySet;
    ArrayList<Money> allMoney;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String diff = getActivity().getIntent().getStringExtra(Integer.toString(R.string.diff_key));
        moneySet = new MoneySet(diff);
        allMoney = moneySet.getAllMoney();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_money, container, false);
        initMoney();
        clickPrev();
        clickNext();

        return view;

    }

    private void initMoney() {
        money = moneySet.getMoneySet().getMoney(moneyNum);
        final ImageView money_pic = (ImageView)view.findViewById(R.id.money_pic);
        final TextView flipText = (TextView)view.findViewById(R.id.flip);
        final TextView answerText = (TextView)view.findViewById(R.id.money_answer);
        money_pic.setImageResource(money.getImage());
        money_pic.setOnClickListener(new View.OnClickListener() {
            boolean switched = true;

            @Override
            public void onClick(View v) {
                if (switched) {
                    flipText.setText(R.string.flip_answer);
                    answerText.setText(money.getAnswer());
                    answerText.setVisibility(View.VISIBLE);
                    switched = false;
                } else {
                    flipText.setText(R.string.flip);
                    answerText.setVisibility(View.INVISIBLE);
                    switched = true;
                }
            }
        });
    }

    private void clickPrev() {
        Button button = (Button)view.findViewById(R.id.prev_button);
        final TextView flipText = (TextView)view.findViewById(R.id.flip);
        final TextView answerText = (TextView)view.findViewById(R.id.money_answer);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int size = allMoney.size();
                moneyNum = (moneyNum + (size - 1)) % allMoney.size();
                flipText.setText(R.string.flip);
                answerText.setVisibility(View.INVISIBLE);
                initMoney();
            }
        });
    }

    private void clickNext() {
        Button button = (Button)view.findViewById(R.id.next_button);
        final TextView flipText = (TextView)view.findViewById(R.id.flip);
        final TextView answerText = (TextView)view.findViewById(R.id.money_answer);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                moneyNum = (moneyNum + 1) % allMoney.size();
                flipText.setText(R.string.flip);
                answerText.setVisibility(View.INVISIBLE);
                initMoney();
            }
        });
    }
}
