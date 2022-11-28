package com.meiken.graph;


import edu.princeton.cs.algs4.Digraph;

/**
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
