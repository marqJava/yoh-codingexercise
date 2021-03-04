package com.yoh.codingexcercise.rest.dto.opentdb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * To store the response level json data from the opentdb web service
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenTbDbResponseDto {
    private int responseCode;
    private List<OpenTbDbResultDto> results;

    @JsonProperty("response_code")
    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<OpenTbDbResultDto> getResults() {
        return results;
    }

    public void setResults(List<OpenTbDbResultDto> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OpenTbDbResponseDto{");
        sb.append("responseCode=").append(responseCode);
        sb.append(", results=").append(results);
        sb.append('}');
        return sb.toString();
    }
}
