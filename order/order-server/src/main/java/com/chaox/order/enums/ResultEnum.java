package com.chaox.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/30 11:15
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {

    PARAM_ERROR(100, "参数错误"),
    CART_EMPTY(101, "购物车为空"),
    ;
    private Integer code;
    private String message;

}
