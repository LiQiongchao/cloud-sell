package com.chaox.product.enums;

import lombok.Getter;

/**
 * @Author: LiQiongchao
 * @Date: 2019/7/11 22:58
 */
@Getter
public enum ResultEnum {


    PRODUCT_NOT_EXIST(1, "商品不存在"),
    PRODUCT_STOCK_ERROR(2, "库存有误"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
