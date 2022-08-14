package priv.jesse.mall.utils;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: hzl
 * @CreateDate: 2022/8/9
 */


public class StringUtil {
    private final static Log log = LogFactory.getLog(StringUtil.class);
    private static MessageDigest digest = null;

    /**
     * 对字符串进行MD5加密
     * @param data
     * @return
     */
    public static String encode(String data) {
        if (digest == null)
            try {
                digest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException nsae) {
                log.error("Failed to load the MD5 MessageDigest."
                        + " We will be unable to function normally.");
                nsae.printStackTrace();
            }
        digest.update(data.getBytes());
        return encodeHex(digest.digest());
    }

    private static String encodeHex(byte bytes[]) {
        StringBuffer buf = new StringBuffer(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            if ((bytes[i] & 0xff) < 16)
                buf.append("0");
            buf.append(Long.toString(bytes[i] & 0xff, 16));
        }
        return buf.toString().toUpperCase();
    }
}

