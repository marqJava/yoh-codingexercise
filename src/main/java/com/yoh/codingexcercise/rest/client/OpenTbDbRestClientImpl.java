package com.yoh.codingexcercise.rest.client;

import com.yoh.codingexcercise.rest.dto.opentdb.OpenTbDbResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Calls the opentbdb rest client service to get the data
 */
@Component
public class OpenTbDbRestClientImpl implements IcOpenTbDbRestClient {

    @Value("${opentdb.url}")
    private String serviceUrl;

    private static final Logger logger = LoggerFactory.getLogger(OpenTbDbRestClientImpl.class);

    /**
     * Call the rest web service
     * @param amount
     * @param category
     * @return
     */
    @Async
    public CompletableFuture<OpenTbDbResponseDto> getApiData(String amount, String category) {
        OpenTbDbResponseDto response = new OpenTbDbResponseDto();

        RestTemplate rt = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> paramVals = new HashMap<String, String>();
        paramVals.put("amount", amount);
        paramVals.put("category", category);

        response = rt.getForObject(serviceUrl, OpenTbDbResponseDto.class, paramVals);
        logger.debug("rest client execution completed for {}.", category);
        return CompletableFuture.completedFuture(response);
    }

}
