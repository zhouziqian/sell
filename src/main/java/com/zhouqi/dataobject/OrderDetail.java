package com.zhouqi.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author zhouqi on 2017/12/4.
 */
@Entity
@Data
public class OrderDetail {
    @Id
    private String detailId;
    /** 订单id */
    private String orderId;
    /** 商品名称 */
    private String productName;
    /** 商品价格 */
    private BigDecimal productPrice;
    /** 商品数量 */
    private Integer productQuantity;
    /** 商品图片 */
    private String productIcon;
    /** 商品id */
    private String productId;

}
