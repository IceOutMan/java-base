package com.meiken;

import com.google.common.collect.Lists;

import javax.swing.*;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class LambadaMain
{
    public static void main( String[] args )
    {
        new Thread(() -> {
            System.out.println("this is line 1");
            System.out.println("this is line 2");
        }).start();
        System.out.println( "Hello World!" );

        List<Integer> integerList = Lists.newArrayList(1,2,3,4);
        integerList.forEach(item -> System.out.println(item));

        System.out.println("MAP");
        mapTest();

        System.out.println("FILTER");
        filterTest();

        System.out.println("REDUCE");
        reduceTest();

        System.out.println("SORTED");
        sortedTest();



    }
    public static void mapTest(){
        List<Integer> integerList = Lists.newArrayList(1,2,3,4);

        List<Integer> mapList = integerList.stream().map(item -> item * 2).collect(Collectors.toList());
        System.out.println(mapList);


    }
    public static void filterTest(){
        List<Integer> integerList = Lists.newArrayList(1,2,3,4);

        List<Integer> filterList = integerList.stream().filter(item -> item % 2 == 0).collect(Collectors.toList());
        System.out.println(filterList);

    }
    public static void reduceTest(){
        List<Integer> integerList = Lists.newArrayList(1,2,3,4);

        Integer sumReduce =  integerList.stream().reduce(10,(x, y) -> x + y);
        Integer subReduce =  integerList.stream().reduce(10,(identity, item) -> identity- item);
        System.out.println(sumReduce);
        System.out.println(subReduce);
    }
    public static void sortedTest(){
        List<Integer> integerList = Lists.newArrayList(1,2,3,4);

        List<Integer> sortedList = integerList.stream().sorted().collect(Collectors.toList());//默认递增
        System.out.println(sortedList);

        List<Integer> reverseOrderList = integerList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(reverseOrderList);
    }
}
