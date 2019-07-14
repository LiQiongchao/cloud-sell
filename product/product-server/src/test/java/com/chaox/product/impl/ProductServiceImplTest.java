package com.chaox.product.impl;

import com.chaox.common.DecreaseStockInput;
import com.chaox.common.ProductInfoOutput;
import com.chaox.product.ProductServerApplicationTests;
import com.chaox.product.model.ProductInfo;
import com.chaox.product.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/21 0:20
 */
@Component
public class ProductServiceImplTest extends ProductServerApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    public void findAll() {
        List<ProductInfo> all = productService.findAll();
        Assert.assertTrue(all.size() > 0);
    }

    @Test
    public void findList() {
        List<ProductInfoOutput> all = productService.findList(Arrays.asList("100", "109"));
        Assert.assertTrue(all.size() > 0);
    }

    @Test
    public void decreaseStock() {
        List<DecreaseStockInput> inputs = new ArrayList<>();
        inputs.add(new DecreaseStockInput("100", 1));
        inputs.add(new DecreaseStockInput("101", 2));
        List<ProductInfoOutput> all = productService.decreaseStock(inputs);
        Assert.assertTrue(all.size() > 0);
    }
}