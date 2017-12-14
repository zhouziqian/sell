package com.zhouqi.service.impl;

import com.zhouqi.dataobject.OrderDetail;
import com.zhouqi.dto.OrderDTO;
import com.zhouqi.enums.OrderStatusEnum;
import com.zhouqi.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zhouqi on 2017/12/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {
    private  final  String OPENID = "007";
    private final String ORDERID="151237877124445393";
    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("倪康");
        orderDTO.setBuyerAddress("东西湖");
        orderDTO.setBuyerPhone("13322222222");
        orderDTO.setBuyerOpenid(OPENID);
        //购物车
        List<OrderDetail> orderDetailList =new ArrayList<>();
        OrderDetail o1=new OrderDetail();
        o1.setProductId("123456");
        o1.setProductQuantity(1);
        OrderDetail o2=new OrderDetail();
        o2.setProductId("123457");
        o2.setProductQuantity(3);
        orderDetailList.add(o1);
        orderDetailList.add(o2);
        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        log.info("[创建订单] result ={}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() throws Exception {
        OrderDTO result=orderService.findOne(ORDERID);
        log.info("[查询单个订单] result={}",result);
        Assert.assertNotNull(result);

    }

    @Test
    public void findList() throws Exception {
        PageRequest request=new PageRequest(0,10);
        Page<OrderDTO> orderDTOPage=orderService.findList(OPENID,request);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() throws Exception {
        OrderDTO orderDTO=orderService.findOne(ORDERID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());
    }

    @Test
    public void finish() throws Exception {
        OrderDTO orderDTO=orderService.findOne(ORDERID);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());
    }


    @Test
    public void paid() throws Exception {
        OrderDTO orderDTO=orderService.findOne(ORDERID);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());

    }

    @Test
    public void list(){
        PageRequest request=new PageRequest(0,10);
        Page<OrderDTO> orderDTOPage=orderService.findList(request);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

}