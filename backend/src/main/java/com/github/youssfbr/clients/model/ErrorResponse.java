package com.github.youssfbr.clients.model;

import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class ErrorResponse {

    private String message;
    private int httpStatus;
    private long timeStamp;

}
