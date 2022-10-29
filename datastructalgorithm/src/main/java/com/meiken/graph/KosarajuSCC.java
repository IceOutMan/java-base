package com.meiken.graph;

import com.meiken.graph.depth.DepthFirstOrder;
import com.meiken.base.graph.Digraph;

/**
 * @Author glf
 * @Date 2020/10/13
 */
public class KosarajuSCC {
    private boolean[] marked;//已访问过的顶点
    private int[] id;//强连通分量的标识符
    private int count;

    public KosarajuSCC(Digraph G){
        marked = new boolean[G.V()];
        id = new int[G.V()];

        DepthFirstOrder order = new DepthFirstOrder(G.reverse());
        //反向图的逆后序，就是正向图的逆序
        for (int s:order.reversePost()){
            if(!marked[s]){
                dfs(G,s);
                count++;
            }
        }
    }

    private void dfs(Digraph G,int v){
        marked[v] = true;
        id[v] = count;
        for (int w:G.adj(v)){
            if(!marked[w]){
                dfs(G,w);
            }
        }
    }

    public boolean stronglyConnected(int v,int w){
        return id[v] == id[w];
    }

    public int id(int v){
        return id[v];
    }
}
