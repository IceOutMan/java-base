package com.meiken.graph.no.direction;

import edu.princeton.cs.algs4.Graph;

import java.util.Stack;

/**
 * @Author glf
 * @Date 2020/10/2
 * 深度优先遍历 - 路径跟踪
 */
public class DepthFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;

    private final int s;//起点

    public DepthFirstPaths(Graph G, int s){
        this.s = s;

        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];

        dfs(G,s);
    }

    private void dfs(Graph G,int v){
        marked[v] = true;

        for (int w: G.adj(v)){
            if(!marked[w]){
                // 遍历关联节点时，记录下edgeTo
                edgeTo[w] = v;
                dfs(G,w);
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
