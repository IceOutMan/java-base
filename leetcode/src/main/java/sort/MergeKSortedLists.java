package sort;

import linklist.common.ListNode;

import java.util.List;

/**
 * @Author glf
 * @Date 2021/3/16
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode one = ListNode.getListNode(1,2,3,4,5);
        ListNode two = ListNode.getListNode(7, 8, 9, 10);

        ListNode listNode = mergeTwoLink(one, two);
        ListNode.printListNode(listNode);
    }

    public static ListNode mergeKLists(ListNode[] lists){
        if(lists == null || lists.length == 0){
            return null;
        }

        for(int i=1;i<lists.length;i++){
            ListNode preLinkHead = lists[i-1];
            ListNode curLinkHead = lists[i];
            lists[i] = mergeTwoLink(preLinkHead,curLinkHead);
        }
        return lists[lists.length-1];
    }

    public static ListNode mergeTwoLink(ListNode preLinkHead, ListNode curLinkHead){
        ListNode newHead = new ListNode();
        ListNode tail = newHead;

        ListNode preCur = preLinkHead;
        ListNode curCur = curLinkHead;

        while(preCur != null || curCur !=null){

            if(preCur !=null && curCur !=null){
                if(preCur.val < curCur.val){
                    // preCur
                    tail.next = preCur;
                    tail = preCur;

                    preCur = preCur.next;
                    continue;
                }else{
                    // curCur
                    tail.next = curCur;
                    tail = curCur;

                    curCur = curCur.next;
                    continue;
                }
            }else{
                if(preCur !=null){
                    // preCur
                    tail.next = preCur;
                    tail = preCur;
                    preCur = preCur.next;
                }else if(curCur != null){
                    // curCur
                    tail.next = curCur;
                    tail = curCur;
                    curCur = curCur.next;
                }
            }
        }
        return newHead.next;
    }
}
