package linklist.common;

/**
 * @Author glf
 * @Date 2021/3/13
 */
public class ListNode {

    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static  ListNode getListNode(int ...values){
        ListNode head = new ListNode();
        ListNode tail = head;

        for(int val : values){
            ListNode newNode = new ListNode(val);
            tail.next = newNode;
            tail = newNode;
        }

        return head.next;
    }

    public static void printListNode(ListNode head){
        ListNode cur = head;
        StringBuilder resultBuilder = new StringBuilder();
        while(cur !=null){
            resultBuilder.append(cur.val + ", ");

            cur = cur.next;
        }

        System.out.println(resultBuilder.toString());
    }
}
