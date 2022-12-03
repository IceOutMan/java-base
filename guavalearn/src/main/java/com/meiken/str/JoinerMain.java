package com.meiken.str;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.util.ArrayList;

public class JoinerMain {
    public static void main(String[] args) {
        joinArray();
        joinList();
    }

    public static void joinArray(){
        Integer[] arr = new Integer[]{1,2,3,4,5};
        String result = Joiner.on("#").join(arr);
        System.out.println(result);
    }


    public static void joinList(){
        ArrayList<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5);
        String result = Joiner.on("#").join(list);
        System.out.println(result);
    }
}
