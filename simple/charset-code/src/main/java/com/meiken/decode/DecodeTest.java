package com.meiken.decode;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * @Author glf
 * @Date 2023/10/16
 */
public class DecodeTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "中";

        // utf-8 字符集 - 编码
        Charset utf8Charset = Charset.forName("utf-8");
        ByteBuffer byteBuffer = utf8Charset.encode(s);
        System.out.println(byteBuffer.capacity());

        // unicode 字符集 - 解码
        Charset unicodeCharSet = Charset.forName("unicode");
        CharBuffer charBuffer = unicodeCharSet.decode(byteBuffer);
        System.out.println(charBuffer.toString());

        // utf-8 字符集 - 解码
        byteBuffer.flip();
        System.out.println(utf8Charset.decode(byteBuffer).toString());

    }
}
