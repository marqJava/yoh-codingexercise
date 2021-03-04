package com.yoh.codingexcercise.rest.dto.opentdb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * To store the result level json data from the opentdb web serviceTo store
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenTbDbResultDto {
    private String category;
    private String type;
    private String difficulty;
    private String question;
    private String correctAnswer;
    private List<String> incorrectAnswers;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

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

    @JsonProperty("correct_answer")
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @JsonProperty("incorrect_answers")
    public List<String> getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(List<String> incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OpenTbDbResultDto{");
        sb.append("category='").append(category).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", difficulty='").append(difficulty).append('\'');
        sb.append(", question='").append(question).append('\'');
        sb.append(", correctAnswer='").append(correctAnswer).append('\'');
        sb.append(", incorrectAnswers=").append(incorrectAnswers);
        sb.append('}');
        return sb.toString();
    }
}
