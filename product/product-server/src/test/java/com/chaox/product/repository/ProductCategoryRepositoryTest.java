package com.chaox.product.repository;

import com.chaox.product.model.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/18 23:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findByCategoryType() {
        List<ProductCategory> byCategoryType = productCategoryRepository.findByCategoryType(1);
        Assert.assertTrue(byCategoryType.size() > 0);
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> byCategoryType = productCategoryRepository.findByCategoryTypeIn(Arrays.asList(1,2));
        Assert.assertTrue(byCategoryType.size() > 0);
    }


}