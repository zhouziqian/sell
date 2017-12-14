package com.zhouqi.service.impl;

import com.zhouqi.dataobject.ProductInfo;
import com.zhouqi.dto.CartDTO;
import com.zhouqi.enums.ProductStatusEnum;
import com.zhouqi.enums.ResultEnum;
import com.zhouqi.exception.SellException;
import com.zhouqi.repository.ProductInfoRespository;
import com.zhouqi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author zhouqi on 2017/12/1.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRespository respository;
    @Override
    public ProductInfo findOne(String productId) {
        return respository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return respository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return respository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return respository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO:cartDTOList){
            ProductInfo productInfo = respository.findOne(cartDTO.getProductId());
            if(productInfo==null){
                throw new SellException(ResultEnum.PRODUCTNOTEXIST);
            }
            Integer result = productInfo.getProductStock()+cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            respository.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO : cartDTOList){
            ProductInfo productInfo= respository.findOne(cartDTO.getProductId());
            if(productInfo==null){
                throw new SellException(ResultEnum.PRODUCTNOTEXIST);
            }
            Integer result = productInfo.getProductStock()-cartDTO.getProductQuantity();
            if(result<0){
                throw new SellException(ResultEnum.PRODUCTSTOCKERROR);
            }
            productInfo.setProductStock(result);
            respository.save(productInfo);
        }
    }

    @Override
    public ProductInfo onSale(String productId) {
        ProductInfo productInfo=respository.findOne(productId);
        if(productInfo==null){
            throw new SellException(ResultEnum.PRODUCTNOTEXIST);
        }
        if(productInfo.getProductStatusEnum()==ProductStatusEnum.UP){
            throw new SellException(ResultEnum.PRODUCTSTATUSERROR);
        }
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        return respository.save(productInfo);
    }

    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo=respository.findOne(productId);
        if(productInfo==null){
            throw new SellException(ResultEnum.PRODUCTNOTEXIST);
        }
        if(productInfo.getProductStatusEnum()==ProductStatusEnum.DOWN){
            throw new SellException(ResultEnum.PRODUCTSTATUSERROR);
        }
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        return respository.save(productInfo);
    }
}
