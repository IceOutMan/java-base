package com.meiken.graph.direction;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

/**
 * 拓扑排序
 * 仅当一幅图是无环时它才能进行拓扑排序
 * @Author glf
 * @Date 2020/10/12
 */
public class Topological {

    private Iterable<Integer> order;// 顶点的拓扑排序
    private int[] rank;  // rank[v] = rank of vertex v in order | 定点在序列中位置

    public Topological(Digraph G){

        DirectedCycle cyclefinder = new DirectedCycle(G);
        // 没有环 -> 才进行拓扑排序
        if(!cyclefinder.hasCycle()){
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost(); // 逆后序，就是顺序
            rank = new int[G.V()];
            int i=0;
            for(int v : order){
                rank[v] = i++;
            }
        }
    }

    public Iterable<Integer> order(){
        return order;
    }

    public boolean hasOrder() {
        return order != null;
    }


    /**
     * 是否是拓扑排序
     * @return
     */
    public boolean isDAG(){
        return order != null;
    }

    public int rank(int v) {
        validateVertex(v);
        if (hasOrder()) {
            return rank[v];
        } else {
            return -1;
        }
    }

    private void validateVertex(int v) {
        int V = rank.length;
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
        }
    }

    public static void main(String[] args) {
        String fileName = "datastructalgorithm/src/main/resources/directionNoCycleTinyCG.txt";

        Digraph digraph = new Digraph(new In(fileName));
        int s = 0;
        int v =5;

        Topological topological = new Topological(digraph);
        System.out.print("Topological order: ");
        Stack<Integer> order = (Stack<Integer>) topological.order();
        while(!order.isEmpty()){
            int x = order.pop();
            System.out.print(x + "  ");
        }
    }

}
