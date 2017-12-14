package com.zhouqi.service;

import com.zhouqi.dataobject.ProductInfo;
import com.zhouqi.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author zhouqi on 2017/12/1.
 */
public interface ProductService {
    /**
     * 通过商品id查询商品
     * @param productId
     * @return ProductInfo
     */
    ProductInfo findOne(String productId);

    /**
     * 查询所有上架商品
     * @return List<ProductInfo>
     */
    List<ProductInfo> findUpAll();

    /**
     * 分页查询所有商品
     * @param pageable
     * @return List<ProductInfo>
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 新增或更新商品
     * @param productInfo
     * @return ProductInfo
     */
    ProductInfo save(ProductInfo productInfo);

    /**
     * 添加库存
     * @param cartDTOList
     */
    void increaseStock(List<CartDTO> cartDTOList);

    /**
     * 减少库存
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);

    ProductInfo onSale(String productId);

    ProductInfo offSale(String productId);
}
