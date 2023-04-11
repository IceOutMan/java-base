package com.meiken.traversal;


import com.meiken.TreeNode;

import java.util.Stack;

/**
 * @Author glf
 * @Date 2023/4/8
 */
public class PostOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getSampleTree();

        // 递归遍历
        recursionPostOrderTraversal(root);
        System.out.println();

        // 用栈遍历
        stackPostOrderTraversal(root);
        System.out.println();

        // 莫里斯遍历
        morrisPostOrderTraversal(root);
        System.out.println();

    }

    public static void printNode(TreeNode root) {
        System.out.print(root.val + "  ");
    }


    /**
     * 递归遍历
     */
    public static void recursionPostOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        // 左 右 中
        recursionPostOrderTraversal(root.left);
        recursionPostOrderTraversal(root.right);
        printNode(root);

    }

    /**
     * 使用栈
     */
    public static void stackPostOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode preViewNode = null;

        do {
            // cur 当前指向的节点
            // cur 开始进栈，沿着 cur.left 直到 most left
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 用来记录本轮遍历的前驱节点
            preViewNode = null;
            while (!stack.isEmpty()) {
                cur = stack.pop();

                // 一个节点没有右子树，preNode 为 null 也匹配
                if (preViewNode == cur.right) {
                    // 上一个遍历的节点是右节点，则遍历当前节点
                    printNode(cur);
                    preViewNode = cur;
                } else {
                    // 重新进栈 cur
                    stack.push(cur);
                    cur = cur.right;
                    // 重新开始新的一轮遍历
                    break;
                }
            }
        } while (!stack.isEmpty());

    }


    /**
     * 莫里斯遍历
     */
    public static void morrisPostOrderTraversal(TreeNode root) {

        TreeNode preCurNode = null;
        TreeNode cur = root;

        while (cur != null) {

            if (cur.left == null) {
                // left 为 null， 就去看 right
                preCurNode = cur;
                cur = cur.right;

            } else {
                // left 子树不为空
                TreeNode node = cur.left;
                while (node.right != null && node.right != cur) {
                    node = node.right;
                }

                if(node.right == null){
                    // 没有建立链接, 建立链接
                    node.right = cur;

                    preCurNode = cur;
                    cur = cur.left;

                }else{
                    // 已经建立链接， cur 是从 cur.left 的最右节点走来的
                    // 需要遍历 cur.left -> preNode [逆序]
                    visitReverse(cur.left, preCurNode);

                    node.right = null;
                    preCurNode = cur;
                    cur = cur.right;
                }

            }
        }


        TreeNode node = root;
        while(node.right != null){
            node = node.right;
        }

        // 遍历从 root -> most right
        visitReverse(root, node);
    }


    private static void reverse(TreeNode from, TreeNode to){
        if(from == to){
            return;
        }
        TreeNode preCur = from;
        TreeNode cur = preCur.right;
        TreeNode curNext = null;

        while(preCur != to){
            curNext = cur.right;

            cur.right = preCur;

            preCur = cur;
            cur = curNext;
        }

    }

    private static void visitReverse(TreeNode from, TreeNode to){

        reverse(from,to);

        // print to -> from
        TreeNode p = to;
        while(true){
            printNode(p);
            if(p==from){
                break;
            }
            p = p.right;
        }

        reverse(to,from);
    }
}
