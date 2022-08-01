package com.meiken.graph.struct.define;

/**
 * @Author glf
 * @Date 2022/6/23
 * 加权边得定义，边可以有权重
 */
public class Edge implements Comparable<Edge>{
    private final int v; // 顶点之一
    private final int w;  // 另外一个顶点
    private double weight;


    public Edge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight(){
        return this.weight;
    }

    public int either(){
        return v;
    }

    public int other(int vertex){
        if( vertex == v) return w;
        else if(vertex == w) return v;
        else throw  new RuntimeException("Inconsistent edge");
    }

    @Override
    public int compareTo(Edge that) {
        if(this.weight() < that.weight()) return -1;
        else if(this.weight() > that.weight()) return 1;
        else return 0;
    }
}
