package com.github.youssfbr.clients.models;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class Response<T> {

    private int statusCode;
    private long timeStamp;
    private T data;

    public Response() {
        this.timeStamp = System.currentTimeMillis();
    }

}
