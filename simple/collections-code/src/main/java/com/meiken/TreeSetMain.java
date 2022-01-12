package com.meiken;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Author glf
 * @Date 2022/1/12
 */
public class TreeSetMain {

    public static void main(String[] args) {

        treeSet_Test();

        customDefineItemTreeSet_Test();
    }

    /**
     * TreeSet 是有顺序的集合
     * TreeSet 中的元素必须实现 Comparable 接口，或者构造集时必须提供一个Comparator
     */
    public static void treeSet_Test(){
        TreeSet<String> strTreeSet = new TreeSet<>();

        strTreeSet.add("Bob");
        strTreeSet.add("Amy");
        strTreeSet.add("Carl");
        for(String str : strTreeSet){
            System.out.println(str);
        }
    }

    public static void customDefineItemTreeSet_Test(){

        // Item 实现了 Comparable 接口
        TreeSet<Item> itemTreeSet = new TreeSet<>();
        itemTreeSet.add(new Item(2));
        itemTreeSet.add(new Item(1));
        itemTreeSet.add(new Item(3));

        for (Item item : itemTreeSet){
            System.out.println(item.id);
        }


        // 带有自定的Comparator
        TreeSet<NormItem> normItemTreeSet = new TreeSet<>(new Comparator<NormItem>() {
            @Override
            public int compare(NormItem o1, NormItem o2) {
                return o1.c - o2.c;
            }
        });
        normItemTreeSet.add(new NormItem('b'));
        normItemTreeSet.add(new NormItem('d'));
        normItemTreeSet.add(new NormItem('a'));
        for(NormItem normItem : normItemTreeSet){
            System.out.println(normItem.c + "");
        }
    }

    static class NormItem{
        public char c;
        public NormItem(char c){
            this.c = c;
        }

    }



    static class Item implements Comparable<Item>{
        public Item(Integer id){
            this.id = id;
        }
        public Integer id;

        @Override
        public int compareTo(Item other) {
            // 升序排序
            return id - other.id;
        }
    }
}
