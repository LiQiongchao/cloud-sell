package com.chaox.gateway.exception;

/**
 * @Author: LiQiongchao
 * @Date: 2019/7/25 21:10
 */
public class RateLimitException extends RuntimeException {

    public RateLimitException() {
    }

    public RateLimitException(String message) {
        super(message);
    }
}
