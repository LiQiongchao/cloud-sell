package com.chaox.product;

import com.chaox.product.enums.ResultEnum;

/**
 * @Author: LiQiongchao
 * @Date: 2019/7/11 22:58
 */
public class ProductException extends RuntimeException {
    private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
