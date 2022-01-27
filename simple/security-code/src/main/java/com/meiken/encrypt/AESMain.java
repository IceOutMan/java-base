package com.meiken.encrypt;

import com.meiken.message.digest.Base64Main;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @Author glf
 * @Date 2022/1/23
 */
public class AESMain {

    private static final  String base64Key = "aBzWQ8rvDu05jHVgkT/4UQ==";
    public static void main(String[] args) throws Exception {
//        System.out.println(getKeyAES());

        String content = "Hello World";
        SecretKey secretKey = loadKeyAES(base64Key);

        byte[] encryptBytes = encryptAES(content.getBytes(), secretKey);

        byte[] decryptBytes = decryptAES(encryptBytes, secretKey);
        System.out.println(new String(decryptBytes));
    }

    /**
     * 更具密钥生成器生成密钥  , AES 支持 128、192、256
     * 使用 192 和 256 长度的密钥需要下载无政策和司法限制的文件
     * @return  返回密钥的 base64
     * @throws Exception
     */
    public static String getKeyAES() throws Exception{
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);

        SecretKey key = keyGen.generateKey();
        String base64Str = Base64Main.bytes2Base64(key.getEncoded());

        return base64Str;
    }

    // 通过密钥的 base64 构造 密钥对象
    public static SecretKey loadKeyAES(String base64Key) throws Exception{
        byte[] bytes = Base64Main.base64ToBytes(base64Key);
        SecretKey key = new SecretKeySpec(bytes, "AES");
        return key;
    }

    public static byte[] encryptAES(byte[] source, SecretKey key) throws Exception{
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] bytes = cipher.doFinal(source);
        return bytes;
    }

    public static byte[] decryptAES(byte[] source ,SecretKey key) throws Exception{
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE,key);

        byte[] bytes = cipher.doFinal(source);
        return bytes;
    }


}
