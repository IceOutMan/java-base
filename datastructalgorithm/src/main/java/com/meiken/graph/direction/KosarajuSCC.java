package com.meiken.graph.direction;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

/**
 * 有向图中｜节点是否在一个连通图中
 * Kosaraju 算法
 *
 * @Author glf
 * @Date 2020/10/13
 */
public class KosarajuSCC {
    private boolean[] marked;// 已访问过的顶点
    private int[] id;// 强连通分量的ID, 表示是下表对应的节点在哪一个强连通分量中
    private int count;

    public KosarajuSCC(Digraph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];

        // 所求解图的反向图
        Digraph digraphReverse = G.reverse();
        DepthFirstOrder order = new DepthFirstOrder(digraphReverse);
        // 所求解图的反向图, 对应的逆后序排列 的组成部分
        // <栈顶
        //      [
        //       （
        //          起始节点
        //          中间节点
        //          叶子节点
        //         ）
        //       （
        //          起始节点
        //          中间节点
        //          叶子节点
        //        ）
        //       （
        //          起始节点
        //          中间节点
        //          叶子节点
        //        ）
        //      ]
        // 栈底>
        // 因为有序图进行整张图的遍历时，会由于方向分割成一个个的子集
        Stack<Integer> reversePost = (Stack<Integer>) order.reversePost();
        while (!reversePost.isEmpty()) {
            int s =  reversePost.pop();
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public static void main(String[] args) {
        String cycleFileName = "datastructalgorithm/src/main/resources/directionTinyCG.txt";

        Digraph digraph = new Digraph(new In(cycleFileName));

        KosarajuSCC kosarajuSCC = new KosarajuSCC(digraph);

        for (int v = 0; v < digraph.V(); v++) {
            for (int w = v + 1; w < digraph.V(); w++) {
                if (kosarajuSCC.stronglyConnected(v, w)) {
                    System.out.println("Strongly Content: " + v + "-> " + w);
                } else {
                }
            }
        }
    }
}
