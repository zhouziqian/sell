package com.zhouqi.repository;

import com.zhouqi.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author zhouqi on 2017/12/4.
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
    /**
     * 通过订单号查订单详情
     * @param orderId
     * @return List<OrderDetail>
     */
    List<OrderDetail> findByOrOrderId(String orderId);
}
