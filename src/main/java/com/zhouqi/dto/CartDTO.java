package com.zhouqi.dto;

import lombok.Data;

/**
 * @author zhouqi on 2017/12/4.
 */
@Data
public class CartDTO {
    /** 商品id */
    private String productId;
    /** 商品数量 */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
