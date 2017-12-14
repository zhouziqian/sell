package com.zhouqi.enums;

import lombok.Getter;

/**
 * @author zhouqi on 2017/12/4.
 */
@Getter
public enum OrderStatusEnum implements CodeEnum{
    /**
     * 新订单
     */
    NEW(0,"新订单"),
    /**
     * 完成订单
     */
    FINISHED(1,"完成"),
    /**
     * 订单已取消
     */
    CANCEL(2,"已取消");

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    private Integer code;
    private String message;

}
