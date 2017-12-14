package com.zhouqi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zhouqi.dataobject.OrderDetail;
import com.zhouqi.enums.CodeEnum;
import com.zhouqi.enums.OrderStatusEnum;
import com.zhouqi.enums.PayStatusEnum;
import com.zhouqi.utils.EnumUtil;
import com.zhouqi.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author zhouqi on 2017/12/4.
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO{
    private String orderId;
    /** 买家姓名 */
    private String buyerName;
    /** 买家手机号 */
    private String buyerPhone;
    /** 买家地址 */
    private String buyerAddress;
    /** 买家openid */
    private String buyerOpenid;
    /** 买家支付金额 */
    private BigDecimal orderAmount;
    /** 订单状态 */
    private Integer orderStatus;
    /** 支付状态 */
    private Integer payStatus;
    /** 订单创建时间 */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    /** 订单更新时间 */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;
    /** 订单详情 */
    List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }
    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }


}
