package com.chaox.product.service.impl;

import com.chaox.common.DecreaseStockInput;
import com.chaox.common.ProductInfoOutput;
import com.chaox.product.ProductException;
import com.chaox.product.enums.ProductStatus;
import com.chaox.product.enums.ResultEnum;
import com.chaox.product.model.ProductInfo;
import com.chaox.product.repository.ProductInfoRepository;
import com.chaox.product.service.ProductService;
import com.google.gson.Gson;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/21 0:15
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public List<ProductInfo> findAll() {
        return productInfoRepository.findByProductStatus(ProductStatus.UP.getCode());
    }

    @Override
    public List<ProductInfoOutput> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList).stream().map(e -> {
            ProductInfoOutput output = new ProductInfoOutput();
            BeanUtils.copyProperties(e, output);
            return output;
        }).collect(Collectors.toList());
    }

    @Override
    public List<ProductInfoOutput> decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
        List<ProductInfoOutput> list = this.decreaseStockProcess(decreaseStockInputList);
        amqpTemplate.convertAndSend("productInfo", new Gson().toJson(list));
        return list;
    }

    @Transactional
    protected List<ProductInfoOutput> decreaseStockProcess(List<DecreaseStockInput> decreaseStockInputList) {
        List<ProductInfoOutput> list = new ArrayList<>(decreaseStockInputList.size() + 1);
        for (DecreaseStockInput decreaseStockInput : decreaseStockInputList) {
            Optional<ProductInfo> info = productInfoRepository.findById(decreaseStockInput.getProductId());
            if (!info.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo = info.get();
            int stock = productInfo.getProductStock().intValue() - decreaseStockInput.getProductQuantity().intValue();
            if (stock < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(stock);
            ProductInfo save = productInfoRepository.save(productInfo);
            ProductInfoOutput output = new ProductInfoOutput();
            BeanUtils.copyProperties(productInfo, output);
            list.add(output);
        }
        return list;
    }
}
