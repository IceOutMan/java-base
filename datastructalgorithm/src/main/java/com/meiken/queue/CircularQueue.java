package com.meiken.queue;

/**
 * 循环队列
 * 数组实现
 * @Author glf
 * @Date 2020/9/1
 */
public class CircularQueue {

    private String[] items;
    private int n;

    private int head=0;
    private int tail=0;

    public CircularQueue(int capacity){
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 进队
     * @param item
     * @return
     */
    public boolean enqueue(String item){
        //队满 - > 队尾的下一个是队头
        if((tail+1)%n == head){
            return false;
        }

        items[tail]=item;
        tail = (tail+1) % n;

        return true;
    }


    /**
     * 出队
     * @return
     */
    public String dequeue(){
        //队空 -> head、tail指向同一个
        if(head == tail){
            return null;
        }
        String item = items[head];
        head = (head+1) % n;

        return item;
    }

}
