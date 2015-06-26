package com.example.joaquin.charliesapp;

import java.util.ArrayList;

/**
 * Created by J on 6/23/2015.
 */
public class MoneySet {

    private ArrayList<Money> allMoney = new ArrayList<Money>();
    private static String diff;
    private static MoneySet moneySet;

    public MoneySet(String diff) {

        this.diff = diff;

        if(diff.equals("medium")) {
            allMoney.add(new Money(R.drawable.one_dollar, "1 dollar, which is 4 quarters! Tap the image again to hide this answer!"));
            allMoney.add(new Money(R.drawable.five_dollars, "5 dollars, which is 5 one dollar bills! Tap the image again to hide this answer!"));
            allMoney.add(new Money(R.drawable.ten_dollar_bill, "10 dollars, which is 2 five dollar bills! Tap the image again to hide this answer!"));
            allMoney.add(new Money(R.drawable.twenty_dollars, "20 dollars, which is 2 ten dollar bills! Tap the image again to hide this answer!"));
            allMoney.add(new Money(R.drawable.fifty_dollars, "50 dollars, which is 5 ten dollar bills! Tap the image again to hide this answer!"));
        } else if(diff.equals("hard")) {
            allMoney.add(new Money(R.drawable.first_combo, "3 pennies, 1 nickel, and 1 quarter, which adds up to 33 cents! Tap the image again to hide this answer!"));
            allMoney.add(new Money(R.drawable.second_combo, "2 pennies, 1 nickel, 1 dime, 1 quarter, and 1 one dollar bill, which adds up to 1 dollar and 42 cents! Tap the image again to hide this answer!"));
            allMoney.add(new Money(R.drawable.third_combo, "5 dimes and 2 quarters, which adds up to 1 dollar! Tap the image again to hide this answer!"));
            allMoney.add(new Money(R.drawable.fourth_combo, "2 pennies, 1 nickel, 1 dime, 2 quarters, 1 ten dollar bill, and 1 twenty dollar bill, which adds up to 30 dollars and 67 cents! Tap the image again to hide this answer!"));
            allMoney.add(new Money(R.drawable.fifth_combo, "5 twenty dollar bills, which adds up to 100 dollars! Tap the image again to hide this answer!"));
        } else {
            allMoney.add(new Money(R.drawable.four_pennies, "4 pennies, which is 4 cents! Tap the image again to hide this answer!"));
            allMoney.add(new Money(R.drawable.two_nickels, "2 nickels, which is 10 cents! Tap the image again to hide this answer!"));
            allMoney.add(new Money(R.drawable.one_quarter, "1 quarter, which is 25 cents! Tap the image again to hide this answer!"));
            allMoney.add(new Money(R.drawable.three_dimes, "3 dimes, which is 30 cents! Tap the image again to hide this answer!"));
            allMoney.add(new Money(R.drawable.one_nickel_one_dime, "1 nickel and 1 dime, which is 15 cents! Tap the image again to hide this answer!"));
        }

    }

    public static MoneySet getMoneySet() {

        moneySet = new MoneySet(diff);
        return moneySet;

    }

    public ArrayList<Money> getAllMoney() {
        return allMoney;
    }

    public Money getMoney(int id) {
        return allMoney.get(id);
    }

}
