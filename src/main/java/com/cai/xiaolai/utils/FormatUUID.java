package com.cai.xiaolai.utils;
import java.util.UUID;

public class FormatUUID {

    public static String getUUID(String pre,int len){
        UUID uuid = UUID.randomUUID();
        String[] split = uuid.toString().split("-");
        StringBuffer sb = new StringBuffer("");
        for(String str : split){
            sb.append(str);
        }
        return pre+sb.substring(0,len);
    }
}
