package com.zhouqi.repository;

import com.zhouqi.dataobject.SellerInfo;
import com.zhouqi.utils.KeyUtil;
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
public class SellerInfoRepositoryTest {
    @Autowired
    private SellerInfoRepository repository;
    @Test
    public void save(){
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("zhouqi");
        sellerInfo.setPassword("zhouqi");
        sellerInfo.setOpenid("test");
        SellerInfo result = repository.save(sellerInfo);
        Assert.assertTrue("测试新增卖家信息",result!=null);
    }
    @Test
    public void findByOpenid() throws Exception {
        SellerInfo result = repository.findByOpenid("test");
        Assert.assertTrue("测试按openid查找卖家信息",null!=result);
    }

}