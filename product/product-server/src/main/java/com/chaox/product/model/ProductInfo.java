package com.chaox.product.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/17 23:17
 */
@Data
@Entity
public class ProductInfo {
    @Id
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productStock;
    private String productDescription;
    private String productIcon;
    private Integer productStatus;
    private Integer categoryType;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
