package com.chaox.order.service.impl;

import com.chaox.client.ProductClient;
import com.chaox.common.DecreaseStockInput;
import com.chaox.common.ProductInfoOutput;
import com.chaox.order.DTO.OrderDTO;
import com.chaox.order.enums.OrderStatusEnum;
import com.chaox.order.enums.PayStatusEnum;
import com.chaox.order.model.OrderDetail;
import com.chaox.order.model.OrderMaster;
import com.chaox.order.repository.OrderDetailRepository;
import com.chaox.order.repository.OrderMasterRepository;
import com.chaox.order.service.OrderService;
import com.chaox.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
    @Autowired
    private ProductClient productClient;


    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        String orderId = KeyUtil.genUniqueKey();
        // 查询订单
        List<String> ids = orderDTO.getOrderDetails().stream().map(o -> o.getProductId()).collect(Collectors.toList());
        List<ProductInfoOutput> list = productClient.listForOrder(ids);
        Map<String, ProductInfoOutput> productMap = list.stream().collect(Collectors.toMap(ProductInfoOutput::getProductId, Function.identity(), (key1, key2) -> key2));
        //  计算总价
        BigDecimal price = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail detail : orderDTO.getOrderDetails()) {
            ProductInfoOutput info = productMap.get(detail.getProductId());
            if (info != null) {
                price = info.getProductPrice().multiply(new BigDecimal(detail.getProductQuantity())).add(price);
                BeanUtils.copyProperties(info, detail);
                detail.setOrderId(orderId);
                detail.setDetailId(KeyUtil.genUniqueKey());
                orderDetailRepository.save(detail);
            }

        }
        // 扣库存
        List<DecreaseStockInput> stock = orderDTO.getOrderDetails().stream()
                .map(o -> new DecreaseStockInput(o.getProductId(), o.getProductQuantity())).collect(Collectors.toList());
        productClient.decreaseStock(stock);

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
