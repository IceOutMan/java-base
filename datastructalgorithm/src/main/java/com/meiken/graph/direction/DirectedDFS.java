package com.meiken.graph.direction;

import edu.princeton.cs.algs4.Digraph;

/**
 * 有向图
 * 可达性｜深度优先遍历
 * @Author glf
 * @Date 2020/10/8
 */
public class DirectedDFS {

    private boolean[] marked;

    public DirectedDFS(Digraph G, int s){
        marked = new boolean[G.V()];
        dfs(G,s);
    }

    public DirectedDFS(Digraph G,Iterable<Integer> sources){
        marked = new boolean[G.V()];
        for (int s:sources){
            if(!marked[s]){
                dfs(G,s);
            }
        }
    }

    public void dfs(Digraph G,int v){
        marked[v] = true;
        for(int w:G.adj(v)){
            if(!marked[w]){
                dfs(G,w);
            }
        }
    }

    public boolean marked(int w){
        return marked[w];
    }
}
