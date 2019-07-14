package com.chaox.product.impl;


import com.chaox.product.ProductServerApplicationTests;
import com.chaox.product.model.ProductCategory;
import com.chaox.product.service.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/21 0:25
 */
@Component
public class CategoryServiceImplTest extends ProductServerApplicationTests {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> byCategoryTypeIn = categoryService.findByCategoryTypeIn(Arrays.asList(1, 2));
        Assert.assertTrue(byCategoryTypeIn.size() > 0);
    }
}