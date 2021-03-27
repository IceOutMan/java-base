package com.meiken.graph;

/**
 * @Author glf
 * @Date 2020/10/1
 */
public class DepthFirstSearch {

    private boolean[] marked;//标记节点是否遍历过
    private int count;

    public DepthFirstSearch(Graph G,int s){
        marked = new boolean[G.V()];
        dfs(G,s);
    }

    private void dfs(Graph G,int v){
        marked[v] = true;
        count++;
        for(int w:G.adj(v)){
            if(!marked[w]){
                dfs(G,w);
            }
        }
    }

    public boolean marked(int w){
        return marked[w];
    }

    public int count(){
        return count;
    }
}
