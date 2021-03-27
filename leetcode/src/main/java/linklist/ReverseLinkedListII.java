package linklist;

import linklist.common.ListNode;

/**
 * @Author glf
 * @Date 2021/3/13
 */
public class ReverseLinkedListII {

    public static void main(String[] args) {
        ListNode head = ListNode.getListNode(3,5);
        head = reverseBetween(head,1,2);

        ListNode.printListNode(head);


    }


    public static ListNode reverseBetween(ListNode head, int left, int right){
        if(head == null){
            return head;
        }

        ListNode preNode = null;
        ListNode curNode = head;
        ListNode startNode = null;
        ListNode preStartNode = null;

        int index = 1;
        // find left
        while(curNode != null){
            if(index == left){
                startNode = curNode;
                preStartNode = preNode;

                preNode = curNode;
                curNode = curNode.next;
                index++;
                break;
            }
            preNode = curNode;
            curNode = curNode.next;
            index++;
        }

        if(startNode == null){
            return head;
        }

        // find right
        while(curNode != null){
            if(index > right){
                break;
            }

            if(preStartNode == null){
                startNode.next = curNode.next;
                curNode.next = head;
                head = curNode;
            }else{
                startNode.next = curNode.next;
                curNode.next = preStartNode.next;
                preStartNode.next = curNode;
            }
            curNode = startNode.next;

            index++;
        }

        return head;
    }

}
