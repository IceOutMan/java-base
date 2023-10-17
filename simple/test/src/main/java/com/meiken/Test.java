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
    public static void premain(String msg) {
        System.out.println(msg);
        System.out.println("HH");
    }

    public static void main(String[] args) throws InterruptedException, IOException {
//        beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]

//        String beginWord = "hit";
//        String endWord = "cog";
//        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");

//        System.out.println(ladderLength(beginWord, endWord, wordList));
        String s = "𫖯";
        System.out.println(s.length());

    }



    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<List<Integer>> edges = new ArrayList<>();
        Map<String, Integer> idMap = new HashMap<>();


        // 第一个节点
        addEdge(beginWord, edges, idMap);
        // 构建图
        for(String word : wordList){
            addEdge(word, edges,idMap);
        }

        // 结果中不包含end 直接返回
        if(!idMap.containsKey(endWord)){
            return 0;
        }

        // 各节点到beginWord的距离
        Integer dist[] = new Integer[edges.size()];
        for(int i=0; i<dist.length; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;


        // 从 beginWord BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while(!queue.isEmpty()){
            Integer id = queue.poll();
            if(Objects.equals(id, idMap.get(endWord))){
                return dist[id] / 2 + 1;
            }

            List<Integer> nodeIds = edges.get(id);
            for(int nodeId : nodeIds){
                // 节点已经边遍历过 跳过
                if(dist[nodeId] != Integer.MAX_VALUE){
                    continue;
                }else {
                    dist[nodeId] = dist[id] + 1;
                    queue.add(nodeId);
                }
            }
        }

        return 0;
    }

    private static void addEdge(String word, List<List<Integer>> edges, Map<String,Integer> idMap ){
        Integer fromId = addWordId(word, edges, idMap);

        char[] charArr =  word.toCharArray();
        for(int i=0;i < charArr.length; i++){
            char iChar = charArr[i];
            charArr[i]= '*';
            String startWord = new String(charArr);
            Integer toId= addWordId(startWord, edges, idMap);
            // 添加边
            // from -> to
            edges.get(fromId).add(toId);
            // to -> from
            edges.get(toId).add(fromId);
            // 恢复
            charArr[i] = iChar;
        }

    }

    private static Integer addWordId(String word, List<List<Integer>> edges, Map<String,Integer> idMap ){
        Integer id = idMap.get(word);

        if(id == null){
            id = edges.size();
            idMap.put(word,id);
            edges.add(new ArrayList<>());
        }

        return id;
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
