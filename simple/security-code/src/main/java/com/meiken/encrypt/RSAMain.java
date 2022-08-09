package com.meiken.encrypt;

import com.meiken.sync.message.digest.Base64Main;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @Author glf
 * @Date 2022/1/23
 */
public class RSAMain {

    private static final String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKsHEqge3u2ehEKBPQ0ze75sQNU2AcyMRGOmnLxyG+6Trn7W0hOJkBEfSpy4BzgvDyFDuyhkK4rwuIETCFhHE+MCAwEAAQ==";
    private static final String privateKey = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAqwcSqB7e7Z6EQoE9DTN7vmxA1TYBzIxEY6acvHIb7pOuftbSE4mQER9KnLgHOC8PIUO7KGQrivC4gRMIWEcT4wIDAQABAkBQ9247rTG4qJzQp0Jx53ejtLgUuBat8ZHG42+8PwE+NmHgUmLXq26Z8lv8nefbjP6wILZKmMQUoCfesq+E0nHhAiEA2GGfYtca4Hi1jo3WVNj+Hu82114TPYFSvfXJjfK70xkCIQDKV5l3Cosu4fSvNheKMXkI6BvJtLS2rWq37w4mjXaaWwIgX5OfZ3VENeqbp4AXMBs5BEj9nFu9e+lntuieQsj5FeECID5jWicxMg8HjnlDlWh/rpEHeCHuPNYijEggRl2uuoYHAiEAqVdqa7MHN2whih1xNGZOUDWFjRLQcU2WVsVYZVewJK8=";

    public static void main(String[] args) throws Exception {
//        KeyPair keyPair = getKeyPair();
//        System.out.println(getPublicKey(keyPair));
//        System.out.println(getPrivateKey(keyPair));
        String content = "Hello World";

        PublicKey publicKey = string2PublicKey(RSAMain.publicKey);
        PrivateKey privateKey = string2PrivateKey(RSAMain.privateKey);

        byte[] encryptBytes = publicEncrypt(content.getBytes(), publicKey);
        byte[] decryptBytes = privateDecrypt(encryptBytes, privateKey);

        System.out.println(new String(decryptBytes));

    }


    public static KeyPair getKeyPair() throws Exception{
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(512);

        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        return keyPair;
    }

    public static String getPublicKey(KeyPair keyPair){
        PublicKey publicKey = keyPair.getPublic();
        byte[] encoded = publicKey.getEncoded();
        return Base64Main.bytes2Base64(encoded);
    }

    public static String getPrivateKey(KeyPair keyPair){
        PrivateKey privateKey = keyPair.getPrivate();
        byte[] encoded = privateKey.getEncoded();
        return Base64Main.bytes2Base64(encoded);
    }

    public static PublicKey string2PublicKey(String publicStr)throws Exception{
        byte[] keyBytes = Base64Main.base64ToBytes(publicStr);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }


    public static PrivateKey string2PrivateKey(String privateStr) throws Exception{
        byte[] keyBytes = Base64Main.base64ToBytes(privateStr);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }


    public static byte[] publicEncrypt(byte[] content, PublicKey publicKey)throws Exception{
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);

        byte[] bytes = cipher.doFinal(content);
        return bytes;
    }

    public static byte[] privateDecrypt(byte[] content, PrivateKey privateKey) throws Exception{
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte[] bytes = cipher.doFinal(content);
        return bytes;
    }

}
