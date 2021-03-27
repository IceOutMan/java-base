package com.meiken.queue;

/**
 * 简单队列
 * 数组实现
 * @Author glf
 * @Date 2020/9/1
 */
public class ArrayQueue {

    private String[] items;
    private int n = 0;

    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity){
        this.items = new String[capacity];
        n = capacity;
    }


    public boolean enqueue(String item){
        //队满判断
        if(tail == n){
            //队头指向0，队尾指向n代表队列满了
            if(head == 0){
                return false;
            }

            //移动数据
            for(int i=head;i<tail;i++){
                items[i-head] = items[i];
            }
            tail = tail - head;
            head = 0;
        }

        items[tail] = item;
        tail++;
        return true;
    }


    public String dequeue(){
        //队空判断
        if(head == tail){
            return null;
        }
        String item = items[head];
        head++;
        return item;
    }



}
