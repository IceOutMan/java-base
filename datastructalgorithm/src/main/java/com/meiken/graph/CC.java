package com.meiken.graph;

/**
 * 使用深度优先遍历
 * 每个节点进行一次深度优先遍历，并给遍历过的节点对应的id赋值
 * @Author glf
 * @Date 2020/10/2
 */
public class CC {
    private boolean[] marked;
    private int[] id;//id中存储下标对应的节点在第几个连通图中
    private int count;

    /**
     * @param G
     */
    public CC(Graph G){
        marked = new boolean[G.V()];
        id = new int[G.V()];

        for (int s=0;s<G.V();s++){
            if(!marked[s]){
                dfs(G,s);
            }
        }
    }

    private void dfs(Graph G,int v){
        marked[v] = true;
        id[v] = count;
        for (int w:G.adj(v)){
            if(!marked[w]){
                dfs(G,w);
            }
        }
    }


    //id中
    public boolean connected(int v,int w){
        return id[v] == id[w];
    }

    public int id(int v){
        return id[v];
    }

    public int count(){
        return count;
    }
}
