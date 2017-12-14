package com.zhouqi.repository;

import com.zhouqi.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author zhouqi on 2017/12/1.
 */
public interface ProductInfoRespository extends JpaRepository<ProductInfo,String>{
    /**
     * 查询上架商品
     * @param productStatus
     * @return List<ProductInfo>
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
