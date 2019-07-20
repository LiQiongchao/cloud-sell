package com.chaox.order.repository.other;

import org.junit.Test;

/**
 * @Author: LiQiongchao
 * @Date: 2019/7/20 16:15
 */
public class UtilsTest {

    @Test
    public void containTest() {
        String a = "0,5";
        for (int i = 10; i < 20; i++) {
            System.out.println("i=" + i + "-->" + a.contains(i%10 + ""));
        }
    }

    @Test
    public void integerTest() {
        System.out.println(Integer.MIN_VALUE);
    }


}
