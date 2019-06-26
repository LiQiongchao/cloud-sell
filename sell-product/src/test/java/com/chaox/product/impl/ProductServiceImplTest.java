package com.chaox.product.impl;

import com.chaox.product.SellProductApplicationTests;
import com.chaox.product.model.ProductInfo;
import com.chaox.product.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/21 0:20
 */
@Component
public class ProductServiceImplTest extends SellProductApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    public void findAll() {
        List<ProductInfo> all = productService.findAll();
        Assert.assertTrue(all.size() > 0);
    }
}