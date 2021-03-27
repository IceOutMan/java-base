package com.meiken.link;

/**
 * 1.单链表反转
 *
 * 2.链表中环的检测
 *
 * 3.两个有序链表合并
 *
 * 4.删除链表倒数第n个节点
 *
 * 5.求链表的中间节点
 *
 * 6.链表是否是回文数
 *
 * @Author glf
 * @Date 2020/9/17
 */
public class LinkListOperation {


    //单链表反转
    public static Node reverse(Node head){
        if(head == null) {
            return null;
        }
        Node cur = head.next;

        head.next = null;

        while(cur != null){
            Node tmp = cur.next;
            cur.next = head;

            head = cur;
            cur = tmp;
        }

        return head;
    }

    //检测环
    public static boolean checkCircle(Node head){
        if(head == null) {
            return false;
        }
        Node fast = head.next;
        Node slow = head;

        while (fast != null && fast.next !=null){

            //先走
            fast = fast.next.next;
            slow = slow.next;

            //判断
            if(fast == slow){
                return true;
            }

        }

        return false;
    }

    //有序链表合并
    public static Node mergeTwoLists(Node l1,Node l2){

        if(l1 == null) {
            return  null;
        }
        if(l2 == null) {
            return  null;
        }

        Node head = new Node(null, -1);
        Node tail = head;

        while (l1 != null && l2 != null){

            if(l1.data < l2.data){
                tail.next = l1;
                l1 = l1.next;
            }else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;

        }

        if(l1 !=null){
            tail.next = l1;
        }

        if(l2 !=null){
            tail.next = l2;
        }

        return head.next;
    }

    //删除链表倒数第k个节点
    public static Node deleteLeastKth(Node head,int k){

        if(k<=0){
            return head;
        }

        Node p = head;

        int i = 0;
        while (p!=null && i<k-1){
            p = p.next;
            i++;
        }
        if(p==null){
            return  head;
        }

        Node kNode = head;
        Node preKNode = null;

        while (p.next!=null){
            p = p.next;
            preKNode = kNode;
            kNode = kNode.next;
        }

        if(preKNode == null){
            head = head.next;
        }else {
            preKNode.next = kNode.next;
        }

        return head;
    }

    //求链表的中间节点
    public static Node findMiddleNode(Node nl){
        if (nl == null) {
            return null;
        }
        Node fast = nl.next;
        Node slow = nl;

        while (fast !=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static boolean palindrome(Node head){
        if(head == null){
            return false;
        }

        Node low = head;
        Node fast = head.next;

        while (fast != null && fast.next != null){
            low = low.next;
            fast = fast.next.next;
        }


        Node middleLeft = null;
        Node middleRight = null;
        if(fast == null){
            //奇数
            middleLeft = low;
            middleRight = low.next;

            middleLeft.next = null;
            middleLeft = reverse(head).next;
        }
        else{
            //偶数个
            middleLeft = low;
            middleRight = low.next;

            middleLeft.next = null;
            middleLeft = reverse(head);
        }

        boolean isPalindromeFlag = true;
        while(middleLeft!=null){
            if(middleLeft.data != middleRight.data){
                isPalindromeFlag = false;
                break;
            }
            middleLeft = middleRight.next;
            middleRight = middleRight.next;
        }

        return isPalindromeFlag;
    }

    public static void printAll(Node head){
        Node p = head;
        while (p != null){
            System.out.print(p.getData() + "  ");
            p = p.next;
        }
        System.out.println();
    }

    public static Node createNode(int value){
        return new Node(null,value);
    }



}
