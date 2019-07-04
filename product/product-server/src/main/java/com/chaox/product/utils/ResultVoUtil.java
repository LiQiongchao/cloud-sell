package com.chaox.product.utils;


import com.chaox.product.vo.ResultVo;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/25 0:06
 */
public class ResultVoUtil {


    public static <T> ResultVo<T> success(T t) {
        ResultVo<T> resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("success");
        resultVo.setData(t);
        return resultVo;
    }

}
