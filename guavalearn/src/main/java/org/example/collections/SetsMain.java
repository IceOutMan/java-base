package org.example.collections;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author glf
 * @Date 2021/1/21
 */
public class SetsMain {
    public static void main(String[] args) {
       baseUseTest();
       setUnionTest();
       setInterSectionTest();
       setDifferenceTest();
    }

    public static void baseUseTest(){
        HashSet<Object> hashSet = Sets.newHashSet();
        hashSet.add("A");
        hashSet.add("B");
        hashSet.add("C");
        hashSet.add("A");
        System.out.println(hashSet);
    }

    /**
     * 并集
     */
    public static void setUnionTest(){
        HashSet<String> set1 = Sets.newHashSet("A","B","C","D");
        HashSet<String> set2 = Sets.newHashSet("C", "D", "E", "F");
        System.out.println(Sets.union(set1,set2));
    }

    /**
     * 交集
     */
    public static void setInterSectionTest(){
        HashSet<String> set1 = Sets.newHashSet("A","B","C","D");
        HashSet<String> set2 = Sets.newHashSet("C", "D", "E", "F");
        System.out.println(Sets.intersection(set1,set2));
    }

    /**
     * 差集
     */
    public static void setDifferenceTest(){
        HashSet<String> set1 = Sets.newHashSet("A","B","C","D");
        HashSet<String> set2 = Sets.newHashSet("C", "D", "E", "F");
        System.out.println(Sets.difference(set1,set2));
    }



}
