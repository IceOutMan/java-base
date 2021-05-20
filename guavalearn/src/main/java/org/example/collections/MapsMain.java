package org.example.collections;

import com.google.common.collect.Maps;

import java.util.HashMap;

public class MapsMain {
    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = Maps.newHashMap();
        hashMap.put("a",1);
        hashMap.put("b",2);
        hashMap.put("a",1);
        System.out.println(hashMap);
    }
}
