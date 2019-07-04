package com.chaox.common;

import lombok.Data;

/**
 * @Author: LiQiongchao
 * @Date: 2019/7/5 0:02
 */
@Data
public class DecreaseStockInput {

    private String productId;

    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

}
