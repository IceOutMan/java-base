package com.meiken.builder;

import com.meiken.TreeNode;
import com.meiken.traversal.InOrderTraversal;
import com.meiken.traversal.PostOrderTraversal;
import com.meiken.traversal.PreOrderTraversal;

/**
 *                1
 *             /    \
 *           2       3
 *          / \     / \
 *         4   5   6  7
 *            / \
 *           8   9
 *
 *  pre : 1 2 4 5 8 9 3 6 7
 *  in  : 4 2 8 5 9 1 6 3 7
 *  post: 4 8 9 5 2 6 7 3 1
 */
public class PreAndInOrderBuildTree {

    public static void main(String[] args) {
        int[] preOrder  = new int[]{1, 2, 4, 5, 8, 9, 3, 6, 7};
        int[] inOrder   = new int[]{4, 2, 8, 5, 9, 1, 6, 3, 7};

        int preI = 0;
        int preJ = preOrder.length-1;
        int inI = 0;
        int inJ = inOrder.length -1;
        TreeNode root = preAndInOrderBuildTree(preOrder, preI, preJ, inOrder, inI, inJ);


        PreOrderTraversal.recursionPreOrderTraversal(root);
        System.out.println("");
        InOrderTraversal.recursionInOrderTraversal(root);
        System.out.println("");
        PostOrderTraversal.recursionPostOrderTraversal(root);


    }


    public static TreeNode preAndInOrderBuildTree(int[] preOrder,int preI, int preJ, int[] inOrder, int inI, int inJ){
        if(preI > preJ){
            return null;
        }

        TreeNode root = new TreeNode(preOrder[preI]);

        // 找到 root 在 inOrder 中的位置
        int rootIndexInOrder = findRootIndexFromInOrder(inOrder, inI, inJ, root.val);
        // 找到左
        int leftTreeLen = rootIndexInOrder - inI ;
        int leftTreeStart = preI + 1;
        int leftTreeEnd = preI + leftTreeLen;

        TreeNode left = preAndInOrderBuildTree(preOrder, leftTreeStart, leftTreeEnd, inOrder, inI, rootIndexInOrder -1);


        // 找到右
        int rightTreeLen = inJ - rootIndexInOrder ;
        int rightTreeStart = leftTreeEnd + 1;
        int rightTreeEnd = leftTreeEnd + rightTreeLen;

        TreeNode right = preAndInOrderBuildTree(preOrder, rightTreeStart, rightTreeEnd, inOrder, rootIndexInOrder+1, inJ);

        root.left = left;
        root.right = right;

        return root;
    }

    public static int findRootIndexFromInOrder(int[] inOrder, int inI, int inJ, int rootVal){
        for(int k= inI; k<= inJ; k++){
            if(inOrder[k] == rootVal){
               return k ;
            }
        }
        return -1;
    }
}
