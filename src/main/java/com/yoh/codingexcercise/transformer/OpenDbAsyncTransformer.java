package com.yoh.codingexcercise.transformer;

import com.yoh.codingexcercise.rest.dto.opentdb.OpenTbDbResponseDto;
import com.yoh.codingexcercise.rest.dto.opentdb.OpenTbDbResultDto;
import com.yoh.codingexcercise.rest.dto.results.CategoryDto;
import com.yoh.codingexcercise.rest.dto.results.QuizDto;
import com.yoh.codingexcercise.rest.dto.results.ResultItemDto;
import com.yoh.codingexcercise.service.ProcessCategoriesServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

/**
 * Transformer interface implementation to get the main
 * level ob the object response
 */
@Component
public class OpenDbAsyncTransformer implements IcAsyncDoubleTransformer<OpenTbDbResponseDto, QuizDto> {

    @Autowired
    IcSingleTransformer<OpenTbDbResultDto, ResultItemDto> openTbDbResultTransformer;


    private static final Logger logger = LoggerFactory.getLogger(OpenDbAsyncTransformer.class);

    /**
     * Populates the QuizDto response object from the opentdb
     * web service response dto
     * @param obj1
     * @param obj2
     * @return
     */
    @Async
    @Override
    public CompletableFuture<Boolean> processAsync(OpenTbDbResponseDto obj1, QuizDto obj2) {
        if (obj1 != null && obj1.getResponseCode() == 0) {
            if (obj1.getResults() != null && !obj1.getResults().isEmpty()) {
                obj1.getResults().forEach((iter -> {
                    if (iter.getCategory() != null && !iter.getCategory().isEmpty()) {
                        CategoryDto categoryDto = new CategoryDto(iter.getCategory());
                        int idx = obj2.getCategories().indexOf(categoryDto);
                        if (idx == -1) {
                            logger.info("adding category==>" + categoryDto.getCategory());
                            obj2.getCategories().add(categoryDto);
                        } else {
                            categoryDto = obj2.getCategories().get(idx);
                        }
                        categoryDto.getResults().add(openTbDbResultTransformer.transform(iter));
                    }
                }));
            }
        }
        logger.info("Category process completed.");
        return CompletableFuture.completedFuture(true);
    }
}
