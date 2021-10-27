package com.meiken;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedMain {
    public static void main(String[] args) {
       sortedUse();
    }

    public static void sortedUse(){
        List<Integer> integerList = Lists.newArrayList(1,2,3,4);

        List<Integer> sortedList = integerList.stream().sorted().collect(Collectors.toList());//默认递增
        System.out.println(sortedList);

        List<Integer> reverseOrderList = integerList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(reverseOrderList);
    }
}
