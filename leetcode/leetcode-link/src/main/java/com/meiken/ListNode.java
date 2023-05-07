package com.meiken;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    public static void printLink(ListNode head){

        ListNode p = head;
        while(p != null){
            System.out.print(p.val);
            p = p.next;
            if(p != null){
                System.out.print(" -> ");
            }
        }
       System.out.println();
    }

    public static ListNode buildLink(int[] nums){
        ListNode dummyHead = new ListNode();
        ListNode dummyTail = dummyHead;
        for(int num : nums){
            ListNode temp = new ListNode(num);
            dummyTail.next = temp;
            dummyTail = temp;
        }

        return dummyHead.next;
    }
}
