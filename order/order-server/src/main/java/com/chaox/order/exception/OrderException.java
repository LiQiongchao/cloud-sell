package com.chaox.order.exception;

import com.chaox.order.enums.ResultEnum;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/30 11:12
 */
public class OrderException extends RuntimeException {
    private Integer code;
    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum paramError) {
        super(paramError.getMessage());
        this.code = paramError.getCode();
    }
}
