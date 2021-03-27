package com.meiken.queue;

/**
 * @Author glf
 * @Date 2020/9/19
 */
public class QueueBaseOnLinkedList {


    private Node head = null;
    private Node tail = null;


    //入队
    public void enqueue(String value){
        if(tail == null){
            Node newNode = new Node(null,value);

            head = newNode;
            tail = newNode;
        }else{
            Node newNode = new Node(null,value);
            tail.next = newNode;
            tail = newNode;
        }
    }

    //出队
    public String dequeue(){

        if(head == null){
            return null;
        }

        String value = head.data;
        head = head.next;
        return value;
    }


    //打印
    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }




    public static class Node{
        private String data;
        private Node next;

        public Node(Node next,String data){
            this.next = next;
            this.data = data;
        }

        public String getValue() {
            return data;
        }

        public void setValue(String value) {
            this.data = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    public static void main(String[] args) {

        QueueBaseOnLinkedList queueBaseOnLinkedList = new QueueBaseOnLinkedList();

        queueBaseOnLinkedList.enqueue("张三");
        queueBaseOnLinkedList.printAll();

        queueBaseOnLinkedList.enqueue("李四");
        queueBaseOnLinkedList.printAll();

        queueBaseOnLinkedList.enqueue("王武");
        queueBaseOnLinkedList.printAll();

        queueBaseOnLinkedList.dequeue();
        queueBaseOnLinkedList.printAll();
    }
}
