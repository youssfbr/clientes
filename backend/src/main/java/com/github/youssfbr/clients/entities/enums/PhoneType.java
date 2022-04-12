package com.github.youssfbr.clients.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {

    RES("Res"),
    COM("Com"),
    CEL("Cel");

    private final String description;

}
