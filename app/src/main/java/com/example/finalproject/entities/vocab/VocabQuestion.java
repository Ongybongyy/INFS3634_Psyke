package com.example.finalproject.entities.vocab;


import com.example.finalproject.QuizQuestion;
import com.example.finalproject.entities.vocab.word.PartOfSpeech;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

enum VocabQuestionType {
    ALL,
    NONE,
    MIXED
}


public class VocabQuestion implements QuizQuestion {
    private static final String NONE = "None of the Above.";
    private static final String ALL = "All of the Above.";

    private String question, answer, word;
    private ArrayList<String> choices = new ArrayList<>();
    private VocabQuestionType questionType;

    private List<String> syns, ants;
    private Random random = new Random();

    public VocabQuestion(String word, PartOfSpeech wordResponse) throws Exception {
        this.word = word;
        syns = wordResponse.getSyn() != null ? wordResponse.getSyn() : new ArrayList<>();
        ants = wordResponse.getAnt() != null ? wordResponse.getAnt() : new ArrayList<>();

        questionType = VocabQuestionType.MIXED;
        setQuestion();
        choices.add(answer);
        Collections.shuffle(choices, random);
    }

    private void setQuestion() throws Exception {
        if (ants.size() > 3) {
            set4AntQ();
        } else if(ants.size() > 0){
            setMixedQ();
        } else if (syns.size() > 2){
            set4SynQ();
        } else {
            throw new Exception();
        }
    }

    //there are 1,2,3 ants
    private void setMixedQ() throws Exception {
        choices.addAll(ants.subList(0,ants.size()));
        if (choices.size() == 1) {
            answer = choices.get(0);
            question = generateQuestion(true); //answer is the antonym
            choices = new ArrayList<>();
            if (syns.size() > 3) {
                choices.addAll(syns.subList(0, 4));

            } else {
                if (syns.size() < 2) {
                    throw (new Exception());
                }//get new q
                choices.add(ALL);
                if (syns.size() == 3) {
                    choices.addAll(syns);
                }
                if (syns.size() == 2) {
                    choices.addAll(syns);
                    choices.add(NONE);
                }
            }
        }
        else if(choices.size() == 2 || choices.size() == 3) {
            if (syns.size() == 0) throw new Exception();
            question = generateQuestion(false);
            answer = syns.get(0);
            choices.add(ALL);
            if(choices.size() < 4) choices.add(NONE);
        }
    }

    private void set4SynQ() {
        choices.addAll(syns.subList(0, Math.min(syns.size(), 4))); // add 4 synonyms
        questionType = random.nextBoolean() ? VocabQuestionType.ALL : VocabQuestionType.NONE;
        if(choices.size() == 3) {
            if (questionType == VocabQuestionType.ALL) {
                choices.add(NONE);
            } else {
                choices.add(ALL);
            }
        }
        if (questionType == VocabQuestionType.ALL) {
            answer = ALL;
            question = generateQuestion(false);
        } else {
            answer = NONE;
            question = generateQuestion(true);
        }
    }

    private void set4AntQ() {
        choices.addAll(ants.subList(0, 4)); //have 4 antonyms
        if (syns.size() > 0) { //if there are synonyms
            answer = syns.get(0);
            question = generateQuestion(false); //answer is the synonym
        } else { //if there are no synonyms and only the 4 antonyms
            questionType = random.nextBoolean() ? VocabQuestionType.ALL : VocabQuestionType.NONE;
            if (questionType == VocabQuestionType.ALL) {
                answer = ALL;
                question = generateQuestion(true);
            } else {
                answer = NONE;
                question = generateQuestion(false);
            }
        }
    }

    private String generateQuestion(boolean isAnsAntonym) {
        String qType = isAnsAntonym ? "ANTONYM" : "SYNONYM";
        return "Select the " + qType + " of the word: " + this.word + ".";
    }

    @Override
    public ArrayList<String> getChoices() {
        return choices;
    }

    @Override
    public Integer getCorrectChoice(){
        return choices.indexOf(answer);
    }

    @Override
    public String getQuestion() {
        return question;
    }

}
