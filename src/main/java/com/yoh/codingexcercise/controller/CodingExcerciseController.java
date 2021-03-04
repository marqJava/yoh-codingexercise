package com.yoh.codingexcercise.controller;

import com.yoh.codingexcercise.rest.dto.results.QuizResponseDto;
import com.yoh.codingexcercise.service.IcProcessCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring mvc controller for the rest service
 */
@RestController
public class CodingExcerciseController {

    @Autowired
    IcProcessCategoriesService processCategoriesService;


    /**
     * Calls the service with the requested format trnasformed
     * @return
     */
    @GetMapping("${coding.exercise.endpoint}")
    public QuizResponseDto quiz() {
        QuizResponseDto result = new QuizResponseDto();

        result.setQuiz(processCategoriesService.getData());
        return result;
    }
}
