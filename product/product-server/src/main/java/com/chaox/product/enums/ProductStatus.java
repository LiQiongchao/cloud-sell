package com.chaox.product.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/21 0:17
 */
@Getter
@AllArgsConstructor
public enum ProductStatus {

    UP(0, "上架"),
    DOWN(1, "下架")
    ;

    private Integer code;
    private String msg;


}
