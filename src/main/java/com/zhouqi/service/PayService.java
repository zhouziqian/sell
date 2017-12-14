package com.zhouqi.service;

import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import com.zhouqi.dto.OrderDTO;

/**
 * @author zhouqi on 2017/12/5.
 */
public interface PayService {
    /**
     * 创建支付
     * @param orderDTO
     * @return PayResponse
     */
    PayResponse create(OrderDTO orderDTO);

    /**
     * 支付异步回调
     * @param notifyData
     * @return PayResponse
     */
    PayResponse notify(String notifyData);

    RefundResponse refound(OrderDTO orderDTO);
}
