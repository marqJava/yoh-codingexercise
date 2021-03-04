package com.yoh.codingexcercise.transformer;

import com.yoh.codingexcercise.rest.dto.opentdb.OpenTbDbResultDto;
import com.yoh.codingexcercise.rest.dto.results.ResultItemDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Transform the opentdb result level object
 */
@Component
public class OpenTbDbResultTransformer implements IcSingleTransformer<OpenTbDbResultDto, ResultItemDto> {
    private static final Logger logger = LoggerFactory.getLogger(OpenTbDbResultTransformer.class);

    /**
     * maps the data from the opentdb result dto object to the
     * ResultDto detail level data
     * @param sourceData
     * @return
     */
    @Override
    public ResultItemDto transform(OpenTbDbResultDto sourceData) {
        ResultItemDto result = new ResultItemDto();

        if (sourceData != null) {
            result.setType(sourceData.getType());
            result.setDifficulty(sourceData.getDifficulty());
            result.setQuestion(sourceData.getQuestion());
            result.setQuestion(sourceData.getQuestion());
            result.getAllAnswers().add(sourceData.getCorrectAnswer());

            if (sourceData.getIncorrectAnswers() != null && !sourceData.getIncorrectAnswers().isEmpty()) {
                result.getAllAnswers().addAll(sourceData.getIncorrectAnswers());
            }

            result.setCorrectAnswer(sourceData.getCorrectAnswer());
        }

        return result;
    }
}
