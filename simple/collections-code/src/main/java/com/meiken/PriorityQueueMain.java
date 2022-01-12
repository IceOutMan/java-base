package com.meiken;

import javafx.geometry.NodeOrientation;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author glf
 * @Date 2022/1/12
 */
public class PriorityQueueMain {
    public static void main(String[] args) {
        priorityQueue_TEST();
    }

    /**
     * 堆实现
     * 保存的对象 ： 1.实现了Comparable 2.构造好的Comparator对象
     */
    public static void priorityQueue_TEST(){
        PriorityQueue<Item> itemPriorityQueue = new PriorityQueue<>();

        itemPriorityQueue.add(new Item(3));
        itemPriorityQueue.add(new Item(2));
        itemPriorityQueue.add(new Item(8));
        itemPriorityQueue.add(new Item(1));

        // 遍历不一定有序
        for(Item item : itemPriorityQueue){
            System.out.println(item.id);
        }

        // 出队有序
        while(!itemPriorityQueue.isEmpty()){
            System.out.println(itemPriorityQueue.remove().id);
        }


        PriorityQueue<NormItem> normItemPriorityQueue = new PriorityQueue<>(Comparator.comparing(NormItem::getC));
        PriorityQueue<NormItem> otherNormItemPriorityQueue = new PriorityQueue<>(new Comparator<NormItem>() {
            @Override
            public int compare(NormItem o1, NormItem o2) {
                return o1.c - o2.c;
            }
        });

    }

    static class NormItem{
        public char c;
        public NormItem(char c){
            this.c = c;
        }

        public char getC() {
            return c;
        }

        public void setC(char c) {
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

