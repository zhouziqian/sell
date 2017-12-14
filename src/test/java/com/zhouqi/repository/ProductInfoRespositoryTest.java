package com.zhouqi.repository;

import com.zhouqi.dataobject.ProductInfo;
import com.zhouqi.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zhouqi on 2017/12/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRespositoryTest {
    @Autowired
    private ProductInfoRespository repository;
    @Test
    public void save(){
        ProductInfo productInfo =new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("鱼香肉丝");
        productInfo.setProductPrice(new BigDecimal(15));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("鱼香味");
        productInfo.setProductIcon("http://xxxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);
        ProductInfo result=repository.save(productInfo);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> productInfoList = repository.findByProductStatus(ProductStatusEnum.UP.getCode());
        Assert.assertNotEquals(0,productInfoList.size());
    }

}