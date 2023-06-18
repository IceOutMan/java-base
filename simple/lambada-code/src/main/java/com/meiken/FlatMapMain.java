package com.meiken;

import com.google.common.collect.Lists;
import com.google.common.collect.Streams;

import java.util.List;
import java.util.stream.Stream;

/**
 * 多个流中内容展开 -> 平铺 -> 合成一个流
 */
public class FlatMapMain {
    public static void main(String[] args) {

        List<String> strListOne = Lists.newArrayList("one-1", "one-2", "one-3");
        List<String> strListTwo = Lists.newArrayList("two-1", "two-2", "two-3");

       Stream.of(strListOne, strListTwo).flatMap( temp -> {
           return temp.stream().map(str -> {return str + "-flat";});
       }).forEach(x -> {
           System.out.println(x);
       });
    }
}
