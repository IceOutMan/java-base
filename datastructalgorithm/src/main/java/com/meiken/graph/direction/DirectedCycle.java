package com.meiken.graph.direction;

import edu.princeton.cs.algs4.Digraph;

import java.util.Stack;

/**
 * 有向图中的环
 * 检测有向图中是否有环 | 深度优先遍历
 * @Author glf
 * @Date 2020/10/12
 */

public class DirectedCycle {

    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;//有向环中的所有顶点(如果存在)
    private boolean[] onStack;// 递归调用链路上的标记：节点 i 开始遍历置为 true，结束遍历 重新设置为false

    public DirectedCycle(Digraph G){
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];

        marked = new boolean[G.V()];

        for(int v=0;v<G.V();v++){
            if(!marked[v]){
                dfs(G,v);
            }
        }
    }

    private void dfs(Digraph G,int v){
        onStack[v] = true;// 遍历一个节点的时候，标记节点在本次调用链的栈标识中
        marked[v] = true;
        // 遍历子节点
        for (int w : G.adj(v)){
            if(this.hasCycle()){
                return;
            }
            if(!marked[w]){
                // 没访问过
                edgeTo[w] = v;
                dfs(G,w);
            }else if(onStack[w]){
                // 访问过 且 在本次调用链路的栈中，存在环
                cycle = new Stack<>();
                for (int x = v;x!=w;x =edgeTo[x]){
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false; // 本节点递归遍历结束，调用链的栈标识清理
    }

    public boolean hasCycle(){
        return cycle != null;
    }

    public Iterable<Integer> cycle(){
        return cycle;
    }

}
