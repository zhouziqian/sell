package com.zhouqi.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author zhouqi on 2017/12/7.
 */
@Data
@Entity
public class SellerInfo {
    @Id
    private String sellerId;

    private String username;
    private String password;
    private String openid;
}
