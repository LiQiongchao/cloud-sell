package com.chaox.order.controller;

import com.chaox.order.message.StreamClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author: LiQiongchao
 * @Date: 2019/7/21 11:00
 */
@Slf4j
@RestController
public class MessageController {

    @Autowired
    AmqpTemplate amqpTemplate;

    @Autowired
    StreamClient streamClient;

    @GetMapping("send-stream")
    public String sendStream() {
        String message = "now: " + new Date();
        boolean send = streamClient.output().send(MessageBuilder.withPayload(message).build());
        return "send message: " + message + " isSend: " + send;
    }


    /**
     * 发送到myQueue队列
     * @return
     */
    @GetMapping("/send-message")
    public String sendMessage() {
        String message = "now: " + new Date();
        amqpTemplate.convertAndSend("myQueue",message);
        return message;
    }

    /**
     * 发送到myOrder的Exchange并指定routingKye=electronic
     * @return
     */
    @GetMapping("/send-electronic")
    public String sendElectMessage() {
        String message = "now: " + new Date();
        amqpTemplate.convertAndSend("myOrder","electronic",message);
        return message;
    }

    /**
     * 发送到myOrder的Exchange并指定routingKye=fruit
     * @return
     */
    @GetMapping("/send-fruit")
    public String sendFruitMessage() {
        String message = "now: " + new Date();
        amqpTemplate.convertAndSend("myOrder","fruit",message);
        return message;
    }

}
