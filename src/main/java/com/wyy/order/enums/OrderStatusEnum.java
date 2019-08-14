package com.wyy.order.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {

    NEW(0,"新订单"),

    FINISHED(1,"已完成"),

    CANCEL(2,"取消订单"),
    ;

    private Integer Code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        Code = code;
        this.message = message;
    }
}
