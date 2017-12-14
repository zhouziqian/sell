package com.zhouqi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Component;

/**
 * @author zhouqi on 2017/12/5.
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {
    private String mpAppId;
    private String mpAppSecret;
    private String openAppId;
    private String openAppSecret;
    private String mchId;
    private String mchKey;
    private String keyPath;
    private String notifyUrl;
}
