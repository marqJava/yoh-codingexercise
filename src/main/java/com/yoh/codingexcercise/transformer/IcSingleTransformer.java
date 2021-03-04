package com.yoh.codingexcercise.transformer;


import com.fasterxml.jackson.core.JsonProcessingException;

public interface IcSingleTransformer<S, R> {
    R transform(S sourceData);
}
