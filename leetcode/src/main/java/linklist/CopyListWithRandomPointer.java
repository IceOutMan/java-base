package linklist;

import linklist.common.Node;

/**
 * @Author glf
 * @Date 2021/3/15
 */
public class CopyListWithRandomPointer {
    public static void main(String[] args) {

    }

    public static Node copyRandomList(Node head){
        if(head == null){
            return head;
        }

        //insert copy node
        Node cur = head;
        while(cur != null){

            Node copyNode = new Node(cur.val);

            copyNode.next = cur.next;
            cur.next = copyNode;

            cur = copyNode.next;
        }

        // init copy node random value
        cur = head;
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }

            cur = cur.next.next;
        }

        //split link
        Node copyNodeHead = new Node(0);
        Node copyNodeTail = copyNodeHead;
        cur = head;
        while(cur !=null){
            copyNodeTail.next = cur.next;
            copyNodeTail = copyNodeTail.next;

            cur.next = cur.next.next;
            cur = cur.next;
        }

        return copyNodeHead.next;
    }

}
