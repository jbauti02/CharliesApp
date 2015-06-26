package com.example.joaquin.charliesapp;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by J on 6/25/2015.
 */
public class SpellSet {
    private ArrayList<Spell> spells = new ArrayList<Spell>();
    private static String diff;
    private static SpellSet spellSet;

    public SpellSet(String diff) {

        this.diff = diff;

        if(diff.equals("medium")) {
            spells.add(new Spell("jump"));
            spells.add(new Spell("your"));
            spells.add(new Spell("out"));
            spells.add(new Spell("learn"));
            spells.add(new Spell("save"));
            spells.add(new Spell("school"));
            spells.add(new Spell("father"));
            spells.add(new Spell("keep"));
            spells.add(new Spell("safe"));
            spells.add(new Spell("grade"));
            spells.add(new Spell("reached"));
            spells.add(new Spell("raise"));
            spells.add(new Spell("theme"));
            spells.add(new Spell("scream"));
            spells.add(new Spell("easy"));
            spells.add(new Spell("batteries"));
            spells.add(new Spell("fuel"));
            spells.add(new Spell("iron"));
            spells.add(new Spell("solve"));
            spells.add(new Spell("science"));
        } else if(diff.equals("hard")) {
            spells.add(new Spell("continent"));
            spells.add(new Spell("carefully"));
            spells.add(new Spell("camouflage"));
            spells.add(new Spell("different"));
            spells.add(new Spell("upon"));
            spells.add(new Spell("though"));
            spells.add(new Spell("carry"));
            spells.add(new Spell("strong"));
            spells.add(new Spell("story"));
            spells.add(new Spell("burst"));
            spells.add(new Spell("writing"));
            spells.add(new Spell("stream"));
            spells.add(new Spell("street"));
            spells.add(new Spell("distance"));
            spells.add(new Spell("least"));
            spells.add(new Spell("hundred"));
            spells.add(new Spell("computer"));
            spells.add(new Spell("object"));
            spells.add(new Spell("quotient"));
            spells.add(new Spell("difference"));
        } else {
            spells.add(new Spell("high"));
            spells.add(new Spell("every"));
            spells.add(new Spell("near"));
            spells.add(new Spell("west"));
            spells.add(new Spell("dress"));
            spells.add(new Spell("best"));
            spells.add(new Spell("next"));
            spells.add(new Spell("else"));
            spells.add(new Spell("green"));
            spells.add(new Spell("checked"));
            spells.add(new Spell("grand"));
            spells.add(new Spell("stand"));
            spells.add(new Spell("am"));
            spells.add(new Spell("matter"));
            spells.add(new Spell("area"));
            spells.add(new Spell("blue"));
            spells.add(new Spell("assume"));
            spells.add(new Spell("teacher"));
            spells.add(new Spell("like"));
            spells.add(new Spell("thing"));
        }
    }

    public static SpellSet getSpellSet() {
        spellSet = new SpellSet(diff);
        return spellSet;
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public Spell getSpell(int id) {
        return spells.get(id);
    }
}
