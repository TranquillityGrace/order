package com.wyy.order.exception;

import com.wyy.order.enums.ResultEnum;

/**
 * 订单异常
 *
 * @Author WYY
 * @Date 2019-08-13 16:12
 */
public class OrderException extends RuntimeException{

    private Integer code;

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public OrderException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
