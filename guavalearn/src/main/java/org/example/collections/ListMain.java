package org.example.collections;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;

public class ListMain {
    public static void main(String[] args) {
        commonUse();
        convertFromArray();
        convertFromMap();

        convertToArray();
    }

    public static void commonUse(){
        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5, 6);
        System.out.println(integers);
    }

    public static void convertFromArray(){
        Integer[] tempArr = new Integer[]{1,2,3,4};
        System.out.println(Lists.newArrayList(tempArr));
        System.out.println(Arrays.asList(tempArr));

    }
    public static void convertFromMap(){
        HashMap<Integer, String> map = Maps.newHashMap();
        map.put(1,"1");
        map.put(2,"2");
        map.put(3,"3");

        ArrayList<Integer> keyList = Lists.newArrayList(map.keySet());
        ArrayList<String> valueList = Lists.newArrayList(map.values());
        keyList.forEach(item -> {
            System.out.println(item);
        });
        valueList.forEach(item -> {
            System.out.println(item);
        });

    }

    public static void convertToArray(){
        ArrayList<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5);
        Object[] objects = list.toArray();
        Integer[] integers = list.toArray(new Integer[]{});
        Arrays.stream(objects).forEach(item->{
            System.out.println(item);
        });
        Arrays.stream(integers).forEach(item->{
            System.out.println(item);
        });
    }
}
