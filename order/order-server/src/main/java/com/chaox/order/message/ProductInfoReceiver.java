package com.chaox.order.message;

import com.chaox.common.ProductInfoOutput;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: LiQiongchao
 * @Date: 2019/7/22 0:22
 */
@Slf4j
@Component
public class ProductInfoReceiver {


    private static final String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message) {
        //message => ProductInfoOutput
        List<ProductInfoOutput> productInfoOutputList = (List<ProductInfoOutput>)new Gson().fromJson(message,
                new TypeToken<List<ProductInfoOutput>>(){}.getType());
        log.info("从队列【{}】接收到消息：{}", "productInfo", productInfoOutputList);

        //存储到redis中
        for (ProductInfoOutput productInfoOutput : productInfoOutputList) {
            stringRedisTemplate.opsForValue().set(String.format(PRODUCT_STOCK_TEMPLATE, productInfoOutput.getProductId()),
                    String.valueOf(productInfoOutput.getProductStock()));
        }
    }


}
