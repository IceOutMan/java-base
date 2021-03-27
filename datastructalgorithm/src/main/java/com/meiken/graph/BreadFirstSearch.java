package com.meiken.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author glf
 * @Date 2020/10/1
 */
public class BreadFirstSearch {

    private boolean[] marked;
    private int count;

    public BreadFirstSearch(Graph G,int s){
        marked = new boolean[G.V()];
        bfs(G,s);
    }

    public void bfs(Graph G,int s){
        marked[s] =true;
        count++;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()){
            int v = queue.poll();
            for (int w:G.adj(v)){
                if(!marked[w]){
                    marked[w] = true;
                    queue.add(w);
                    count++;
                }
            }
        }
    }

    public boolean marked(int w){
        return marked[w];
    }

    public int count(){
        return count;
    }
}
