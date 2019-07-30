package com.chaox.order;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
@SpringCloudAplication与使用下面三个注释是一样的。

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
*/
@SpringCloudApplication
@EnableFeignClients(basePackages = {"com.chaox.client", "com.chaox.order.client"})
@EnableHystrixDashboard
public class OrderServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServerApplication.class, args);
    }

}
