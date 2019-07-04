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
public class OrderMaster {

    @Id
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
