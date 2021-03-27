package com.meiken.graph;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author glf
 * @Date 2020/10/1
 */
public class Graph {
    private final int V; //顶点的数目

    private int E;//边的数目

    private ArrayList<Integer>[] adj;//临接表

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
            //添加一条边
            int v = in.nextInt();
            int w = in.nextInt();
            addEdge(v,w);//连接两个顶点
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(int v,int e){
        adj[v].add(e);
        adj[e].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }



}
