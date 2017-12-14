package com.zhouqi.enums;

import lombok.Getter;

/**
 * @author zhouqi on 2017/12/4.
 */
@Getter
public enum ResultEnum {
    /**
     * 成功
     */
    SUCCESS(0,"成功"),
    /**
     * 商品不存在
     */
    PRODUCTNOTEXIST(10,"商品不存在"),
    /**
     * 库存不正常
     */
    PRODUCTSTOCKERROR(11,"库存不正常"),
    /**
     * 订单不存在
     */
    ORDERNOTEXIST(12,"订单不存在"),
    /**
     * 订单详情不存在
     */
    ORDERDETAILNOTEXIST(13,"订单详情不存在"),
    /**
     * 订单状态不正确
     */
    ORDERSTATUSERROR(14,"订单状态不正确"),
    /**
     * 订单更新失败
     */
    ORDERUPDATEFAIL(15,"订单更新失败"),
    /**
     * 订单详情为空
     */
    ORDERDETAILEMPTY(16,"订单详情为空"),
    /**
     * 订单支付状态不正确
     */
    ORDERPAYSTATUSERROR(17,"订单支付状态不正确"),
    /**
     * 参数不正确
     */
    PARAMERROR(1,"参数不正确"),
    /**
     * 购物车不能为空
     */
    CARTEMPTY(18,"购物车不能为空"),
    /**
     * 微信账号方面错误
     */
    WXMPERROR(20,"微信账号方面错误"),
    /**
     * 微信支付异步通知金额校验不通过
     */
    WXPAYNOTIFYMONEYVERIFYERROR(21,"微信支付异步通知金额校验不通过"),
    /**
     * 商品状态不正确
     */
    PRODUCTSTATUSERROR(22,"商品状态不正确"),
    /**
     * 登录失败
     */
    LOGINFAIL(23,"登录失败"),
    /**
     * 登出成功
     */
    LOGOUTSUCCESS(24,"登出成功");
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
