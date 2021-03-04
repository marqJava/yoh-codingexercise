package com.yoh.codingexcercise.rest.dto.results;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is going to be used as a json response for the result items
 */
public class ResultItemDto implements Serializable {
    private String type;
    private String difficulty;
    private String question;
    private List<String> allAnswers = new ArrayList<>();
    private String correctAnswer;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAllAnswers() {
        return allAnswers;
    }

    public void setAllAnswers(List<String> allAnswers) {
        this.allAnswers = allAnswers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ResultItemDto{");
        sb.append("type='").append(type).append('\'');
        sb.append(", difficulty='").append(difficulty).append('\'');
        sb.append(", question='").append(question).append('\'');
        sb.append(", allAnswers=").append(allAnswers);
        sb.append(", correctAnswer='").append(correctAnswer).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
