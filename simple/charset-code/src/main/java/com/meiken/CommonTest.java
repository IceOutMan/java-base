package com.meiken;

import java.io.UnsupportedEncodingException;

/**
 * @Author glf
 * @Date 2023/10/16
 */
public class CommonTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "𫖯"; // 4 byte
        System.out.println(s + ": char " +  s.length()); // 2
        // utf-8 使用变长编码，该字符使用 4 个字节
        System.out.println(s + ": utf-8 bytes " +  s.getBytes("utf-8").length); // 4 byte
        // Java 内置编码使用的是 utf-16 ，由于一个 unitCode是两个字节，需要知道存储的字节顺序，这里输出的字节数多了 2 字节的 BOM（Byte Order Mark）字节顺序标记（大小端存储）
        System.out.println(s + ": utf-16 bytes " +  s.getBytes("utf-16").length); // 6 byte
        // unicode 字符集太庞大，这里默认使用的是他的子集 utf-16 所以和 utf-16 一样
        System.out.println(s + ": unicode bytes " +  s.getBytes("unicode").length); // 6 byte


        s = "中"; // 2 byte
        System.out.println(s + ": char " +  s.length()); // 1
        // utf-8 使用变长编码，改字符使用 3 个字节
        System.out.println(s + ": utf-8 bytes " +  s.getBytes("utf-8").length); // 3 byte
        // Java 内置编码使用的是 utf-16 ，由于一个 unitCode是两个字节，需要知道存储的字节顺序，这里输出的字节数多了 2 字节的 BOM（Byte Order Mark）字节顺序标记（大小端存储）
        System.out.println(s + ": utf-16 bytes " +  s.getBytes("utf-16").length); // 4 byte
        // unicode 字符集太庞大，这里默认使用的是他的子集 utf-16 所以和 utf-16 一样
        System.out.println(s + ": unicode bytes " +  s.getBytes("unicode").length); // 4 byte


    }
}
