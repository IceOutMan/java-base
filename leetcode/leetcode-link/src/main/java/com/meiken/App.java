package com.meiken;

import java.util.*;

/**
 * Hello world!
 */
public class App {



    public static List<List<Integer>> edge = new ArrayList<>();
    public static Map<String,Integer> nodeIdMap = new HashMap<>();


    public static void main(String[] args) {
        String[] wordList = new String[]{"hot","dot","dog","lot","log"} ;

        System.out.println(ladderLength("hit", "cog", Arrays.asList(wordList)));
        System.out.println(nodeIdMap);

    }

    public static int ladderLength(String start, String end, List<String> wordList){


        // 初始化
        addWordId(start);
        addEdge(start);

        for(int i=0; i < wordList.size(); i++){
            addWordId(wordList.get(i));
            addEdge(wordList.get(i));
        }

        if(!nodeIdMap.containsKey(end)){
            return 0;
        }

        // 开始节点 -> 各节点的距离
        int[] dist = new int[nodeIdMap.keySet().size()];
        // 初始化
        for(int i=0; i<dist.length; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;

        // 广度优先遍历
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        while(!queue.isEmpty()){
            int x = queue.poll();
            if(x == nodeIdMap.get(end)){
                return  dist[x] /2 + 1;
            }

            // 遍历 x 的相邻节点
            List<Integer> nodeList = edge.get(x);
            for(int i=0; i< nodeList.size(); i++){
                int tempWordId = nodeList.get(i);
                if(dist[tempWordId] == Integer.MAX_VALUE){
                    dist[tempWordId] = dist[x]  +1;
                    queue.offer(tempWordId);
                }
            }
        }

        return 0;
    }

    public static void addEdge(String word){
        // 生成ID
        addWordId(word);

        // 添加边 word -> w * d
        Integer wordId = nodeIdMap.get(word);
        char[] charArr = word.toCharArray();

        for(int i=0; i < charArr.length; i++ ){
            char tmp = charArr[i];

            // 一次一个星
            charArr[i] = '*';

            String starWord = new String(charArr);
            int startWordId = addWordId(starWord);;
            edge.get(wordId).add(startWordId);
            edge.get(startWordId).add(wordId);

            // 恢复
            charArr[i] = tmp;
        }
    }

    public static int addWordId(String word){
        if(nodeIdMap.containsKey(word)){
            return nodeIdMap.get(word);
        }

        int id = nodeIdMap.keySet().size();
        nodeIdMap.put(word, id);
        edge.add(id, new ArrayList<Integer>());

        return id;
    }

}
