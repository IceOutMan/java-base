package com.meiken.graph.struct.define;

import com.meiken.base.Bag;

/**
 * @Author glf
 * @Date 2022/6/23
 * 加权无向图
 */
public class EdgeWeightedGraph {
    private final int V; // 顶点总数
    private int E;  // 边得总数

    private Bag<Edge>[] adj; // 邻接表

    public EdgeWeightedGraph(int V){
        if(V < 0) throw new IllegalArgumentException("Number of vertices must be noo-negative");
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for(int v=0; v < V; v++){
            adj[v] = new Bag<Edge>();
        }
    }

    public EdgeWeightedGraph(int V, int E){
        this(V);

    }


}
