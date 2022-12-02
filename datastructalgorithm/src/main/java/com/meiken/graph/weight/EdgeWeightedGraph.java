package com.meiken.graph.weight;

import edu.princeton.cs.algs4.Bag;

/**
 * 加权｜无向图
 * @Author glf
 * @Date 2022/12/1
 */
public class EdgeWeightedGraph {

    private final int V; // 顶点总数
    private int E; // 边的总数
    private Bag<Edge>[] adj; // 邻接表

    public EdgeWeightedGraph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[])new Bag[V];
        for(int v=0; v < V; v++){
            adj[v] = new Bag<Edge>();

        }
    }


}
