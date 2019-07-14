package com.chaox.product.controller;

import com.chaox.common.DecreaseStockInput;
import com.chaox.common.ProductInfoOutput;
import com.chaox.product.model.ProductCategory;
import com.chaox.product.model.ProductInfo;
import com.chaox.product.service.CategoryService;
import com.chaox.product.service.ProductService;
import com.chaox.product.utils.ResultVoUtil;
import com.chaox.product.vo.ProductInfoVo;
import com.chaox.product.vo.ProductVo;
import com.chaox.product.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/17 23:06
 */
@RestController
@RequestMapping("/product")
public class ProductInfoController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVo<List<ProductVo>> list() {
        List<ProductInfo> productInfos = productService.findAll();
        List<Integer> categoryId = productInfos.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        List<ProductCategory> categories = categoryService.findByCategoryTypeIn(categoryId);
        List<ProductVo> productVos = new ArrayList<>(categoryId.size() + 1);
        ProductVo productVo = null;
        for (ProductCategory category : categories) {
            productVo = new ProductVo();
            productVo.setCategoryName(category.getCategoryName());
            productVo.setCategoryType(category.getCategoryType());
            List<ProductInfoVo> infoVos = new ArrayList<>();
            for (ProductInfo info : productInfos) {
                if (!info.getCategoryType().equals(category.getCategoryType())) {
                    continue;
                }
                ProductInfoVo infoVo = new ProductInfoVo();
                infoVo.setProductId(info.getProductId());
                infoVo.setProductDescription(info.getProductDescription());
                infoVo.setProductName(info.getProductName());
                infoVo.setProductPrice(info.getProductPrice());
                infoVo.setProductIcon(info.getProductIcon());
                infoVos.add(infoVo);
            }
            productVo.setProductInfoVoList(infoVos);
            productVos.add(productVo);
        }
        return ResultVoUtil.success(productVos);
    }

    /**
     * 获取商品列表(给订单服务用的)
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public  List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList) {
        return productService.findList(productIdList);
    }

    /**
     * 减库存
     * @param decreaseStockInputList
     * @return
     */
    @PostMapping("/decreaseStock")
    public  List<ProductInfoOutput> decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList) {
        return productService.decreaseStock(decreaseStockInputList);
    }


}
