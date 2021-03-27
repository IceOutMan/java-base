package com.meiken.queue;

/**
 * 非循环队列
 *
 * @Author glf
 * @Date 2020/9/19
 */
public class DynamicArrayQueue {

    private String[] items;
    private int n;

    private int head = 0;
    private int tail = 0;

    public DynamicArrayQueue(int capacity){
        this.items = new String[capacity];
        this.n = capacity;
    }

    //入队
    public void enqueue(String value){

        //队满判断
        if(tail == n && head > 0){
            //队列可以移动数据
            for(int i = head;i<tail;i++){
                items[i-head] = items[i];
            }
            tail = tail - head;
            head = head - head;
        }else if(tail == n){
            return;
        }
        items[tail] = value;
        tail = tail + 1;
    }

    //出队
    public String dequeue(){
        //队空判断
        if(head == tail){
            return null;
        }

        String value = items[head];
        head = head +1;

        return value;
    }

    //打印
    public void printAll() {
        for(int i=head;i<tail;i++){
            System.out.print(items[i] + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        DynamicArrayQueue dynamicArrayQueue = new DynamicArrayQueue(4);

        dynamicArrayQueue.enqueue("张1");
        dynamicArrayQueue.enqueue("张2");
        dynamicArrayQueue.enqueue("张3");
        dynamicArrayQueue.enqueue("张4");
        dynamicArrayQueue.printAll();

        dynamicArrayQueue.dequeue();
        dynamicArrayQueue.dequeue();
        dynamicArrayQueue.printAll();

        dynamicArrayQueue.enqueue("张5");
        dynamicArrayQueue.printAll();

        dynamicArrayQueue.enqueue("张6");
        dynamicArrayQueue.enqueue("张7");
        dynamicArrayQueue.printAll();

    }

}
