package com.chaox.order.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/30 11:05
 */
@Data
public class OrderForm {

    @NotEmpty(message = "姓名不能为空")
    private String name;
    @NotEmpty(message = "手机号必填")
    private String phone;
    @NotEmpty(message = "地址必填")
    private String address;
    @NotEmpty(message = "openid必填")
    private String openid;
    @NotEmpty(message = "购物车不能为空")
    private String items;

}
