package com.chaox.product.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/18 23:25
 */
@Data
@Entity
public class ProductCategory {

    @Id
    // 自增
    @GeneratedValue
    private Integer categoryId;
    private String categoryName;
    private Integer categoryType;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
