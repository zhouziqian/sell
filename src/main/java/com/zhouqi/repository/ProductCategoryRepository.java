package com.zhouqi.repository;

import com.zhouqi.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * @author zhouqi on 2017/12/1.
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>{
    /**
     *  按商品类目类型查询类目
     * @param categoryTypeList
     * @return List<ProductCategory>
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
