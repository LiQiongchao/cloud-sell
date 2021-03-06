package com.chaox.order.controller;

import com.chaox.order.client.ProductMsgClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 测试类
 * @Author: LiQiongchao
 * @Date: 2019/6/30 18:21
 */
@Deprecated
@Slf4j
@RestController
@RefreshScope
public class ClientController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ProductMsgClient productMsgClient;

    @Value("${env}")
    private String env;

    @GetMapping("/feignMsg")
    public String getFeignMsg() {
        String msg = productMsgClient.getMsg();
        return msg;
    }

    @GetMapping("/env")
    public String printEnv() {
        return env;
    }

    @GetMapping("getProductMsg")
    public String getProductMsg() {
        /*
        第一种方式(直接使用RestTemplate, rul写死)
        ip不够动态
         */
        RestTemplate template = new RestTemplate();
        String result = template.getForObject("http://localhost:8080/msg", String.class);
        log.info("first response = {}", result);

        // 第二种方式(使用LoadBalancerClient来动态获取Host与port,再使用RestTemplate调用)
        ServiceInstance instance = loadBalancerClient.choose("SELL-PRODUCT");
        String url = String.format("http://%s:%s", instance.getHost(), instance.getPort() + "/msg");
        String result2 = template.getForObject(url, String.class);
        log.info("second response = {}", result2);

        // 第三种方式
        String result3 = restTemplate.getForObject("http://SELL-PRODUCT/msg", String.class);
        log.info("third response = {}", result3);
        return result3;
    }
}
