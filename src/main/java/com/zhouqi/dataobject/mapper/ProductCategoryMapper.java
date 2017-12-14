package com.zhouqi.dataobject.mapper;

import org.apache.ibatis.annotations.Insert;

import java.util.Map;

/**
 * @author zhouqi on 2017/12/8.
 */
public interface ProductCategoryMapper {
    @Insert("insert into product_category(category_name , category_type) values(#{category_name,jdbcType=VARCHAR},#{category_type,jdbcType=INTEGER})")
    int insertByMap(Map<String,Object> map);
}
