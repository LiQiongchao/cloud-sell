package com.chaox.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @FeignClient 的name是服务提供的instant名
 * @Author: LiQiongchao
 * @Date: 2019/6/30 21:47
 */
@FeignClient(name = "sell-product")
public interface ProductMsgClient {

    /**
     * mapping是接口的URI
     * @return
     */
    @GetMapping("/msg")
    String getMsg();

}
