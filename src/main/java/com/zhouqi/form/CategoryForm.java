package com.zhouqi.form;

import lombok.Data;

/**
 * @author zhouqi on 2017/12/7.
 */
@Data
public class CategoryForm {
    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号 */
    private Integer categoryType;
}
