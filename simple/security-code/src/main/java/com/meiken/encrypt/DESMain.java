package com.meiken.encrypt;

import com.meiken.sync.message.digest.Base64Main;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @Author glf
 * @Date 2022/1/23
 */
public class DESMain {
    private static  final String base64Key = "EOlMoRO19yw=";
    public static void main(String[] args) throws Exception {
//        System.out.println(getKeyDES());
        SecretKey secretKey = loadKeyDES(base64Key);

        String content = "Hello World";
        byte[] encryptContent = encryptDES(content.getBytes(), secretKey);

        byte[] decryptContent = decryptDES(encryptContent, secretKey);
        System.out.println(new String(decryptContent));

    }


    /**
     * 通过密钥生成器 生成 DES 加密的密钥
     * 每次生成的不一样
     * @return
     * @throws Exception
     */
    public static String getKeyDES() throws Exception{
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        keyGen.init(56);// 设置密钥的长度为56位

        SecretKey secretKey = keyGen.generateKey();
        byte[] encoded = secretKey.getEncoded();

        return Base64Main.bytes2Base64(encoded);
    }

    /**
     * 通过 DES 的密钥， 构造对应的密钥对象
     * @param base64Key
     * @return
     * @throws Exception
     */
    public static SecretKey loadKeyDES(String base64Key) throws  Exception{
        byte[] bytes = Base64Main.base64ToBytes(base64Key);
        SecretKey key = new SecretKeySpec(bytes,"DES");
        return key;
    }

    // DES 加密
    public static byte[] encryptDES(byte[] source ,SecretKey key) throws Exception{
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE,key);

        byte[] bytes = cipher.doFinal(source);
        return bytes;
    }

    // DES 解密
    public static byte[] decryptDES(byte[] source ,SecretKey key) throws Exception{
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] bytes = cipher.doFinal(source);
        return bytes;
    }

}
