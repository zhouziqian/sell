package com.zhouqi.utils;

import java.util.Random;

/**
 * @author zhouqi on 2017/12/4.
 */
public class KeyUtil {
    /**
     * 生成唯一字符类型主键
     * 格式: 时间+随机数
     * @return String
     */
    public static synchronized String genUniqueKey(){
        Random random=new Random();

        Integer num = random.nextInt(90000)+10000;

        return System.currentTimeMillis()+String.valueOf(num);
    }
}
