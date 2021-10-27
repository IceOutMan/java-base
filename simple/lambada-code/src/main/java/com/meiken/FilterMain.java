package com.meiken;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

public class FilterMain {
    public static void main(String[] args) {
        filterUse();
    }

    public static void filterUse(){
        List<Integer> integerList = Lists.newArrayList(1,2,3,4);

        List<Integer> filterList = integerList.stream().filter(item -> item % 2 == 0).collect(Collectors.toList());
        System.out.println(filterList);
    }
}
