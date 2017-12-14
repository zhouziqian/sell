package com.zhouqi.service;

import com.zhouqi.dataobject.SellerInfo;

/**
 * @author zhouqi on 2017/12/7.
 */
public interface SellerService {
    SellerInfo findSellerInfoByOpenId(String openid);
}
