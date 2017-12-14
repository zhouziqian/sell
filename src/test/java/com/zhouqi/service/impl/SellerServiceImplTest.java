package com.zhouqi.service.impl;

import com.zhouqi.dataobject.SellerInfo;
import com.zhouqi.service.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author zhouqi on 2017/12/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SellerServiceImplTest {
    @Autowired
    private SellerService sellerService;

    /**
     *
     * @throws Exception

    @Test
    public void findSellerInfoByOpenId() throws Exception {
        SellerInfo result = sellerService.findSellerInfoByOpenId("test");
        Assert.assertTrue("测试按openid查找",null!=result);
    }
     */
}