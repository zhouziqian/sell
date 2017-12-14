package com.zhouqi.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author zhouqi on 2017/12/4.
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO<T> {
    /** 错误码*/
    private Integer code;
    /** 提示信息*/
    private String msg;
    /** 具体内容*/
    private T data;
}
