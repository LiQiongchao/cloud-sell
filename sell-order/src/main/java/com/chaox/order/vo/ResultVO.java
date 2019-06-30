package com.chaox.order.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/30 17:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO<T> {

    private Integer code;
    private String msg;
    private T data;


}
