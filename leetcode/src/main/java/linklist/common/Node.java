package linklist.common;

/**
 * @Author glf
 * @Date 2021/3/14
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
