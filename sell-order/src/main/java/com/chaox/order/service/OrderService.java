package com.chaox.order.service;

import com.chaox.order.DTO.OrderDTO;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/30 10:37
 */
public interface OrderService {


    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO createOrder(OrderDTO orderDTO);


}
