package com.example.joaquin.charliesapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by J on 6/24/2015.
 */
public class ClockFragment extends Fragment {
    private View view;
    private int clockNum = 0;
    Clock clock;
    ClockSet clockSet;
    ArrayList<Clock> clocks;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String diff = getActivity().getIntent().getStringExtra(Integer.toString(R.string.diff_key));
        clockSet = new ClockSet(diff);
        clocks = clockSet.getClocks();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_clock, container, false);
        initClock();
        clickPrev();
        clickNext();
        return view;
    }

    private void initClock() {
        clock = ClockSet.getClockSet().getClock(clockNum);
        ImageView imageView = (ImageView)view.findViewById(R.id.clock_pic);
        TextView clockQuestion = (TextView)view.findViewById(R.id.clock_question);
        final TextView belowTextView = (TextView)view.findViewById(R.id.below_text_view);
        final TextView clockOutput = (TextView)view.findViewById(R.id.clock_answer);
        final EditText clockText = (EditText)view.findViewById(R.id.clock_text);
        Button submitButton = (Button)view.findViewById(R.id.submit_clock);
        imageView.setImageResource(clock.getImage());
        clockQuestion.setText(clock.getQuestion());
        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final String input = clockText.getText().toString();
                if(input.equals(clock.getAnswer())) {
                    clockText.setText("");
                    belowTextView.setText(R.string.yay);
                    clockOutput.setText(R.string.correct);
                    clockOutput.setVisibility(View.VISIBLE);
                } else if(input.equals("")) {
                    clockText.setText("");
                    belowTextView.setText(R.string.error_below);
                    clockOutput.setText(R.string.clock_blank_error);
                    clockOutput.setVisibility(View.VISIBLE);
                } else {
                    clockText.setText("");
                    belowTextView.setText(R.string.not_clock_answer);
                    clockOutput.setText(R.string.incorrect);
                    clockOutput.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void clickPrev() {
        Button button = (Button)view.findViewById(R.id.clock_prev_button);
        final TextView belowTextView = (TextView)view.findViewById(R.id.below_text_view);
        final TextView clockOutput = (TextView)view.findViewById(R.id.clock_answer);
        final EditText clockText = (EditText)view.findViewById(R.id.clock_text);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int size = clocks.size();
                clockNum = (clockNum + (size - 1)) % clocks.size();
                clockText.setText("");
                belowTextView.setText(R.string.submit_clock_answer);
                clockOutput.setVisibility(View.INVISIBLE);
                initClock();
            }
        });
    }

    private void clickNext() {
        Button button = (Button)view.findViewById(R.id.clock_next_button);
        final TextView belowTextView = (TextView)view.findViewById(R.id.below_text_view);
        final TextView clockOutput = (TextView)view.findViewById(R.id.clock_answer);
        final EditText clockText = (EditText)view.findViewById(R.id.clock_text);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                clockNum = (clockNum + 1) % clocks.size();
                clockText.setText("");
                belowTextView.setText(R.string.submit_clock_answer);
                clockOutput.setVisibility(View.INVISIBLE);
                initClock();
            }
        });
    }
}
