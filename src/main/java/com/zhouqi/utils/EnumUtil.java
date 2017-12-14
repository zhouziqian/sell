package com.zhouqi.utils;

import com.zhouqi.enums.CodeEnum;

/**
 * @author zhouqi on 2017/12/6.
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for(T each: enumClass.getEnumConstants()){
            if(code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
