package com.zhouqi.utils;


/**
 * @author zhouqi on 2017/12/6.
 */
public class MathUtil {
    private static final  Double MOENY_RANGE=0.01;
    public static Boolean equals(Double d1,Double d2){
        Double result = Math.abs(d1-d2);
        if (result<MOENY_RANGE){
            return true;
        }else{
            return false;
        }
    }
}
