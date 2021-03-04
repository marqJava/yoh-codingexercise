package com.yoh.codingexcercise.rest.client;

import com.yoh.codingexcercise.rest.dto.opentdb.OpenTbDbResponseDto;

import java.util.concurrent.CompletableFuture;

public interface IcOpenTbDbRestClient {
    CompletableFuture<OpenTbDbResponseDto> getApiData(String amount, String category);
}
