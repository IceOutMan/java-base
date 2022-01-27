package com.meiken.message.digest;


import java.util.Base64;

/**
 * @Author glf
 * @Date 2022/1/23
 */
public class Base64Main {
    public static void main(String[] args) throws Exception {
        String sourceContent = "HelloWorld";
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] base64Content = encoder.encode(sourceContent.getBytes("utf8"));
        System.out.println(new String(base64Content));
    }

    public static String bytes2Base64(byte[] bytes){
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] base64Content = encoder.encode(bytes);
        return new String(new String(base64Content));
    }

    public static byte[] base64ToBytes(String base64Str){
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] base64Bytes = decoder.decode(base64Str);
        return base64Bytes;
    }
}
