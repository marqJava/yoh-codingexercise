package com.yoh.codingexcercise.service;

import com.yoh.codingexcercise.rest.dto.results.QuizResponseDto;
import reactor.core.publisher.Mono;

public interface IcProcessCategoriesService {
    Mono<QuizResponseDto> getData();
}
