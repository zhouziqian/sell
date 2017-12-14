package com.zhouqi.service.impl;

import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.zhouqi.dto.OrderDTO;
import com.zhouqi.service.OrderService;
import com.zhouqi.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author zhouqi on 2017/12/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {
    @Autowired
    private PayService payService;
    @Autowired
    private OrderService orderService;
    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = orderService.findOne("test");
        payService.create(orderDTO);
    }

    @Test
    public void refund(){
        OrderDTO orderDTO =orderService.findOne("test");
        payService.refound(orderDTO);
    }

}