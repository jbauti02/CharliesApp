package com.example.joaquin.charliesapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by J on 6/24/2015.
 */
public class MathFragment extends Fragment {

    private View view;
    private int mathNum = 0;
    Math math;
    MathSet mathSet;
    ArrayList<Math> allMath;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String diff = getActivity().getIntent().getStringExtra(Integer.toString(R.string.diff_key));
        mathSet = new MathSet(diff);
        allMath = mathSet.getAllMath();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_math, container, false);
        initMath();
        clickPrev();
        clickNext();
        return view;
    }

    private void initMath() {
        math = MathSet.getMathSet().getMath(mathNum);
        final TextView mathQuestion = (TextView)view.findViewById(R.id.math_question);
        mathQuestion.setText(math.getQuestion());
        mathQuestion.setOnClickListener(new View.OnClickListener() {

            boolean switched = true;

            @Override
            public void onClick(View v) {
                if(switched) {
                    mathQuestion.setText(math.getAnswer());
                    switched = false;
                } else {
                    mathQuestion.setText(math.getQuestion());
                    switched = true;
                }
            }
        });
    }

    private void clickPrev() {
        Button button = (Button)view.findViewById(R.id.math_prev_button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int size = allMath.size();
                mathNum = (mathNum + (size - 1)) % allMath.size();
                initMath();
            }
        });
    }

    private void clickNext() {
        Button button = (Button)view.findViewById(R.id.math_next_button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mathNum = (mathNum + 1) % allMath.size();
                initMath();
            }
        });
    }

}
