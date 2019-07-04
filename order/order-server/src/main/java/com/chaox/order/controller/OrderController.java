package com.chaox.order.controller;

import com.chaox.order.DTO.OrderDTO;
import com.chaox.order.converter.OrderForm2OrderDTOConverter;
import com.chaox.order.enums.ResultEnum;
import com.chaox.order.exception.OrderException;
import com.chaox.order.form.OrderForm;
import com.chaox.order.service.OrderService;
import com.chaox.order.utils.ResultVOUtils;
import com.chaox.order.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/30 10:34
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResultVO createOrder(@Valid OrderForm orderForm,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确，orderForm={}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetails())) {
            log.error("【创建订单】购物车为空， orderForm={}", orderForm);
            throw new OrderException(ResultEnum.CART_EMPTY);
        }
        OrderDTO order = orderService.createOrder(orderDTO);
        Map<String, String> map = new HashMap();
        map.put("orderId", order.getOrderId());
        return ResultVOUtils.success(map);
    }


}
