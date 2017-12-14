package com.zhouqi.dataobject;

import com.zhouqi.enums.OrderStatusEnum;
import com.zhouqi.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author zhouqi on 2017/12/4.
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    @Id
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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    /** 支付状态 */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
    /** 订单创建时间 */
    private Date createTime;
    /** 订单更新时间 */
    private Date updateTime;
}
