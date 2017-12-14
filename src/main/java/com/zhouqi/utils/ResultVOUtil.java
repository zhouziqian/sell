package com.zhouqi.utils;

import com.zhouqi.vo.ResultVO;

/**
 * @author zhouqi on 2017/12/4.
 */
public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("ok");
        return resultVO;
    }
    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(-1);
        resultVO.setMsg("error");
        return  resultVO;
    }
}
