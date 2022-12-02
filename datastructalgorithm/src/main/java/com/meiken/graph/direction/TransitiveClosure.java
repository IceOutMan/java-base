package com.meiken.graph.direction;


import edu.princeton.cs.algs4.Digraph;

/**
 *  有向图｜顶点对 <v,w> 可达性
 *  图中的每个顶点进行一次深度优先搜索
 * @Author glf
 * @Date 2020/10/13
 */
public class TransitiveClosure {
    private DirectedDFS[] all;

    TransitiveClosure(Digraph G){
        all = new DirectedDFS[G.V()];

        for (int v=0;v<G.V();v++){
            all[v] = new DirectedDFS(G,v);
        }
    }

    boolean reachable(int v,int w){
        return all[v].marked(w);
    }
}
