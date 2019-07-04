package com.chaox.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/30 18:18
 */
@RestController
public class ServerController {

    @GetMapping("/msg")
    public String msg() {
        return "This is product's msg 2";
    }

}
