package com.zhouqi.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zhouqi.enums.ProductStatusEnum;
import com.zhouqi.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhouqi on 2017/12/1.
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {
    @Id
    private String productId;
    /** 商品名称 */
    private String productName;
    /** 商品价格 */
    private BigDecimal productPrice;
    /** 商品库存 */
    private Integer productStock;
    /** 商品描述 */
    private String productDescription;
    /** 商品图片地址 */
    private String productIcon;
    /** 商品状态,0正常1下架 */
    private Integer productStatus = ProductStatusEnum.UP.getCode();
    /** 商品类目编号 */
    private Integer categoryType;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getByCode(productStatus,ProductStatusEnum.class);
    }
}
