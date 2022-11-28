package com.meiken.graph.apply.depth;

import edu.princeton.cs.algs4.Graph;

/**
 *  检测图中是否存在环
 *  算法：深度优先搜索遍历
 * @Author glf
 * @Date 2020/10/2
 */
public class Cycle {

    private boolean[] marked;

    private boolean hasCycle;

    public Cycle(Graph G){
        marked = new boolean[G.V()];

        // 图的每个节点，作为起始节点，进行一次深度遍历一次
        // 由于可能存在多个连通分量, 也就是一个图有几个不连接的部分
        for (int s=0;s<G.V();s++){
            if(!marked[s]){
                // 初始遍历节点， v = u
                dfs(G,s,s);
            }
        }
    }

    /**
     * @param G  <v-u>(已经遍历出的连通图)
     * @param v vertex 当前访问的节点, 相当于是一个新的未被访问过的节点
     * @param u up of vertex ，上一个节点 , 相当于是 v 和 已经遍历出的连通图关联起来的节点
     */
    private void dfs(Graph G,int v,int u){
        marked[v] = true;
        // v 的所有的连接节点 ,相当于是 v 的下一个节点
        for (int w : G.adj(v)){
            if(!marked[w]){
                dfs(G,w,v);
            }else if(w != u){
                // w 被访问过， <u-w> 之间连通
                // 相当于是 <v-w> 的边，将 v 重新连接回到了已经边
                hasCycle = true;
            }
        }
    }
}
