package org.example.str;

import com.google.common.base.Strings;

/**
 * @Author glf
 * @Date 2021/1/13
 */
public class StrMain {

    public static void main(String[] args) {
        String strTest = "TD";
        System.out.println(Strings.isNullOrEmpty("null"));
        System.out.println(Strings.nullToEmpty(null));
        System.out.println(Strings.nullToEmpty("TTT"));
        System.out.println(Strings.emptyToNull(""));
        System.out.println(Strings.emptyToNull("DDD"));

        System.out.println(Strings.padStart(strTest, 10,'x' ));
        System.out.println(Strings.padEnd(strTest, 10,'x' ));
        System.out.println(Strings.repeat(strTest,5));
        System.out.println(Strings.commonPrefix("TDxxxDT", "TDyyy"));
        System.out.println(Strings.commonSuffix("TDxxxDT", "yyyDT"));
    }
}
