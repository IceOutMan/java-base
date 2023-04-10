package com.meiken;

import java.nio.charset.StandardCharsets;
import java.util.Stack;

/**
 *  前序遍历
 * @Author glf
 * @Date 2023/4/8
 */
public class PreOrderTraversal {

    public static void main(String[] args) {

        TreeNode root = TreeNode.getSampleTree();
        // 递归遍历
        recursionPreOrderTraversal(root);
        System.out.println("");

        // 使用栈
        stackPreOrderTraversal(root);
        System.out.println("");

        // 莫里斯遍历
        morrisPreOrderTraversal(root);

    }


    public static void printNode(TreeNode root){
        System.out.print(root.val + "  ");
    }


    /**
     * 递归遍历
     */
    public static void recursionPreOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }

        // 中
        printNode(root);
        // 左
        recursionPreOrderTraversal(root.left);
        // 右
        recursionPreOrderTraversal(root.right);

    }

    /**
     * 使用栈
     */
    public static void stackPreOrderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack();

        stack.push(root);

        while(!stack.isEmpty()){

            TreeNode cur = stack.pop();

            // root
            printNode(cur);
            // right 先进栈
            if (cur.right != null) {
                stack.push(cur.right);
            }
            // left 后进栈
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }


    /**
     * 莫里斯遍历
     */
    public static void morrisPreOrderTraversal(TreeNode root){

        // cur 指向当前遍历的节点
        TreeNode cur = root;
        // preNode 指向上一个访问打印的节点
        TreeNode preViewNode = null;

        while(cur != null){

            if(cur.left == null){
                // cur.left 不存在 NULL - root - right
                // 访问 cur, 转到右节点
                printNode(cur);

                preViewNode = cur;
                cur = cur.right;
            }else{
                // cur.left 存在 left - root -right
                TreeNode node = cur.left;
                // cur.left 的最右节点
                while(node.right != null && node.right != cur){
                    node = node.right;
                }


                if(node.right == null){
                    // 未进行线索化, 遍历cur 走到 cur.left
                    printNode(cur);

                    // 线索化
                    node.right = cur;
                    preViewNode = cur;
                    cur = cur.left;

                }else{
                    // 已线索化 说明当前节点 cur 是从 node.right -> cur
                    // 也就是 cur.left 都全遍历完了
                    node.right = null;
                    cur = cur.right;
                }
            }
        }

    }
}
