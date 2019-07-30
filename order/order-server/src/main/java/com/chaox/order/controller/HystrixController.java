package com.chaox.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: LiQiongchao
 * @Date: 2019/7/28 12:46
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    //

    /**
     * 1- 指定fallback方法名
     *      @HystrixCommand(fallbackMethod = "fallback")
     * 2- 不指定默认fallback方法名为@DefaultProperties中定义的。
     *      @HystrixCommand
     * 3- 设置过期时间为3秒
     *      @HystrixCommand(commandProperties = {
     *         @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
     *      })
     * 4- 断路器模式
     *          @HystrixCommand(commandProperties = {
     *                    //设置熔断
     * 	       		@HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
     *                    //请求数达到后才计算
     * 	       		@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
     *                    //休眠时间窗
     * 	       		@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
     *                    //错误率，百分比，现在设置的是错误超过60%才进行休眠时间计算
     * 	       		@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
     *          })
     * @return
     */

    @HystrixCommand
    @GetMapping("/getProductList")
    public String getProductInfo(@RequestParam Integer type) {
        if (type == 1) {
            return "OK";
        }
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://localhost:8080/product/list", String.class);
        return result;
    }

    public String fallback() {
        return "人太多了，就稍后重试！";
    }

    public String defaultFallback() {
        return "【默认】人太多了，就稍后重试！";
    }

}
