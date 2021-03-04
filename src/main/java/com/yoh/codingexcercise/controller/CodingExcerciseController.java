package com.yoh.codingexcercise.controller;

import com.yoh.codingexcercise.rest.dto.results.QuizResponseDto;
import com.yoh.codingexcercise.service.IcProcessCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

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
    public Mono<QuizResponseDto> quiz() {
        return processCategoriesService.getData();
    }
}
