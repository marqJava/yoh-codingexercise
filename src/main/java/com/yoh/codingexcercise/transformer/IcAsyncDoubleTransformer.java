package com.yoh.codingexcercise.transformer;

import com.yoh.codingexcercise.rest.dto.opentdb.OpenTbDbResponseDto;
import com.yoh.codingexcercise.rest.dto.results.QuizDto;

import java.util.concurrent.CompletableFuture;

public interface IcAsyncDoubleTransformer<U, V> {
    CompletableFuture<Boolean> processAsync(U obj1, V obj2);
}
