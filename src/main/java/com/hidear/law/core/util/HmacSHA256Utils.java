package com.hidear.law.core.util;

import org.apache.shiro.codec.Hex;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Map;
import java.util.List;

/**
 * Created by Administrator on 2017/8/25.
 */
public class HmacSHA256Utils {
    public static String digest(String key, String content) {

        try {

            Mac mac = Mac.getInstance("HmacSHA256");
            byte[] secretByte = key.getBytes("utf-8");
            byte[] dataBytes = content.getBytes("utf-8");
            SecretKey secret = new SecretKeySpec(secretByte, "HMACSHA256");
            mac.init(secret);

            byte[] doFinal = mac.doFinal(dataBytes);
            char[] hexB = (new Hex()).encode(doFinal);

            return new String(hexB);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    @SuppressWarnings("unchecked")

    public static String digest(String key, Map<String, ?> map) {
        StringBuilder s = new StringBuilder();
        for(Object values : map.values()) {
            if(values instanceof String[]) {
                for(String value : (String[])values) {
                    s.append(value);
                }
            } else if(values instanceof List) {
                for(String value : (List<String>)values) {
                    s.append(value);
                }
            } else {
                s.append(values);
            }
        }
        return digest(key, s.toString());
    }
}
