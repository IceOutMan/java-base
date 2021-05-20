package org.example.collections;

import com.google.common.collect.HashMultimap;

public class MultiMapMain {
    public static void main(String[] args) {
        HashMultimap<Object, Object> hashMultimap = HashMultimap.create();
        hashMultimap.put("a",1);
        hashMultimap.put("b",2);

        hashMultimap.put("a",2);
        hashMultimap.put("a",2);
        System.out.println(hashMultimap);
        System.out.println(hashMultimap.asMap().get("a"));
    }
}
