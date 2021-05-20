package org.example.str;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.List;

public class JoinerMain {
    public static void main(String[] args) {
        String[] strArray = new String[]{"1","1","1","1","1","1"};
        List<Integer> intList= new ArrayList<>();
        intList.add(1);intList.add(2);intList.add(3);intList.add(4);
        System.out.println(Joiner.on("#").join(strArray));
        System.out.println(Joiner.on("#").join(intList));
    }
}
