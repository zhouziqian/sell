package com.zhouqi.service.impl;

import com.zhouqi.dataobject.SellerInfo;
import com.zhouqi.repository.SellerInfoRepository;
import com.zhouqi.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhouqi on 2017/12/7.
 */
@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerInfoRepository repository;
    @Override
    public SellerInfo findSellerInfoByOpenId(String openid) {
        return repository.findByOpenid(openid);
    }
}
