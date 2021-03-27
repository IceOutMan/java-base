package com.meiken.link;

/**
 * head作为链表的第一个数据节点
 * 非空头节点链表
 *
 * 1.单链表的插入、删除、查找
 * 2。链表中存储int类型数据
 *
 * 插入删除时间复杂度：O(1)
 * 查找时间复杂度：O(n)
 *
 *
 * @Author glf
 * @Date 2020/9/18
 */
public class SinglyLinkedList {

    private Node head = null;

    public SinglyLinkedList(Node head){
        this.head = head;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    //插入
    public void insertToHead(int value){
        Node newNode = new Node(null,value);
        insertToHead(newNode);
    }
    public void insertToHead(Node newNode){
        if(head == null){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertToTail(int value){

        Node newNode = new Node(null,value);

        if(head == null){
            head = newNode;
            return;
        }
        //找到tail
        Node tail = head;
        while (tail.next !=null){
            tail = tail.next;
        }

        //插入
        tail.next = newNode;
    }

    public void insertAfter(Node p,int value){
        Node newNode = new Node(null,value);
        insertAfter(p,newNode);
    }
    public void insertAfter(Node p,Node newNode){

        if(head == null){
            return;
        }
        Node target = head;
        //找到p
        while (target != null){
            if(target.data == p.data){
                break;
            }
            target = target.next;
        }

        //插入
        if(target != null){
            newNode.next = target.next;
            target.next = newNode;
        }

    }

    public void insertBefore(Node p,int value){
        Node newNode = new Node(null,value);
        insertBefore(p,newNode);
    }
    public void insertBefore(Node p,Node newNode){
        if(head == null){
            return;
        }
        Node target = head;
        Node preTarget = null;
        //找到p
        while (target != null){
            if(target.data == p.data){
                break;
            }
            preTarget  =target;
            target = target.next;
        }

        //插入
        if(preTarget == null){
            newNode.next = target;
            head = newNode;
        }else if(target != null){
            newNode.next = target;
            preTarget.next = newNode;
        }
    }


    //删除
    public void deleteByValue(int value){
        Node deleteNode = new Node(null,value);
        deleteByNode(deleteNode);
    }
    public void deleteByNode(Node p){

        if(head == null){
            return;
        }

        Node target = head;
        Node preTarget = null;

        //查找
        while (target != null){

            if(target.data == p.data){
                break;
            }

            preTarget= target;
            target = target.next;
        }
        //删除
        if(preTarget == null){
            head = target.next;
        }else if(target != null){
            preTarget.next = target.next;
        }

    }


    //查找
    public Node findByValue(int value){

        Node target = null;
        Node p = head;
        while (p != null){
            if(p.data == value){
                target = p;
                break;
            }
            p = p.next;
        }
        return target;
    }

    public Node findByIndex(int index){
        int indexCount = 0;

        Node p = head;
        while (p !=null){
            if(indexCount == index){
                break;
            }
            p = p.next;
            indexCount ++;
        }

        return p;
    }


    public void printAll(){
        Node p = head;
        while (p != null){
            System.out.print(p.getData() + "  ");
            p = p.next;
        }
        System.out.println();
    }


}
