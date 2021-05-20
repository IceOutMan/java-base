package org.example.collections;

import com.google.common.collect.Lists;

import java.util.ArrayList;

public class ListMain {
    public static void main(String[] args) {
        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5, 6);
        System.out.println(integers);
    }
}
