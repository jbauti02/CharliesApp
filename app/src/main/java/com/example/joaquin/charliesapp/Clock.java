package com.example.joaquin.charliesapp;

/**
 * Created by J on 6/24/2015.
 */
public class Clock {
    private int image;
    private String question;
    private String answer;

    public Clock(int image, String question, String answer) {
        this.image = image;
        this.question = question;
        this.answer = answer;
    }

    public int getImage() {
        return image;
    }
    public String getQuestion() {
        return question;
    }
    public String getAnswer() {
        return answer;
    }
}
