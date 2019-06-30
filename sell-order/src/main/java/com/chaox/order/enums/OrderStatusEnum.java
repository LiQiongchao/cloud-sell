package com.chaox.order.enums;

import lombok.Getter;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/30 10:15
 */
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "取消"),
    ;
    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
