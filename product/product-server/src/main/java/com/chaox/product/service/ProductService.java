package com.chaox.product.service;

import com.chaox.common.DecreaseStockInput;
import com.chaox.common.ProductInfoOutput;
import com.chaox.product.model.ProductInfo;

import java.util.List;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/21 0:13
 */
public interface ProductService {

    List<ProductInfo> findAll();

    List<ProductInfoOutput> findList(List<String> productIdList);

    List<ProductInfoOutput> decreaseStock(List<DecreaseStockInput> decreaseStockInputList);

}
