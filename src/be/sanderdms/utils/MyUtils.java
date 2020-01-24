package be.sanderdms.utils;

import java.nio.charset.StandardCharsets;

public class MyUtils {

    /**
     * A helper method to capitalize strings. (Make first character uppercase)
     * 
     * @param str The String that needs to be capitalized
     * @return The String capitalized
     */
    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    /**
     * A helper method that converts any String input to UTF-8 character set.
     * 
     * @param str The String that needs to be converted to UTF-8
     * @return The String UTF-8 encoded
     */
    public static String encodeUTF8String(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        str = new String(bytes, StandardCharsets.UTF_8);
        return str;
    }

}
