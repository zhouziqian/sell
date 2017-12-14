package com.zhouqi.service.impl;

import com.zhouqi.dto.OrderDTO;
import com.zhouqi.service.OrderService;
import com.zhouqi.service.PushMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author zhouqi on 2017/12/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImpTest {
    @Autowired
    private PushMessageService pushMessageService;

    @Autowired
    private OrderService orderService;
    @Test
    public void orderStatus() throws Exception {
        OrderDTO orderDTO = orderService.findOne("123557");
        pushMessageService.orderStatus(orderDTO);
    }

}