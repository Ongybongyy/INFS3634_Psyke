package com.example.finalproject.entities.math;

import java.io.Serializable;
import java.util.List;

import com.example.finalproject.QuizQuestion;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MathResponse implements Serializable, QuizQuestion
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("choices")
    @Expose
    private List<String> choices = null;
    @SerializedName("correct_choice")
    @Expose
    private Integer correctChoice;
    @SerializedName("instruction")
    @Expose
    private String instruction;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("topic")
    @Expose
    private String topic;
    @SerializedName("difficulty")
    @Expose
    private String difficulty;

    private final static long serialVersionUID = -6784121195697159038L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MathResponse() {
    }

    /**
     * 
     * @param difficulty
     * @param question
     * @param instruction
     * @param topic
     * @param id
     * @param choices
     * @param correctChoice
     * @param category
     */
    public MathResponse(String id, String question, List<String> choices, Integer correctChoice, String instruction, String category, String topic, String difficulty) {
        super();
        this.id = id;
        this.question = question;
        this.choices = choices;
        this.correctChoice = correctChoice;
        this.instruction = instruction;
        this.category = category;
        this.topic = topic;
        this.difficulty = difficulty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MathResponse withId(String id) {
        this.id = id;
        return this;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public MathResponse withQuestion(String question) {
        this.question = question;
        return this;
    }

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }

    public MathResponse withChoices(List<String> choices) {
        this.choices = choices;
        return this;
    }

    public Integer getCorrectChoice() {
        return correctChoice;
    }

    public void setCorrectChoice(Integer correctChoice) {
        this.correctChoice = correctChoice;
    }

    public MathResponse withCorrectChoice(Integer correctChoice) {
        this.correctChoice = correctChoice;
        return this;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public MathResponse withInstruction(String instruction) {
        this.instruction = instruction;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public MathResponse withCategory(String category) {
        this.category = category;
        return this;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public MathResponse withTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public MathResponse withDifficulty(String difficulty) {
        this.difficulty = difficulty;
        return this;
    }

}
