package com.chaox.order.service.impl;

import com.chaox.order.DTO.OrderDTO;
import com.chaox.order.enums.OrderStatusEnum;
import com.chaox.order.enums.PayStatusEnum;
import com.chaox.order.model.OrderMaster;
import com.chaox.order.repository.OrderDetailRepository;
import com.chaox.order.repository.OrderMasterRepository;
import com.chaox.order.service.OrderService;
import com.chaox.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/30 10:47
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        // todo 查询订单
        // todo 计算总价
        // todo 扣库存
        // 存储订单
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(KeyUtil.genUniqueKey());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        OrderMaster save = orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
