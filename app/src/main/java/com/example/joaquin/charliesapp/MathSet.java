package com.example.joaquin.charliesapp;

import java.util.ArrayList;

/**
 * Created by J on 6/24/2015.
 */
public class MathSet {
    private ArrayList<Math> allMath = new ArrayList<Math>();
    private static String diff;
    private static MathSet mathSet;

    public MathSet(String diff) {

        this.diff = diff;
        if(diff.equals("medium")) {
            allMath.add(new Math("What is 12 + 1?", "The answer is 13!"));
            allMath.add(new Math("What is 9 + 8?", "The answer is 17!"));
            allMath.add(new Math("What is 15 - 13?", "The answer is 2!"));
            allMath.add(new Math("What is 11 + 10?", "The answer is 21!"));
            allMath.add(new Math("What is 14 - 9?", "The answer is 5!"));
            allMath.add(new Math("What is 3 * 2?", "The answer is 6!"));
            allMath.add(new Math("What is 1 * 9?", "The answer is 9!"));
            allMath.add(new Math("What is 12 - 8?", "The answer is 4!"));
            allMath.add(new Math("What is 19 - 11?", "The answer is 8!"));
            allMath.add(new Math("What is 13 + 12?", "The answer is 25!"));
        } else if(diff.equals("hard")) {
            allMath.add(new Math("What is 4 * 4?", "The answer is 16!"));
            allMath.add(new Math("What is 10 * 2?", "The answer is 20!"));
            allMath.add(new Math("What is 23 - 14?", "The answer is 9!"));
            allMath.add(new Math("What is 4 + 13?", "The answer is 17!"));
            allMath.add(new Math("What is 3 * 21?", "The answer is 63!"));
            allMath.add(new Math("What is 85 - 34?", "The answer is 51!"));
            allMath.add(new Math("What is 8 * 9?", "The answer is 72!"));
            allMath.add(new Math("What is 12 * 8?", "The answer is 96!"));
            allMath.add(new Math("What is 62 - 29?", "The answer is 33!"));
            allMath.add(new Math("What is 56 + 79?", "The answer is 135!"));
        } else {
            allMath.add(new Math("What is 1 + 1?", "The answer is 2!"));
            allMath.add(new Math("What is 4 + 2?", "The answer is 6!"));
            allMath.add(new Math("What is 7 - 3?", "The answer is 4!"));
            allMath.add(new Math("What is 6 + 4?", "The answer is 10!"));
            allMath.add(new Math("What is 3 - 0?", "The answer is 3!"));
            allMath.add(new Math("What is 7 + 8?", "The answer is 15!"));
            allMath.add(new Math("What is 6 - 6?", "The answer is 0!"));
            allMath.add(new Math("What is 2 + 9?", "The answer is 11!"));
            allMath.add(new Math("What is 10 - 1?", "The answer is 9!"));
            allMath.add(new Math("What is 6 + 1?", "The answer is 7!"));
        }

    }

    public static MathSet getMathSet() {
        mathSet = new MathSet(diff);
        return mathSet;
    }

    public ArrayList<Math> getAllMath() {
        return allMath;
    }

    public Math getMath(int id) {
        return allMath.get(id);
    }
}
