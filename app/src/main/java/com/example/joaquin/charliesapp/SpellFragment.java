package com.example.joaquin.charliesapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by J on 6/25/2015.
 */
public class SpellFragment extends Fragment {
    private View view;
    private int spellNum = 0;
    Spell spell;
    SpellSet spellSet;
    ArrayList<Spell> spells;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String diff = getActivity().getIntent().getStringExtra(Integer.toString(R.string.diff_key));
        spellSet = new SpellSet(diff);
        spells = spellSet.getSpells();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_spell, container, false);
        initSpell();
        clickPrev();
        clickNext();
        return view;
    }

    private void initSpell() {

        spell = SpellSet.getSpellSet().getSpell(spellNum);

        TextView word = (TextView)view.findViewById(R.id.word);
        final TextView belowTextView = (TextView)view.findViewById(R.id.below_text_view);
        final TextView spellOutput = (TextView)view.findViewById(R.id.spell_output);
        final EditText spellText = (EditText)view.findViewById(R.id.spell_text);
        Button submitButton = (Button)view.findViewById(R.id.spell_button);
        word.setText(spell.getWord());
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String input = spellText.getText().toString();
                if(input.equalsIgnoreCase(spell.getWord())) {
                    spellText.setText("");
                    belowTextView.setText(R.string.yay);
                    spellOutput.setText(R.string.correct);
                    spellOutput.setVisibility(View.VISIBLE);
                } else if(input.equals("")) {
                    spellText.setText("");
                    belowTextView.setText(R.string.error_below);
                    spellOutput.setText(R.string.spell_blank_error);
                    spellOutput.setVisibility(View.VISIBLE);
                } else {
                    spellText.setText("");
                    belowTextView.setText(R.string.not_spell_answer);
                    spellOutput.setText(R.string.incorrect);
                    spellOutput.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    private void clickPrev() {
        Button button = (Button)view.findViewById(R.id.spell_prev_button);
        final TextView belowTextView = (TextView)view.findViewById(R.id.below_text_view);
        final TextView spellOutput = (TextView)view.findViewById(R.id.spell_output);
        final EditText spellText = (EditText)view.findViewById(R.id.spell_text);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int size = spells.size();
                spellNum = (spellNum + (size - 1)) % spells.size();
                spellText.setText("");
                belowTextView.setText(R.string.submit_spell_answer);
                spellOutput.setVisibility(View.INVISIBLE);
                initSpell();
            }
        });
    }

    private void clickNext() {
        Button button = (Button)view.findViewById(R.id.spell_next_button);
        final TextView belowTextView = (TextView)view.findViewById(R.id.below_text_view);
        final TextView spellOutput = (TextView)view.findViewById(R.id.spell_output);
        final EditText spellText = (EditText)view.findViewById(R.id.spell_text);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                spellNum = (spellNum + 1) % spells.size();
                spellText.setText("");
                belowTextView.setText(R.string.submit_spell_answer);
                spellOutput.setVisibility(View.INVISIBLE);
                initSpell();
            }
        });
    }
}
