package com.chaox.order.converter;

import com.chaox.order.DTO.OrderDTO;
import com.chaox.order.enums.ResultEnum;
import com.chaox.order.exception.OrderException;
import com.chaox.order.form.OrderForm;
import com.chaox.order.model.OrderDetail;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/30 11:20
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        try {
            List<OrderDetail> orderDetails = new Gson().fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
            orderDTO.setOrderDetails(orderDetails);
        } catch (JsonSyntaxException e) {
            log.error("【Json转换】错误，String = {}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }

        return orderDTO;
    }


}
