package com.meiken;

import com.google.common.collect.Lists;

import java.util.List;

public class ForEachMain {
    public static void main(String[] args) {
        forEachUse();
    }

    public static void forEachUse(){
        List<Integer> integerList = Lists.newArrayList(1,2,3,4);
        integerList.forEach(item -> System.out.println(item));
    }
}
