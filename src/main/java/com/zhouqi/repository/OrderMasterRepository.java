package com.zhouqi.repository;

import com.zhouqi.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author zhouqi on 2017/12/4.
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String>{
    /**
     *  通过买家openid分页查询
     * @param buyerOpenid
     * @param pageable
     * @return Page<OrderMaster>
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);

}
