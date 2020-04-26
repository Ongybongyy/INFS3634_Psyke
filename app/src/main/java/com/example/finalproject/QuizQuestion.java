package com.example.finalproject;

import java.util.List;

public interface QuizQuestion {
    List<String> getChoices();
    Integer getCorrectChoice();
    String getQuestion();
 }
