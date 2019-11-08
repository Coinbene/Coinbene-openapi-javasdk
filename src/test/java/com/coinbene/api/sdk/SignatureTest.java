package com.coinbene.api.sdk;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * sign test
 *
 */
public class SignatureTest {

    private static final Logger log = LoggerFactory.getLogger(SignatureTest.class);

    @Test
    public void test() {
        try {
            Assert.assertEquals("5a2f96d2481c301ff8c4072eda6a4d5afd2633dea11be5adfa0e2c52dccb5760",
                    signature("2019-05-25T01:37:56.852Z",
                            "GET",
                            "/api/swap/v2/account/info",
                            "",
                            "9daf13ebd76c4f358fc885ca6ede5e27"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
        try {
            Assert.assertEquals("a02a6428bb44ad338d020c55acee9dd40bbcb3d96cbe3e48dd6185e51e232aa2",
                    sha256_HMAC(
                            "2019-05-25T03:20:30.362ZGET/api/swap/v2/account/info",
                            "9daf13ebd76c4f358fc885ca6ede5e27"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String signature(String timestamp, String method, String requestPath, String body, String secretKey)
            throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        String signStr = null;
        if (StringUtils.isNotEmpty(secretKey)) {
            body = body == null ? "" : body;
            method = method.toUpperCase();
            String preHash = timestamp + method + requestPath + body;
            log.info("\n >>>> preHash: {}", preHash);

            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] bytes = sha256_HMAC.doFinal(preHash.getBytes("UTF-8"));
            signStr = byteArrayToHexString(bytes);
            log.info("\n>>>> signStr : {}", signStr);
        }
        return signStr;
    }

    public static void main(String[] args){
        final String a = "2019-05-25T03:03:23.941ZGET/api/swap/v2/account/info";
        final String b = "9daf13ebd76c4f358fc885ca6ede5e27";
        final String hash = sha256_HMAC(a, b);
        System.out.println(hash);
    }
    /**
     * sha256_HMAC加密
     * @param message 消息
     * @param secret  秘钥
     * @return 加密后字符串
     */
    public static String sha256_HMAC(String message, String secret) {
        String hash = "";
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] bytes = sha256_HMAC.doFinal(message.getBytes("UTF-8"));
            hash = byteArrayToHexString(bytes);
        } catch (Exception e) {
            System.out.println("Error HmacSHA256 ===========" + e.getMessage());
        }
        return hash;
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b!=null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString().toLowerCase();
    }

}

