package com.meiken.graph.no.direction.apply;


import edu.princeton.cs.algs4.Graph;

/**
 * 连通分量 - 判断图中两个节点是否连通 （v ... w)
 *
 *  使用深度优先遍历
 * 每个节点进行一次深度优先遍历，并给遍历过的节点对应的id赋值
 * @Author glf
 * @Date 2020/10/2
 */
public class CC {
    // 标记下标对应的节点是否已经访问过
    private boolean[] marked;
    // id中存储下标对应的节点对应的连通图ID
    private int[] id;
    private int count;

    /**
     * @param G
     */
    public CC(Graph G){
        marked = new boolean[G.V()];
        id = new int[G.V()];

        // 图的每个节点，作为起始节点，进行一次深度遍历一次
        // 由于可能存在多个连通分量, 也就是一个图有几个不连接的部分
        for (int s=0;s<G.V();s++){
            if(!marked[s]){ //  没有被访问过，说明是一个新的连通分量，遍历完，count++，也就是连通分量的ID增加1
                dfs(G,s);
                count++;
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


    /**
     * 节点v和节点w的连通分量ID一致，表示是连通
     * @param v
     * @param w
     * @return
     */
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
