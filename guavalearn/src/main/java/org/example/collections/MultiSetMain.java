package org.example.collections;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class MultiSetMain {
    public static void main(String[] args) {
        Multiset<Object> hashMultiset = HashMultiset.create();
        hashMultiset.add("1");
        hashMultiset.add("2");
        hashMultiset.add("3");
        hashMultiset.add("1");
        System.out.println(hashMultiset.elementSet());
        System.out.println(hashMultiset.count("1"));
    }
}
