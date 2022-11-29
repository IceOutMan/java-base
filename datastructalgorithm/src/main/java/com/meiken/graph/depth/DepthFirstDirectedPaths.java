package com.meiken.graph.depth;


import edu.princeton.cs.algs4.Digraph;

import java.util.Stack;

/**
 * 有向图 ｜ 深度优先遍历｜路径
 */
public class DepthFirstDirectedPaths {

    private boolean[] marked; // 标记节点是否访问过
    private int[] edgeTo; // 下标对应节点在遍历中的上一个节点 edgeTo[v] = last edge on path from s to v
    private final int s; // source vertex ，开始遍历的节点

    public DepthFirstDirectedPaths(Digraph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        validateVertex(s);;

        // 开始遍历
        dfs(G,s);
    }

    private void dfs(Digraph G, int v){
        // 访问过
        marked[v] = true;
        // do some thing by visited v

        // 递归 v 的相邻节点中
        for(int w : G.adj(v)){
            if(!marked[w]){
                // 记录路径
                edgeTo[w] = v;
                dfs(G,w);
            }
        }
    }

    public boolean hasPathTo(int v){
        validateVertex(v);
        return marked[v];
    }


    public Iterable<Integer> pathTo(int v){
        validateVertex(v);
        if(!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack();
        // 从节点 v 顺着路径 edgeTo 开始往上找
        for(int x=v; x != s; x=edgeTo[v]){
            path.push(x);
        }
        path.push(s);
        return path;
    }





    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
        }
    }


}
