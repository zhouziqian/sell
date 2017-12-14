package com.zhouqi.enums;

import lombok.Getter;

/**
 * @author zhouqi on 2017/12/4.
 */
@Getter
public enum PayStatusEnum implements CodeEnum{
    /**
     * 等待支付
     */
    WAIT(0,"等待支付"),
    /**
     * 支付成功
     */
    SUCCESS(1,"支付成功");

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;
}
