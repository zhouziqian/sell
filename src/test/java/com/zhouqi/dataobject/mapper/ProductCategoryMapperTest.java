package com.zhouqi.dataobject.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author zhouqi on 2017/12/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest {
    @Autowired
    private ProductCategoryMapper mapper;
    @Test
    public void insertByMap() throws Exception {
        Map<String,Object> map =new HashMap();
        map.put("category_name","珠宝");
        map.put("category_type",5);
        int result=mapper.insertByMap(map);
        Assert.assertTrue("mybatis注解测试",1==result);
    }

}