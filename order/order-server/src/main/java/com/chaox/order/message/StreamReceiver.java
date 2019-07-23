package com.chaox.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * @Author: LiQiongchao
 * @Date: 2019/7/21 15:00
 */
@Slf4j
@EnableBinding(StreamClient.class)
public class StreamReceiver {

    @StreamListener(StreamClient.streamMessage)
    @SendTo(StreamClient.streamMessage2)
    public String receiverMessage(Object message) {
        log.info("[stream message] receive: {}", message);
        return "received";
    }

    @StreamListener(StreamClient.streamMessage2)
    public void receiverMessage2(String message) {
        log.info("[stream message2] receive: {}", message);
    }



}
