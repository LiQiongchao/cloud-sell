package com.chaox.order.repository;

import com.chaox.order.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/30 10:11
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

}
