package com.github.youssfbr.clients.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;


@Builder
@Getter
public class ErrorMapResponse {

    private int httpStatus;
    private long timeStamp;
    private Map<String, String> errors;

}
