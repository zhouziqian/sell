package com.zhouqi.repository;

import com.zhouqi.dataobject.OrderDetail;
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
 * @author zhouqi on 2017/12/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1234567810");
        orderDetail.setOrderId("1221111");
        orderDetail.setProductIcon("http://xxxx.jpg");
        orderDetail.setProductId("1111112");
        orderDetail.setProductName("鱼香茄子");
        orderDetail.setProductPrice(new BigDecimal(19.9));
        orderDetail.setProductQuantity(3);
        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByOrOrderId() throws Exception {
        List<OrderDetail> orderDetailList = repository.findByOrOrderId("1221111");
        Assert.assertNotEquals(0,orderDetailList.size());
    }

}