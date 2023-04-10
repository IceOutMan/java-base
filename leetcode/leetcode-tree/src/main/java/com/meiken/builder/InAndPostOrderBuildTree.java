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
public class InAndPostOrderBuildTree {

    public static void main(String[] args) {
        int[] inOrder   = new int[]{4, 2, 8, 5, 9, 1, 6, 3, 7};
        int[] postOrder = new int[]{4, 8, 9, 5, 2, 6, 7, 3, 1};

        int inI = 0;
        int inJ = inOrder.length -1;
        int postI = 0;
        int postJ = postOrder.length - 1;

        TreeNode root = inAndPostOrderBuildTree(inOrder, inI, inJ, postOrder, postI, postJ);

        PreOrderTraversal.recursionPreOrderTraversal(root);
        System.out.println("");
        InOrderTraversal.recursionInOrderTraversal(root);
        System.out.println("");
        PostOrderTraversal.recursionPostOrderTraversal(root);

    }


    public static TreeNode inAndPostOrderBuildTree(int[] inOrder, int inI, int inJ, int[] postOrder, int postI, int postJ){

        if(postI > postJ){
            return null;
        }

        TreeNode root = new TreeNode(postOrder[postJ]);

        // 找到 root 在 inOrder 中的位置
        int rootIndexFromInOrder = findRootIndexFromInOrder(inOrder, inI, inJ, root.val);

        // right
        // [inI, rootIndex, inJ]
        int rightTreeLen = inJ - rootIndexFromInOrder ;
        int postRightTreeEnd = postJ -1;
        int postRightTreeStart = postRightTreeEnd - rightTreeLen + 1;
        TreeNode right = inAndPostOrderBuildTree(inOrder, rootIndexFromInOrder+1, inJ, postOrder, postRightTreeStart, postRightTreeEnd);


        // left
        // [inI, rootIndex, inJ]
        int leftTreeLen = rootIndexFromInOrder - inI;
        int postLeftTreeEnd = postRightTreeStart -1;
        int postLeftTreeStart = postLeftTreeEnd - leftTreeLen + 1;
        TreeNode left = inAndPostOrderBuildTree(inOrder, inI, rootIndexFromInOrder-1, postOrder, postLeftTreeStart, postLeftTreeEnd);

        root.left = left;
        root.right = right;

        return root;
    }

    public static int findRootIndexFromInOrder(int[] inOrder, int inI, int inJ, int rootVal){

        for(int k= inI; k <= inJ; k++){
            if(inOrder[k] == rootVal){
                return k;
            }
        }

        return -1;

    }
}
