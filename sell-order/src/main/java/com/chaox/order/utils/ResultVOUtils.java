package com.chaox.order.utils;

import com.chaox.order.vo.ResultVO;

/**
 * @Author: LiQiongchao
 * @Date: 2019/6/30 17:46
 */
public class ResultVOUtils {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }

}
