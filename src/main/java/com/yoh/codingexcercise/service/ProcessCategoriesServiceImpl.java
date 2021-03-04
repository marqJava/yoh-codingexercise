package com.yoh.codingexcercise.service;

import com.yoh.codingexcercise.rest.client.IcOpenTbDbRestClient;
import com.yoh.codingexcercise.rest.dto.opentdb.OpenTbDbResponseDto;
import com.yoh.codingexcercise.rest.dto.results.QuizDto;
import com.yoh.codingexcercise.rest.dto.results.QuizResponseDto;
import com.yoh.codingexcercise.transformer.IcAsyncDoubleTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * The service logic that handles the logic the requested transform data
 */
@Service
public class ProcessCategoriesServiceImpl implements IcProcessCategoriesService {
    @Autowired
    IcOpenTbDbRestClient openTbDbRestClient;

    @Autowired
    IcAsyncDoubleTransformer<OpenTbDbResponseDto, QuizDto> transformer;

    private static final Logger logger = LoggerFactory.getLogger(ProcessCategoriesServiceImpl.class);

    /**
     *  call the rest client api and calls the transformers to get the
     *  response object that is going to be returned to the clients
     *  of the spring boot controller
     * @return
     */
    public Mono<QuizResponseDto> getData() {
        QuizResponseDto result = new QuizResponseDto();

        List<QuizDto> quizDtos = new ArrayList<>();
        QuizDto newObj = new QuizDto();

        try {
            //Async calls
            logger.info("calling the ws......................");
            CompletableFuture<OpenTbDbResponseDto> filmResponse = openTbDbRestClient.getApiData("5", "11");
            CompletableFuture<OpenTbDbResponseDto> musicResponse = openTbDbRestClient.getApiData("5", "12");

            CompletableFuture.allOf(filmResponse, musicResponse).join();

            logger.info("filmResponse.isDone==>{}", filmResponse.isDone());
            logger.info("musicResponse.isDone==>{}", musicResponse.isDone());

            CompletableFuture<Boolean> pcFilm = transformer.processAsync(filmResponse.get(), newObj);
            CompletableFuture<Boolean> pcMusic = transformer.processAsync(musicResponse.get(), newObj);

            CompletableFuture.allOf(pcFilm, pcMusic).join();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        quizDtos.add(newObj);
        result.setQuiz(quizDtos);
        logger.info("execution is completed===>");

        return Mono.just(result);
    }
}
