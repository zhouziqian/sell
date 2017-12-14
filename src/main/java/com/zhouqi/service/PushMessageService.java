package com.zhouqi.service;

import com.zhouqi.dto.OrderDTO;

/**
 * @author zhouqi on 2017/12/8.
 */
public interface PushMessageService {
    void orderStatus(OrderDTO orderDTO);
}
