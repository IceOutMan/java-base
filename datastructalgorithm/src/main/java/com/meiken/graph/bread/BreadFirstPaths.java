package com.meiken.graph.bread;


import edu.princeton.cs.algs4.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 * 广度优先遍历搜索-路径
 */
public class BreadFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;

    private final int s;

    public BreadFirstPaths(Graph G, int s){
        this.s = s;

        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];

        bfs(G,s);
    }

    private void bfs(Graph G,int s){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(s);
        marked[s] = true;

        while (!queue.isEmpty()){

            int v = queue.poll();

            for(int w: G.adj(v)){
                if(!marked[w]){
                    queue.add(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                }
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }

        Stack<Integer> path = new Stack<>();

        int x=v;
        while (x != s){
            path.push(x);
            x = edgeTo[x];
        }

        path.push(s);
        return path;
    }


}
