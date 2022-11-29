package com.meiken.graph.depth;

import edu.princeton.cs.algs4.Digraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 有向图｜深度优先搜索遍历｜顶点排序
 * 前序 ｜ 后序｜逆后序
 * @Author glf
 * @Date 2020/10/12
 */
public class DepthFirstOrder {

    private boolean[] marked;

    private Queue<Integer> pre;// 所有顶点的 | 前序排列
    private Queue<Integer> post;// 所有顶点的 | 后序排列
    private Stack<Integer> reversePost;// 所有顶点的｜逆后序排列


    public DepthFirstOrder(Digraph G){
        pre = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new Stack<>();

        marked = new boolean[G.V()];

        for (int v=0;v<G.V();v++){
            if(!marked[v]){
                dfs(G,v);
            }
        }
    }

    private void dfs(Digraph G, int v){
        // 前序遍历｜访问节点时加入到序列中
        pre.add(v);

        marked[v] = true;
        for (int w : G.adj(v)){
            if(!marked[w]){
                dfs(G,w);
            }
        }

        // 后序遍历｜当前节点的所有子节点访问完后，加入当前节点到后序序列中
        post.add(v);
        // 逆后序｜后序是加到连表中，逆后序加入到栈中实现逆
        reversePost.push(v);
    }

    public Iterable<Integer> pre(){
        return pre;
    }

    public Iterable<Integer> post(){
        return post;
    }

    public Iterable<Integer> reversePost(){
        return reversePost;
    }

}
