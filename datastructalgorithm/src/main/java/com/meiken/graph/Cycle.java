package com.meiken.graph;

/**
 * @Author glf
 * @Date 2020/10/2
 */
public class Cycle {

    private boolean[] marked;

    private boolean hasCycle;

    public Cycle(Graph G){
        marked = new boolean[G.V()];
        for (int s=0;s<G.V();s++){
            if(!marked[s]){
                dfs(G,s,s);
            }
        }
    }

    //u 是 v 的上一个节点
    private void dfs(Graph G,int v,int u){
        marked[v] = true;
        for (int w:G.adj(v)){
            if(!marked[w]){
                dfs(G,w,v);
            }else if(w != u){

            }
        }
    }
}
