package com.meiken.collections;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.HashMap;

public class MapsMain {
    public static void main(String[] args) {
        ArrayList list = Lists.newArrayList("1","2","3");
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

    public static void maps(){
        HashMap<Object, Object> hashMap = Maps.newHashMap();
        hashMap.put("a",1);
        hashMap.put("b",2);
        hashMap.put("a",1);
        System.out.println(hashMap);
    }
}
