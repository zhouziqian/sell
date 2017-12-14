package com.zhouqi.service.impl;

import com.zhouqi.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CateoryServiceImplTest {

    @Autowired
    private CateoryServiceImpl cateoryService;

    @Test
    public void findOne() {
        ProductCategory productCategory = cateoryService.findOne(2);
        Assert.assertEquals(new Integer(2),productCategory.getCategoryId());
    }

    @Test
    public void findAll(){
        List<ProductCategory> productCategoryList = cateoryService.findAll();
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        List<ProductCategory> productCategories = cateoryService.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,productCategories.size());
    }

    @Test
    public void save(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("3C");
        productCategory.setCategoryType(11);
        cateoryService.save(productCategory);
    }
}