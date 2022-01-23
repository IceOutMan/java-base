package com.meiken.biginteger;

import java.math.BigInteger;

/**
 * @Author glf
 * @Date 2022/1/23
 */
public class BigIntterMain {
    public static void main(String[] args) {

        BigInteger_Bytes_Test();
        BigInteger_String_Test();
    }

    /**
     * 使用字符串，默认是使用十进制
     */
    public static void BigInteger_String_Test(){
        String content = "-101010";
        System.out.println(new BigInteger(content).toString());

        System.out.println(new BigInteger(content, 2));
    }

    /**
     *  signum  -1 负数，0 表示0(表示的内容也要为0)，1 正数
     *  一个byte是8位  -1 1 的二进制位 为 11111111 00000001
     *  所以  new BigInteger(-1,new byte[]{-1,1}) 表示为 11111111 00000001 的大小 加上符号
     */
    public static void BigInteger_Bytes_Test(){
        byte[] bytes = new byte[]{-1,1};
        BigInteger bigInteger = new BigInteger(-1,bytes);
        System.out.println(bigInteger);
    }

}
