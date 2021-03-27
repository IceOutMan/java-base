package com.meiken.link;

/**
 * @Author glf
 * @Date 2020/9/18
 */
public class Test {

    public static void main(String[] args) {

        SinglyLinkedList nodeList1 = new SinglyLinkedList(new Node(null,0));
        nodeList1.printAll();

        //尾插
        nodeList1.insertToTail(1);
        nodeList1.insertToTail(4);
        nodeList1.printAll();

        //头插
        nodeList1.insertToHead(-1);
        nodeList1.printAll();

        //后插
        nodeList1.insertAfter(new Node(null,1),2);
        nodeList1.printAll();

        //前插
        nodeList1.insertBefore(new Node(null,4), 3);
        nodeList1.printAll();

        //删除
        nodeList1.deleteByValue(-1);
        nodeList1.deleteByValue(-1);
        nodeList1.printAll();


        //查找
        Node byIndex = nodeList1.findByIndex(3);
        System.out.println(byIndex == null ? "null" : byIndex.data);

        Node byValue = nodeList1.findByValue(4);
        System.out.println(byValue == null ? "null" : byValue.data);

        //检查环
        System.out.println(LinkListOperation.checkCircle(nodeList1.getHead()));
        System.out.println(LinkListOperation.checkCircle(getCircleNodeLinkList()));

        //找中间节点
        System.out.println(LinkListOperation.findMiddleNode(nodeList1.getHead()).data);

        //删除倒数第K个
        nodeList1.printAll();
        nodeList1.setHead(LinkListOperation.deleteLeastKth(nodeList1.getHead(),5));
        nodeList1.printAll();

        //单链表反转
        nodeList1.setHead(LinkListOperation.reverse(nodeList1.getHead()));
        nodeList1.printAll();

        //两个有序链表合并
        Node nodeListOne = getNodeLinkList(1,3,5,9);
//        Node nodeListTwo = getNodeLinkList(2,4,6,8);
        Node nodeListTwo = getNodeLinkList(19,20,21,22);
        Node mergeResultHead = LinkListOperation.mergeTwoLists(nodeListOne, nodeListTwo);
        LinkListOperation.printAll(mergeResultHead);

        //判断是否是回文数
        Node palindromeNode = getNodeLinkList(1,1,22,1,1);
        System.out.println(LinkListOperation.palindrome(palindromeNode));

    }


    public static Node getCircleNodeLinkList(){
        Node head = new Node(null,0);
        Node node1 = new Node(null,1);
        Node node2 = new Node(null,2);
        Node node3 = new Node(null,3);
        Node node4 = new Node(null,4);
        Node node5 = new Node(null,5);
        Node node6 = new Node(null,6);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;

        return  head;
    }

    public static Node getNodeLinkList(int... intArray){

        SinglyLinkedList nodeList = new SinglyLinkedList(new Node(null,-1));

        Node head = new Node(null,-1);

        for(int temp : intArray){
            nodeList.insertToTail(temp);
        }

        nodeList.deleteByValue(-1);

        return  nodeList.getHead();
    }
}
