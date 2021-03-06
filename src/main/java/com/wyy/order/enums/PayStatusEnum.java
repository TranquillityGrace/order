package com.wyy.order.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum {

    WAIT(0,"等待支付"),

    SUCCESS(1,"支付完成"),

    ;

    private Integer Code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        Code = code;
        this.message = message;
    }
}
