package com.meiken;

import org.w3c.dom.NodeList;

import java.util.List;
import java.util.Stack;

/**
 * @Author glf
 * @Date 2023/4/8
 */
public class InOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getSampleTree();
        // 递归遍历
        recursionInOrderTraversal(root);
        System.out.println("");

        // 使用栈遍历
        stackInOrderTraversal(root);
        System.out.println("");

        // 莫里斯遍历
        morrisInOrderTraversal(root);

    }


    public static void printNode(TreeNode root) {
        System.out.print(root.val + "  ");
    }


    /**
     * 递归遍历
     */
    public static void recursionInOrderTraversal(TreeNode root) {
        // 左 中 右
        if (root == null) {
            return;
        }

        recursionInOrderTraversal(root.left);
        printNode(root);
        recursionInOrderTraversal(root.right);

    }

    /**
     * 使用栈
     */
    public static void stackInOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;

        while (!stack.isEmpty() || cur != null) {

            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                // cur 沿着 left 走到底了
                cur = stack.pop();
                // 访问
                printNode(cur);
                // 右子树
                cur = cur.right;
            }
        }
    }


    /**
     * 莫里斯遍历
     */
    public static void morrisInOrderTraversal(TreeNode root) {

        TreeNode cur = root;
        TreeNode preNode = null;


        while(cur != null){

            if(cur.left == null){
                // 访问 cur
                printNode(cur);
                preNode = cur;
                cur = cur.right;
            }else{
                // cur 存在 left 子树
                TreeNode node = cur.left;
                while(node.right != null && node.right != cur){
                    node = node.right;
                }

                if(node.right == null){
                    // 没建立索引, 建立索引
                    node.right = cur;

                    // 访问子树
                    cur = cur.left;
                }else{
                    // 已建立索引，从 cur.left 的最右节点走到了 cur
                    node.right = null;
                    // print(cur); cur=cur.right
                    printNode(cur);
                    preNode = cur;
                    cur = cur.right;
                }
            }

        }


    }


}
