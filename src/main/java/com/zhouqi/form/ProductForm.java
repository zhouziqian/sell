package com.zhouqi.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zhouqi on 2017/12/7.
 */
@Data
public class ProductForm {
    private String productId;
    /** 商品名称 */
    private String productName;
    /** 商品价格 */
    private BigDecimal productPrice;
    /** 商品库存 */
    private Integer productStock;
    /** 商品描述 */
    private String productDescription;
    /** 商品图片地址 */
    private String productIcon;
    /** 商品类目编号 */
    private Integer categoryType;
}
