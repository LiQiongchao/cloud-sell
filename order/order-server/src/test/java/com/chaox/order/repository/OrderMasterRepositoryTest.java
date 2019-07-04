package com.chaox.order.repository;

import com.chaox.order.enums.OrderStatusEnum;
import com.chaox.order.enums.PayStatusEnum;
import com.chaox.order.model.OrderMaster;
import com.chaox.sellorder.SellOrderApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/30 10:22
 */
@Component
public class OrderMasterRepositoryTest extends SellOrderApplicationTests {


    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("1886131241241");
        orderMaster.setBuyerAddress("慕课网总部");
        orderMaster.setBuyerOpenid("1101110");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        OrderMaster save = orderMasterRepository.save(orderMaster);
        Assert.assertTrue(save != null);
    }


}