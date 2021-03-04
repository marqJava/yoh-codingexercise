package com.yoh.codingexcercise.rest.dto.results;

import java.util.ArrayList;
import java.util.List;

public class QuizResponseDto {
    private List<QuizDto> quiz = new ArrayList<>();

    public List<QuizDto> getQuiz() {
        return quiz;
    }

    public void setQuiz(List<QuizDto> quiz) {
        this.quiz = quiz;
    }
}
