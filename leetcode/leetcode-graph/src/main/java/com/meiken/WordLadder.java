package com.meiken;

import com.sun.org.apache.xml.internal.utils.ListingErrorHandler;

import java.util.*;

/**
 * 单词接龙 I
 * 按字典 wordList 完成从单词 beginWord 到单词 endWord 转化
 *      一个表示此过程的 转换序列 是形式上像 beginWord -> s1 -> s2 -> ... -> sk 这样的单词序列，并满足：
 *          1. 每对相邻的单词之间仅有单个字母不同。
 *          2. 转换过程中的每个单词 si（1 <= i <= k）必须是字典 wordList 中的单词。注意，beginWord 不必是字典 wordList 中的单词。 sk == endWord
 * 给你两个单词 beginWord 和 endWord ，以及一个字典 wordList 。
 * 请你找出并返回所有从 beginWord 到 endWord 的 最短转换序列中的单词数目 。如果不存在这样的转换序列，返回 0
 *
 * ====================示例1
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 * ====================示例2
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：0
 * 解释：endWord "cog" 不在字典中，所以无法进行转换。
 *
 */
public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 使用邻接表的方式 表示
        List<List<Integer>> edges = new ArrayList<>();
        Map<String, Integer> idMap = new HashMap<>();

        // 开始节点
        addEdge(beginWord, edges, idMap);

        // 添加边
        for(String wordItem : wordList){
            addEdge(wordItem, edges, idMap);
        }

        // endword 不包含在内
        if(!idMap.containsKey(endWord)){
            return 0;
        }

        // 初始化节点到 beginword 的距离，也就是0节点
        int[] dist = new int[edges.size()];
        for(int i=0; i<edges.size(); i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;

        // 遍历图从 0 节点开始
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);

        while(!queue.isEmpty()){
            int curNodeId = queue.poll();

            if(idMap.get(endWord) == curNodeId){
                return dist[curNodeId] / 2 + 1;
            }

            List<Integer> curEdges = edges.get(curNodeId);
            for(int toNodeId : curEdges){

                if(dist[toNodeId] == Integer.MAX_VALUE){
                    // 未访问
                    dist[toNodeId] = dist[curNodeId] + 1;
                    queue.add(toNodeId);
                }else{
                    // 访问过
                }
            }
        }
        return 0;
    }

    // 为 word 添加边
    public static void addEdge(String word, List<List<Integer>> edges, Map<String,Integer> idMap){
        int curId = getId(word, edges, idMap);

       char[] wordCharArr =  word.toCharArray();

       for(int i=0; i<wordCharArr.length; i++){
           char replaceChar = '*';
           char curChar = wordCharArr[i];

           // 替换
           wordCharArr[i] = replaceChar;
           String toWord = new String(wordCharArr);
           int toId = getId(toWord, edges, idMap);

           // add edge
           edges.get(curId).add(toId);
           edges.get(toId).add(curId);

           // 恢复
           wordCharArr[i] = curChar;
       }
    }

    public static int getId(String word, List<List<Integer>> edges, Map<String, Integer> idMap){
        if(idMap.containsKey(word)){
            return idMap.get(word);
        }
        int newId = edges.size();
        idMap.put(word, newId);
        edges.add(new ArrayList<>());

        return newId;
    }


}
