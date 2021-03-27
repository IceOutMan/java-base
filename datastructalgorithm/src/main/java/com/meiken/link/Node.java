package com.meiken.link;

/**
 * @Author glf
 * @Date 2020/9/18
 */
public class Node {

    public Node next;

    public int data;

    public Node(Node next, int data){
        this.next = next;
        this.data = data;
    }

    public int getData(){
        return data;
    }

    public void setData(int data){
        this.data = data;
    }
}