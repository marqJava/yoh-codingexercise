package com.yoh.codingexcercise.service;

import com.yoh.codingexcercise.rest.client.IcOpenTbDbRestClient;
import com.yoh.codingexcercise.rest.dto.opentdb.OpenTbDbResponseDto;
import com.yoh.codingexcercise.rest.dto.opentdb.OpenTbDbResultDto;
import com.yoh.codingexcercise.rest.dto.results.CategoryDto;
import com.yoh.codingexcercise.rest.dto.results.QuizDto;
import com.yoh.codingexcercise.rest.dto.results.ResultItemDto;
import com.yoh.codingexcercise.transformer.IcAsyncDoubleTransformer;
import com.yoh.codingexcercise.transformer.IcSingleTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

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
    public List<QuizDto> getData() {
        List<QuizDto> result = new ArrayList<>();
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

            logger.info("pcFilm.isDone==>{}", pcFilm.isDone());
            logger.info("pcMusic.isDone==>{}", pcMusic.isDone());

            CompletableFuture.allOf(pcFilm, pcMusic).join();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        result.add(newObj);
        logger.debug("execution is completed===>");
        return result;
    }
}
