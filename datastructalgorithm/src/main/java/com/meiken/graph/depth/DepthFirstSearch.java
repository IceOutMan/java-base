package com.meiken.graph.depth;

import edu.princeton.cs.algs4.Graph;

/**
 * @Author glf
 * @Date 2020/10/1
 */
public class DepthFirstSearch {

    private boolean[] marked; // 标记节点是否遍历过
    private int count;

    /**
     * 深度优先遍历
     * @param G  图
     * @param s 开始节点
     */
    public DepthFirstSearch(Graph G, int s){
        marked = new boolean[G.V()];
        dfs(G,s);
    }

    private void dfs(Graph G,int v){
        marked[v] = true;
        // 遍历到节点V Can Do Something
        System.out.println("search at :" + v);

        count++;
        for(int w:G.adj(v)){
            if(!marked[w]){
                dfs(G,w);
            }
        }
    }

    // 标记 访问过
    public boolean marked(int w){
        return marked[w];
    }

    public int count(){
        return count;
    }
}
