package com.zhouqi.exception;

import com.zhouqi.enums.ResultEnum;
import lombok.Getter;

/**
 * @author zhouqi on 2017/12/4.
 */
@Getter
public class SellException extends RuntimeException{
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
    public SellException(Integer code , String message){
        super(message);
        this.code = code;

    }
}
