package com.chaox.order.utils;

import java.util.Random;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/30 10:57
 */
public class KeyUtil {

    public static synchronized String genUniqueKey() {
        int radom = new Random().nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(radom);
    }


}
