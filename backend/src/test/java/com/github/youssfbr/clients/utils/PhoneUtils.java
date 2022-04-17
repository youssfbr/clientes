package com.github.youssfbr.clients.utils;

import com.github.youssfbr.clients.dtos.PhoneDTO;
import com.github.youssfbr.clients.entities.Phone;
import com.github.youssfbr.clients.entities.enums.PhoneType;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "1199999-99999";
    private static final PhoneType PHONE_TYPE = PhoneType.CEL;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .phoneType(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .phoneType(PHONE_TYPE)
                .build();
    }
}
