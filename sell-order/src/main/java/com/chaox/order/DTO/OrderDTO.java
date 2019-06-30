package com.chaox.order.DTO;

import com.chaox.order.model.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/30 10:39
 */
@Data
public class OrderDTO {

    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    private Integer orderStatus;
    private Integer payStatus;

    private List<OrderDetail> orderDetails;

}
