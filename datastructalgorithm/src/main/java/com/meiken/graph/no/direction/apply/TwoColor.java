package com.meiken.graph.no.direction.apply;

import edu.princeton.cs.algs4.Graph;

/**
 * 双色问题｜二分图问题
 * @Author glf
 * @Date 2020/10/2
 */
public class TwoColor {
    // 节点是否访问过的数组
    private boolean[] marked;
    // 节点颜色的数组
    private boolean[] color;

    private boolean isTwoColorable = true;

    public TwoColor(Graph G){
        marked = new boolean[G.V()];
        color = new boolean[G.V()];

        for(int s = 0;s<G.V();s++){
            if(!marked[s]){
                dfs(G,s);
            }
        }
    }

    /**
     * @param G  图
     * @param v  当前正在访问的之前未被访问过的节点 vertex
     */
    private void dfs(Graph G,int v){
        marked[v] = true;
        // 遍历 v 的关联节点
        for (int w : G.adj(v)){
            if(!marked[w]){
                color[w] = !color[v];
                dfs(G,w);
            }else if(color[w] == color[v]){
                // 被访问过，颜色v=w
                isTwoColorable = false;
            }
        }
    }

    public boolean isBipartite(){
        return isTwoColorable;
    }
}
