package com.zhouqi.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author zhouqi on 2017/12/5.
 */
@Data
public class OrderForm {
    /**
     * 买家姓名
     */
    @NotEmpty(message="姓名必填")
    private String name;
    /**
     *  买家手机号码
     */
    @NotEmpty(message = "手机号码必填")
    private  String phone;
    /**
     * 买家地址
     */
    @NotEmpty(message = "地址不能为空")
    private String address;
    /**
     * openid
     */
    @NotEmpty(message = "openid不能为空")
    private String openid;
    /**
     * 购物车信息
     */
    @NotEmpty(message = "购物车信息不能为空")
    private String items;

}
