package com.meiken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author glf
 * @Date 2021/2/21
 */
public class Test {
    public static void main(String[] args) throws InterruptedException, IOException {
        String s = "aaabaa";
        System.out.println(minCut(s));
    }


    public static int minCut(String s) {
        int len = s.length();
        int f[] = new int[len+1];
        boolean p[][] = new boolean[len][len];
        // init
        for(int i=0;i<=len; i++){
            f[i] = len - 1 - i;
        }

        for(int i=len-1; i>= 0; i--){
            for(int j=i; j<len; j++){
                if(s.charAt(i) == s.charAt(j) && (j-i<2 || p[i+1][j-1])){
                    p[i][j] = true;
                    f[i] = f[i] < f[j+1] + 1 ? f[i] : f[j+1] + 1;
                }
            }
        }
        return f[0];
    }




        static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length == 0) {
            return null;
        }
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        return doBuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode doBuildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

        if (inStart > inEnd) {
            return null;
        }
        if (preStart > preEnd) {
            return null;
        }

        //从前序中第一个找到根
        TreeNode root = new TreeNode(preorder[preStart]);
        root.val = preorder[preStart];
        root.left = root.right = null;

        //中序遍历中找到 root.val
        int inRootIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inRootIndex = i;
                break;
            }
        }

        // inStart -> inRootIndex-1, inRootIndex+1 -> inEnd
        // preStart+1 -> preStart + inRootIndex - inStart, preStart + inrootIndex - inStart + 1 -> preEnd

        root.left = doBuildTree(preorder, preStart + 1, preStart + inRootIndex - inStart, inorder, inStart, inRootIndex - 1);
        root.right = doBuildTree(preorder, preStart + inRootIndex - inStart + 1, preEnd, inorder, inRootIndex + 1, inEnd);

        return root;
    }
}
