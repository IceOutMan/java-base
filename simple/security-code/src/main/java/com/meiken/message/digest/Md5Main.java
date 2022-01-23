package com.meiken.message.digest;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author glf
 * @Date 2022/1/23
 */
public class Md5Main {
    public static void main(String[] args) throws Exception {
        System.out.println(new BigInteger(-1, new byte[]{1,-1}).toString());

    }

    public static void md5() throws Exception {
        String content = "Hello World";
        MessageDigest md = MessageDigest.getInstance("MD5");

        byte[] result = md.digest(content.getBytes("utf8"));
        String s = new BigInteger(1, result).toString(16);
        System.out.println(s);
    }

}
