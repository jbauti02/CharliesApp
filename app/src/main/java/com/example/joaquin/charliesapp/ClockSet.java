package com.example.joaquin.charliesapp;

import java.util.ArrayList;

/**
 * Created by J on 6/24/2015.
 */
public class ClockSet {
    private ArrayList<Clock> clocks = new ArrayList<Clock>();
    private static String diff;
    private static ClockSet clockSet;

    public ClockSet(String diff) {
        this.diff = diff;

        if(diff.equals("medium")) {
            clocks.add(new Clock(R.drawable.medium_clock_1, "What time is this in AM?", "5:15"));
            clocks.add(new Clock(R.drawable.medium_clock_2, "What time is this in PM?", "3:55"));
            clocks.add(new Clock(R.drawable.medium_clock_3, "What time is this in AM?", "9:30"));
            clocks.add(new Clock(R.drawable.medium_clock_4, "What time is this in AM?", "11:05"));
            clocks.add(new Clock(R.drawable.medium_clock_5, "What time is this in PM?", "2:40"));
        } else if(diff.equals("hard")) {
            clocks.add(new Clock(R.drawable.hard_clock_1, "What time is this in PM?", "12:43"));
            clocks.add(new Clock(R.drawable.hard_clock_2, "What time is this in AM?", "8:17"));
            clocks.add(new Clock(R.drawable.hard_clock_3, "What time is this in PM?", "10:22"));
            clocks.add(new Clock(R.drawable.hard_clock_4, "What time is this in AM?", "4:59"));
            clocks.add(new Clock(R.drawable.hard_clock_5, "What time is this in PM?", "11:36"));
        } else {
            clocks.add(new Clock(R.drawable.easy_clock_1, "What time is this in PM?", "12:00"));
            clocks.add(new Clock(R.drawable.easy_clock_2, "What time is this in PM?", "3:00"));
            clocks.add(new Clock(R.drawable.easy_clock_3, "What time is this in AM?", "7:00"));
            clocks.add(new Clock(R.drawable.easy_clock_4, "What time is this in PM?", "10:00"));
            clocks.add(new Clock(R.drawable.easy_clock_5, "What time is this in AM?", "6:00"));
        }
    }

    public static ClockSet getClockSet() {
        clockSet = new ClockSet(diff);
        return clockSet;
    }

    public ArrayList<Clock> getClocks() {
        return clocks;
    }

    public Clock getClock(int id) {
        return clocks.get(id);
    }
}
