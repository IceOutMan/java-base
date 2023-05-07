package com.meiken;


public class MergeTwoSortedLink {

    public static void main(String[] args) {
        ListNode first = ListNode.buildLink(new int[]{1,3,5,7,9});
        ListNode second = ListNode.buildLink(new int[]{2,4,6,8,10});

        ListNode.printLink(first);
        ListNode.printLink(second);
        ListNode merge = merge(first, second);

        System.out.print("Merged-> : ");
        ListNode.printLink(merge);
    }

    public static ListNode merge(ListNode first, ListNode second){

        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;

        while(first != null || second != null){
            if(first == null && second != null){
                // add second
                tail.next = second;
                tail = tail.next;
                second = second.next;
                tail.next = null;
                continue;
            }
            if(first != null && second == null){
                // add first
                tail.next = first;
                tail = tail.next;
                first = first.next;
                tail.next = null;
                continue;
            }
            // compare first and second
            if(first.val < second.val){
                // add first
                tail.next = first;
                tail = tail.next;
                first = first.next;
                tail.next = null;
            }else{
                // add second
                tail.next = second;
                tail = tail.next;
                second = second.next;
                tail.next = null;
            }
        }

        return dummyHead.next;

    }




}
