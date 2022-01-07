package com.meiken;

import com.google.common.collect.Lists;

import java.util.List;

public class ReduceMain {
    public static void main(String[] args) {
        reduceUse();
    }

    public static void reduceUse(){
        List<Integer> integerList = Lists.newArrayList(1,2,3,4);

        Integer sumReduce =  integerList.stream().reduce(10,(x, y) -> x + y);
        Integer subReduce =  integerList.stream().reduce(10,(identity, item) -> identity- item);
        System.out.println(sumReduce);
        System.out.println(subReduce);
    }

}
