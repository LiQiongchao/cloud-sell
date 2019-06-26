package com.chaox.product.service;

import com.chaox.product.model.ProductCategory;

import java.util.List;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/21 0:22
 */
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes);

}
