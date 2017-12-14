package com.zhouqi.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhouqi.dataobject.OrderDetail;
import com.zhouqi.dto.OrderDTO;
import com.zhouqi.enums.ResultEnum;
import com.zhouqi.exception.SellException;
import com.zhouqi.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouqi on 2017/12/5.
 */
@Slf4j
public class OrderForm2OrderDTO {
    public static OrderDTO convert(OrderForm orderForm){
        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList= gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        }catch (Exception e){
            log.error("[对象转换] 错误, string={}",orderForm.getItems());
            throw new SellException(ResultEnum.PARAMERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return  orderDTO;
    }
}
