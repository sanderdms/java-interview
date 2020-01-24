package be.sanderdms.utils;

import java.nio.charset.StandardCharsets;

public class MyUtils {

    public static String capitalize(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String encodeUTF8String(String str){
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        str = new String(bytes, StandardCharsets.UTF_8);
        return str;
    }

}
