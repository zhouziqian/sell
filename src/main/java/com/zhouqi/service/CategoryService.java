package com.zhouqi.service;

import com.zhouqi.dataobject.ProductCategory;

import java.util.List;
/**
 * @author zhouqi on 2017/12/1.
 */
public interface CategoryService {
    /**
     *  按id查询类目
     * @param categoryId
     * @return ProductCategory
     */
    ProductCategory findOne(Integer categoryId);

    /**
     *  查询所有类目
     * @return List<ProductCategory>
     */
    List<ProductCategory> findAll();

    /**
     *  按商品类目type查询类目
     * @param categoryTypeList
     * @return List<ProductCategory>
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     *  添加或更新商品类目
     * @param productCategory
     * @return ProductCategory
     */
    ProductCategory save(ProductCategory productCategory);
}
