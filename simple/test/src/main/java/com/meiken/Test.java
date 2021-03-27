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
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author glf
 * @Date 2021/2/21
 */
public class Test {
    public static void main(String[] args) throws InterruptedException, IOException {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};

//        Father base = new Child();
//        base.test();

        BigInteger bigInteger = new BigInteger("111111111111111111111111111111111111");
        System.out.println(bigInteger.toString());


        BigDecimal a = new BigDecimal("11.22323");
        BigDecimal b = new BigDecimal("22.232334234234");
        System.out.println(a.add(b).toString());



    }


    static class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder == null || preorder.length == 0){
            return null;
        }
        if(inorder == null || inorder.length == 0){
            return null;
        }
        return doBuildTree(preorder,0, preorder.length-1, inorder, 0, inorder.length -1);
    }

    public static TreeNode doBuildTree(int[] preorder,int preStart,int preEnd, int[] inorder, int inStart, int inEnd){

        if(inStart > inEnd){
            return null;
        }
        if(preStart > preEnd){
            return null;
        }

        //从前序中第一个找到根
        TreeNode root = new TreeNode(preorder[preStart]);
        root.val = preorder[preStart];
        root.left = root.right = null;

        //中序遍历中找到 root.val
        int inRootIndex = -1;
        for(int i=inStart;i<= inEnd;i++){
            if(inorder[i] == root.val){
                inRootIndex = i;
                break;
            }
        }

        // inStart -> inRootIndex-1, inRootIndex+1 -> inEnd
        // preStart+1 -> preStart + inRootIndex - inStart, preStart + inrootIndex - inStart + 1 -> preEnd

        root.left = doBuildTree(preorder, preStart +1, preStart + inRootIndex - inStart, inorder, inStart, inRootIndex -1);
        root.right = doBuildTree(preorder,  preStart + inRootIndex - inStart + 1, preEnd, inorder, inRootIndex + 1, inEnd);

        return root;
    }
}
