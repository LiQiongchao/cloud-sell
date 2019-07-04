package com.chaox.product.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回给前端的外层vo
 * @Author: LiQiongchao
 * @Date: 2019/6/21 0:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVo<T> {

    private Integer code;
    private String msg;
    private T data;

}
