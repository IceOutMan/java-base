package com.meiken.graph.struct.define;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *  图
 */
public class Graph {
    private final int V; // 顶点的数目
    private int E; // 边的数目
    private ArrayList<Integer>[] adj;//邻接表

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = new ArrayList[V];
        for(int v=0;v<V;v++){
            adj[v] = new ArrayList<>();
        }
    }

    public Graph(Scanner in){
        this(in.nextInt());

        int E = in.nextInt();
        for(int i=0;i<E;i++){
            // 添加一条边
            int v = in.nextInt();
            int w = in.nextInt();
            addEdge(v,w); // 连接两个顶点
        }
    }

    // 获取顶点数
    public int V(){
        return V;
    }

    // 获取边数
    public int E(){
        return E;
    }

    public void addEdge(int v,int w){
        adj[v].add(w); // 将 w 添加到 v 的链表中
        adj[w].add(v); // 将 v 添加到 w 的链表中
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }



}
