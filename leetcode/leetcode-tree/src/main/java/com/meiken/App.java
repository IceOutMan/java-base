package com.meiken;

import com.meiken.traversal.InOrderTraversal;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
//
//        TreeNode root = new TreeNode(3);
//        root.right = new TreeNode(1);
//        root.right.left = new TreeNode(2);
//
//        InOrderTraversal.morrisInOrderTraversal(root);
//        System.out.println("");
//        recoverTree(root);
//        System.out.println("");
//        InOrderTraversal.recursionInOrderTraversal(root);

        Node head = new Node(-10);
        head.next = new Node(-3);
        head.next.next = new Node(0);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(9);

        TreeNode treeNode = sortedListToBST(head);
        InOrderTraversal.recursionInOrderTraversal(treeNode);

    }

    public static TreeNode sortedListToBST(Node head) {
        return doSortedListToBST(head, linkListLen(head));
    }

    public static TreeNode doSortedListToBST(Node head, int len){
        if(len == 0){
            return null;
        }
        if(len == 1){
            return new TreeNode(head.val);
        }

        int mid = (1+len) / 2;

        Node midNode = findKListNode(head, mid);

        TreeNode root = new TreeNode(midNode.val);

        root.left = doSortedListToBST(head, mid -1 );
        root.right = doSortedListToBST(midNode.next, len - mid);

        return root;
    }

    public static Node findKListNode(Node head, int k){
        int len = 0;

        Node kNode = null;

        Node p = head;
        while(p != null){
            len++;
            if(len == k){
                kNode = p;
                break;
            }
            p = p.next;
        }
        return kNode;
    }

    public static int linkListLen(Node head){

        int len = 0;

        Node p = head;
        while(p != null){
            len++;
            p = p.next;
        }

        return len;
    }

    public static Node connect(Node root){
        Node tmpRoot = root;
        while(root != null){

            // 下层起始节点
            Node nextLevelFirst = null;
            // 下层的 pre 节点
            Node nextLevelPre = null;

            for(; root != null; root = root.next){
                // 如果下层起始节点为空，初始化
                if(nextLevelFirst == null){
                    nextLevelFirst = root.left != null ? root.left : root.right;
                }

                if(root.left != null){
                    if(nextLevelPre != null){
                        nextLevelPre.next = root.left;
                    }
                    nextLevelPre = root.left;
                }
                if(root.right != null){
                    if(nextLevelPre != null){
                        nextLevelPre.next = root.right;
                    }
                    nextLevelPre = root.right;
                }
            }

            root = nextLevelFirst;
        }

        return tmpRoot;

    }


    public static void recoverTree(TreeNode root) {

        TreeNode firstNode = null;
        TreeNode secondNode = null;


        TreeNode preViewNode = null;
        TreeNode cur = root;
        // 使用  morris 遍历 进行中序遍历
        while( cur != null){

            if(cur.left == null){
                // 左子树为空，访问当前节点
                // TODO: 检测顺序
                if(preViewNode != null && preViewNode.val > cur.val){
                    firstNode = firstNode == null ? preViewNode : firstNode;
                    secondNode = cur;
                }

                // 进行右子树的遍历
                preViewNode = cur;
                cur = cur.right;

            }else{
                // 左子树不为空
                TreeNode node = cur.left;
                while(node.right != null && node.right != cur){
                    node = node.right;
                }

                if(node.right == null){
                    // 未进行链接
                    node.right = cur;

                    // 遍历 cur 的左子树
                    cur = cur.left;
                }else{

                    // 清理索引
                    node.right = null;

                    // 已链接过，说明 cur 的左子树已经遍历完成，要发访问cur
                    // TODO:检测顺序
                    if(preViewNode != null &&  preViewNode.val > cur.val){
                        firstNode = firstNode == null ? preViewNode : firstNode;
                        secondNode = cur;
                    }

                    // 遍历cur.right
                    preViewNode = cur;
                    cur = cur.right;
                }
            }
        }

        // 交换
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;

    }
}
