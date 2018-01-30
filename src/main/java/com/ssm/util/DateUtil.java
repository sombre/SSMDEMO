package com.ssm.util;

import java.util.Date;

public class DateUtil {



    /**
     * @return Long 返回系统当前时间戳
     */
    public static long getCurrentTimeLong(){
        return new Date().getTime();
    }


    /**
     * @return Date
     */
    public static  Date getCurrentDate(){
        return new Date();
    }


}


