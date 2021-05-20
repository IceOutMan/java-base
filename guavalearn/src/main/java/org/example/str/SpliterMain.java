package org.example.str;

import com.google.common.base.Splitter;

public class SpliterMain {
    public static void main(String[] args) {
        System.out.println(Splitter.on(",").split("1,2 ,,  ,232,   3321,5   ,78"));
        System.out.println(Splitter.on(",").trimResults().split("1,2 ,,  ,232,   3321,5   ,78"));
        System.out.println(Splitter.on(",").trimResults().omitEmptyStrings().split("1,2 ,,  ,232,   3321,5   ,78"));
        System.out.println(Splitter.onPattern("www.*?com").trimResults().split("BBBwww.baidu.comDDDGGGwww.google.comGGGG"));
    }
}
