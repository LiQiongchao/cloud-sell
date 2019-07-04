package com.chaox.product.repository;

import com.chaox.product.model.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/18 23:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void queryProductInfoRepository() {
        List<ProductInfo> productInfos = productInfoRepository.findByProductStatus(0);
        Assert.assertTrue(productInfos.size()>0);
    }

}