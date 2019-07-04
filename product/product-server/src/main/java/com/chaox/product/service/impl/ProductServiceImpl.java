package com.chaox.product.service.impl;

import com.chaox.product.enums.ProductStatus;
import com.chaox.product.model.ProductInfo;
import com.chaox.product.repository.ProductInfoRepository;
import com.chaox.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/21 0:15
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findAll() {
        return productInfoRepository.findByProductStatus(ProductStatus.UP.getCode());
    }
}
