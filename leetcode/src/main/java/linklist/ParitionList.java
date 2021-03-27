package linklist;

import linklist.common.ListNode;

/**
 * @Author glf
 * @Date 2021/3/13
 */
public class ParitionList {

    public static void main(String[] args) {
        ListNode head = ListNode.getListNode(4,3,2,5,2);
        head = partition(head,3);
        ListNode.printListNode(head);
    }
    public static ListNode partition(ListNode head, int x) {
        if(head == null){
            return  head;
        }
        ListNode preBigNode = null;
        ListNode bigNode = null;
        ListNode preNode = null;
        ListNode curNode = head;

        while (curNode != null){
            //bigNode 结点找一次即可
            if(curNode.val >=x && bigNode == null){
                preBigNode = preNode;
                bigNode = curNode;
            }

            // 如果当前结点 小于x，头插到 bigNode 前
            if(curNode.val < x && bigNode != null){
                if(preBigNode == null){
                    //bigNode是第一个结点
                    //摘出 curNode
                    preNode.next = curNode.next;

                    //插入头部
                    curNode.next = bigNode;
                    head = curNode;
                    preBigNode = head;//只有一次，以后采用 preBig -> big 插入中间

                    //重新赋值 curNode
                    curNode = preNode.next;
                    continue;

                }else {
                    //摘出 curNode
                    preNode.next = curNode.next;

                    //插入 curNode
                    curNode.next = bigNode;
                    preBigNode.next = curNode;
                    preBigNode = curNode;//preBig 和 big 中间插入一个Node 后更新 preBig

                    //重新赋值 curNode
                    curNode = preNode.next;
                    continue;
                }
            }
            preNode = curNode;
            curNode = curNode.next;
        }
        return head;
    }

}
