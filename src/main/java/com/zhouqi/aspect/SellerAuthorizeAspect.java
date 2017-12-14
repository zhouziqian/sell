package com.zhouqi.aspect;

import com.zhouqi.constant.CookieConstant;
import com.zhouqi.constant.RedisConstant;
import com.zhouqi.exception.SellerAuthorizeException;
import com.zhouqi.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author zhouqi on 2017/12/7.
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Pointcut("execution(public * com.zhouqi.conntroller.Seller*.*(..))" +
    "&& !execution(public * com.zhouqi.conntroller.SellerUserController.*(..))")
    public void verify(){

    }

    /**
     *

    @Before("verify()")
    public void doVerify(){
        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //查询cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if(null==cookie){
            log.warn("[登录校验] Cookie中查不到token");
            throw new SellerAuthorizeException();
        }

        //去redis查询
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
        if(StringUtils.isEmpty(tokenValue)){
            log.warn("[登录校验] redis中查不到token");
            throw new SellerAuthorizeException();
        }
    }
     */
}
