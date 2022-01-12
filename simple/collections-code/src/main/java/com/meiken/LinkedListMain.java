package com.meiken;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Author glf
 * @Date 2022/1/12
 */
public class LinkedListMain {

    public static void main(String[] args) {

        linkedList_TEST();
    }

    /**
     * LinkedList 有序集合
     */
    public static void linkedList_TEST(){
        LinkedList<String> strLinkedList = new LinkedList<>();

        strLinkedList.add("Amy");
        strLinkedList.add("Bob");
        strLinkedList.add("Carl");

        Iterator<String> iterator = strLinkedList.iterator();
        String first = iterator.next();
        String second = iterator.next();
        iterator.remove();

        System.out.println(first);
        System.out.println(second);
        System.out.println(strLinkedList);
    }
}
