package com.meiken.encode;


import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class EncodeTest {
    public static void main(String[] args) {
        // 你将 \u00bf 放在字符串中，Java 在编译时会将其解释为对应的 Unicode 字符
        String input =  "\u00bfMa\u00f1ana?";
        String[] charsetNames = {
                "US-ASCII", "ISO-8859-1","UTF-8","UTF-16BE", "UTF-16LE","UTF-16"
        };

        for (int i = 0; i < charsetNames.length; i++) {
            doEncode(Charset.forName(charsetNames[i]), input);
        }
    }

    private static void doEncode(Charset cs, String input){
        ByteBuffer byteBuffer = cs.encode(input);
        System.out.println("Charset: " + cs.name());
        System.out.println(" Input: " + input);
        System.out.println("Encoded: " );
        for (int i = 0; byteBuffer.hasRemaining(); i++) {
            int b = byteBuffer.get();
            int ival = ((int)b) & 0xff;
            char  c = (char)ival;
            if(i<10) System.out.print(" ");
            System.out.print(" "  +   i + ": ");
            if(ival<16) System.out.print("0");// 小于16，使用要表示成 0?
            System.out.print(Integer.toHexString(ival));
            if(Character.isWhitespace(c) || Character.isISOControl(c)){
                System.out.println("");
            }else{
                System.out.println(" (" + c + ")");
            }
        }
        System.out.println("");
    }
}
