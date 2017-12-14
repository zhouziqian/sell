package com.zhouqi.enums;

import lombok.Getter;

/**
 * @author zhouqi on 2017/12/1.
 */
@Getter
public enum ProductStatusEnum implements CodeEnum{
    /**
     * 商家商品
     */
    UP(0,"上架"),
    /**
     * 下架商品
     */
    DOWN(1,"下架");
    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
