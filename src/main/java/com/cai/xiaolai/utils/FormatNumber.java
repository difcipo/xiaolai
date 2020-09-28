package com.cai.xiaolai.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatNumber {
    public static String format(String pattern,String pre){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return pre+format.format(date);
    }
}
