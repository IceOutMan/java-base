package com.meiken;

/**
 * 时间复杂度要求不同，方式不同
 * O(n^2) 可以遍历迭代
 * O(nlogN) 可以使用归并排序的方式
 */
public class SortList {
    public static void main(String[] args) {
        ListNode head = ListNode.buildLink(new int[]{6,5,4,3,2,1,0});

        ListNode listNode = mergeSortList(head);
        ListNode.printLink(listNode);

    }



    public static ListNode mergeSortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode slowPointer = QuickSlowPointerLink.findSlowPointer(head);
        // 断开
        ListNode nextHead = slowPointer.next;
        slowPointer.next = null;

        // 分别排序
        ListNode firstPartNode = mergeSortList(head);
        ListNode secondPartNode =  mergeSortList(nextHead);

        return MergeTwoSortedLink.merge(firstPartNode, secondPartNode);
    }




}
