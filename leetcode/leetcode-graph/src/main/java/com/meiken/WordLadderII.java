package com.meiken;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 单词接龙 II
 * <p>
 * 按字典 wordList 完成从单词 beginWord 到单词 endWord 转化
 * 一个表示此过程的 转换序列 是形式上像 beginWord -> s1 -> s2 -> ... -> sk 这样的单词序列，并满足：
 * 1. 每对相邻的单词之间仅有单个字母不同。
 * 2. 转换过程中的每个单词 si（1 <= i <= k）必须是字典 wordList 中的单词。注意，beginWord 不必是字典 wordList 中的单词。 sk == endWord
 * 给你两个单词 beginWord 和 endWord ，以及一个字典 wordList 。
 * 请你找出并返回所有从 beginWord 到 endWord 的 最短转换序列 ，如果不存在这样的转换序列，返回一个空列表。
 * 每个序列都应该以单词列表 [beginWord, s1, s2, ..., sk] 的形式返回。
 * <p>
 * ================= 示例1
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：[["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
 * 解释：存在 2 种最短的转换序列：
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 * "hit" -> "hot" -> "lot" -> "log" -> "cog"
 * <p>
 * ================= 示例2
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：[]
 * 解释：endWord "cog" 不在字典 wordList 中，所以不存在符合要求的转换序列。
 */
public class WordLadderII {

    public static void main(String[] args) {
        String beginWord = "a";
        String endWord = "c";
        List<String> wordList = Arrays.asList("a", "b","c");
//        String beginWord = "hit";
//        String endWord = "cog";
//        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        List<List<String>> ladders = findLadders(beginWord, endWord, wordList);
        System.out.println(JSON.toJSONString(ladders));
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        // 使用邻接表的方式 表示
        Map<String, List<String>> edges = new HashMap<>();

        // 开始节点
        addEdge(beginWord, edges);

        // 添加边
        for (String wordItem : wordList) {
            addEdge(wordItem, edges);
        }

        // endword 不包含在内
        if (!edges.containsKey(endWord)) {
            return new ArrayList<>();
        }

        // 初始化节点到 beginword 的距离，也就是0节点
        Map<String, Integer> distMap = new HashMap<>();

        for (String word : edges.keySet()) {
            distMap.put(word, Integer.MAX_VALUE);
        }
        distMap.put(beginWord, 0);

        // 遍历图从 0 节点开始
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);

        Map<String, List<String>> pathMap = new HashMap<>();

        int targetDeep = 0;
        while (!queue.isEmpty()) {
            String curNodeWord = queue.poll();

            if (endWord == curNodeWord) {
                targetDeep = distMap.get(endWord);
                break;
            }

            List<String> recordLevelList = new ArrayList<>();

            List<String> curEdges = edges.get(curNodeWord);
            for (String toNodeWord : curEdges) {

                if (distMap.get(toNodeWord) == Integer.MAX_VALUE) {
                    recordLevelList.add(toNodeWord);

                    // 未访问过节点
                    distMap.put(toNodeWord, distMap.get(curNodeWord) + 1);
                    queue.add(toNodeWord);

                    // 记录路径
                    if (!pathMap.containsKey(toNodeWord)) {
                        pathMap.put(toNodeWord, new ArrayList<String>());
                    }
                    pathMap.get(toNodeWord).add(curNodeWord);
                } else {
                    // toNode 已经访问s
                    // toNode 的层级是 curNode 的下一层, 也就是 toNode层级比curNode层级大1
                    // 表示 toNode 可以有多个 parent 联通
                    if (distMap.get(toNodeWord) - distMap.get(curNodeWord) == 1) {
                        pathMap.get(toNodeWord).add(curNodeWord);
                    }
                }
            }
//            System.out.println(curNodeWord + " -> " + JSON.toJSONString(recordLevelList));
        }

        List<String> tempList = new ArrayList<>();
        List<List<String>> pathList = new ArrayList<>();
        if (targetDeep != 0) {
            // 还原路径
            tempList.add(endWord);
            recoverPath(beginWord, endWord, pathMap, tempList, pathList, targetDeep, distMap);
        }

        return pathList;
    }

    public static void recoverPath(String startWord, String recoverNodeWord, Map<String, List<String>> pathMap, List<String> tempList, List<List<String>> pathList, int targetDeep, Map<String, Integer> distMap) {
        if (recoverNodeWord == startWord) {
            // 结束
            List<String> tempPath = new ArrayList<>();
            tempPath.addAll(tempList);

            Collections.reverse(tempPath);

            pathList.add(tempPath);
            return;
        }

        List<String> parentWordList = pathMap.get(recoverNodeWord);
//        System.out.println("recover_node:" + recoverNodeWord + "   parent_node:" + parentWordList.toString());
        for (String parentWord : parentWordList) {
            // 小于 end 节点的路径长度, 并且不含 *
            if (distMap.get(parentWord) < targetDeep) {
                if (!parentWord.contains("*")) {
                    tempList.add(parentWord);
                }
                recoverPath(startWord, parentWord, pathMap, tempList, pathList, targetDeep, distMap);
                if (!parentWord.contains("*")) {
                    tempList.remove(tempList.size() - 1);
                }
            } else {

            }
        }
    }

    // 为 word 添加边
    public static void addEdge(String fromWord, Map<String, List<String>> edges) {

        char[] wordCharArr = fromWord.toCharArray();

        for (int i = 0; i < wordCharArr.length; i++) {
            char replaceChar = '*';
            char curChar = wordCharArr[i];

            // 替换
            wordCharArr[i] = replaceChar;
            String toWord = new String(wordCharArr);

            // add edge
            doAddEdge(fromWord, toWord, edges);

            // 恢复
            wordCharArr[i] = curChar;
        }
    }

    public static void doAddEdge(String fromWord, String toWord, Map<String, List<String>> edges) {

        if (!edges.containsKey(fromWord)) {
            edges.put(fromWord, new ArrayList<>());
        }

        if (!edges.containsKey(toWord)) {
            edges.put(toWord, new ArrayList<>());
        }

        if (!edges.get(fromWord).contains(toWord)) {
            edges.get(fromWord).add(toWord);
        }

        if (!edges.get(toWord).contains(fromWord)) {
            edges.get(toWord).add(fromWord);
        }
    }

}
