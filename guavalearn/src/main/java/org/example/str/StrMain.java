package org.example.str;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author glf
 * @Date 2021/1/13
 */
public class StrMain {

    public static void main(String[] args) {
        strings();
        joiner();
        spliter();
        charmatcher();
    }
    public static void spliter(){
        System.out.println(Splitter.on(",").split("1,2 ,,  ,232,   3321,5   ,78"));
        System.out.println(Splitter.on(",").trimResults().split("1,2 ,,  ,232,   3321,5   ,78"));
        System.out.println(Splitter.on(",").trimResults().omitEmptyStrings().split("1,2 ,,  ,232,   3321,5   ,78"));
        System.out.println(Splitter.onPattern("www.*?com").trimResults().split("BBBwww.baidu.comDDDGGGwww.google.comGGGG"));
    }
    public static void charmatcher(){
        System.out.println(CharMatcher.is('a').matchesAllOf("aaa"));
        System.out.println(CharMatcher.is('s').indexIn("01ssssss"));
        System.out.println(CharMatcher.is('s').countIn("sssssssss"));
        System.out.println(CharMatcher.is('a').retainFrom("bazaar"));
        System.out.println(CharMatcher.is('a').removeFrom("bazaar"));
    }

    public static void joiner(){
        String[] strArray = new String[]{"1","1","1","1","1","1"};
        List<Integer> intList= new ArrayList<>();
        intList.add(1);intList.add(2);intList.add(3);intList.add(4);
        System.out.println(Joiner.on("#").join(strArray));
        System.out.println(Joiner.on("#").join(intList));
    }

    public static void strings(){
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
