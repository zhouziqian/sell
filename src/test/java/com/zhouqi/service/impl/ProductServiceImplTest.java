package com.zhouqi.service.impl;

import com.zhouqi.dataobject.ProductInfo;
import com.zhouqi.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zhouqi on 2017/12/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;
    @Test
    public void findOne() throws Exception {
        ProductInfo productInfo = productService.findOne("123456");
        Assert.assertEquals("123456",productInfo.getProductId());
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    public void findAll() throws Exception {
        PageRequest request=new PageRequest(0,10);
        Page<ProductInfo> productInfoPage=productService.findAll(request);
        Assert.assertNotEquals(0,productInfoPage.getTotalPages());
    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("羊肉串");
        productInfo.setProductPrice(new BigDecimal(15));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("孜然味");
        productInfo.setProductIcon("http://xxxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);
        ProductInfo result=productService.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void onSale(){
        ProductInfo result = productService.onSale("123456");
        Assert.assertTrue("上架商品",ProductStatusEnum.UP.getCode().equals(result.getProductStatus()));
    }

    @Test
    public void offSale(){
        ProductInfo result = productService.offSale("123456");
        Assert.assertTrue("下架商品",ProductStatusEnum.DOWN.getCode().equals(result.getProductStatus()));
    }
}