package com.chaox.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * input和output不能放在同一个项目，否则会报bean already exist的错，那样也是没有存在的意义的。
 * @Author: LiQiongchao
 * @Date: 2019/7/21 14:56
 */
public interface StreamClient {

    String streamMessage = "streamMessage";
    String streamMessage2 = "streamMessage2";

    @Input(StreamClient.streamMessage)
    SubscribableChannel input();

    @Output(StreamClient.streamMessage2)
    MessageChannel output();

//    @Input(StreamClient.streamMessage2)
//    SubscribableChannel input2();

//    @Output(StreamClient.streamMessage2)
//    MessageChannel output2();

}
