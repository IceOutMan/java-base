package com.meiken;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

public class MapMian {
    public static void main(String[] args) {

        mapUse();
    }

    public static void mapUse(){
        List<Integer> integerList = Lists.newArrayList(1,2,3,4);

        List<Integer> mapList = integerList.stream().map(item -> item * 2).collect(Collectors.toList());
        System.out.println(mapList);
    }
}
