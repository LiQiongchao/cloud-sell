package com.chaox.order.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/28 0:02
 */
@Data
public class OrderMaster {

    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    private Integer orderStatus;
    private Integer payStatus;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
