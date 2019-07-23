package com.chaox.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 用以接收MQ的消息
 * @Author: LiQiongchao
 * @Date: 2019/7/21 10:55
 */
@Slf4j
@Component
public class MessageReceive {

    /**
     * 监听名为myQueue的队列
     * 1- @RabbitListener(queues = "myQueue") 需要手动去创建列队，否则启动报错
     * 2- @RabbitListener(queuesToDeclare = @Queue("myQueue"))  队列不存在时，会自动去创建队列
     * 3-     @RabbitListener(bindings = @QueueBinding(
     *             exchange = @Exchange("myExchange"),
     *             value = @Queue("myQueue")
     *        ))    把队列与exchange绑定上，队列与exchange会自动创建。
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myExchange"),
            value = @Queue("myQueue")
    ))
    private void customMessage(String message) {
        log.info("[message receive] message:{}", message);
    }

    /**
     * 定义一个electronicQueue的队列，routingKey为electronic并绑定到myOrder的Exchange上，并监听消费electronicQueue的消息。
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "electronic",
            value = @Queue("electronicQueue")
    ))
    private void customElectronicMessage(String message) {
        log.info("[electronic receive] message:{}", message);
    }

    /**
     * 定义一个fuitQueue的队列，routingKey为fruit并绑定到myOrder的Exchange上，并监听消费fruitQueue的消息。
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "fruit",
            value = @Queue("fruitQueue")
    ))
    private void customfruitMessage(String message) {
        log.info("[fruit receive] message:{}", message);
    }

}
