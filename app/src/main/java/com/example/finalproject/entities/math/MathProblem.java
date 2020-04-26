package com.example.finalproject.entities.math;

import com.example.finalproject.QuizQuestion;

import java.util.List;

public class MathProblem implements QuizQuestion {
    private List<String> choices;
    private int correctChoice;
    private String question;

    public MathProblem(List<String> choiceList, int rightChoice, String q) {
        this.question = q;
        this.choices = choiceList;
        this.correctChoice = rightChoice;
    }

    @Override
    public List<String> getChoices() {
        return this.choices;
    }

    @Override
    public Integer getCorrectChoice() {
        return this.correctChoice;
    }

    @Override
    public String getQuestion() {
        return this.question;
    }
}
