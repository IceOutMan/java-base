package com.meiken.message.digest;

import java.security.MessageDigest;

/**
 * @Author glf
 * @Date 2022/1/23
 */
public class SHAMain {
    public static void main(String[] args) throws Exception {
        String content = "Hello World";
        MessageDigest md = MessageDigest.getInstance("SHA-1");

        byte[] result = md.digest(content.getBytes("utf8"));
        System.out.println(new String(result));
    }
}
