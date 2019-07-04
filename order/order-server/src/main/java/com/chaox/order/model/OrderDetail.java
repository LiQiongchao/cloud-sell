package com.chaox.order.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/28 0:02
 */
@Data
@Entity
public class OrderDetail {

    @Id
    private String detailId;
    private String orderId;
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productQuantity;
    private String productIcon;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
