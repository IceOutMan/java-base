package com.meiken.graph.bread;

import com.meiken.graph.struct.define.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author glf
 * @Date 2020/10/1
 * 广度优先遍历搜索
 */
public class BreadFirstSearch {

    private boolean[] marked;
    private int count;

    /**
     * @param G 图
     * @param s 开始节点
     */
    public BreadFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        bfs(G, s);
    }

    public void bfs(Graph G, int s) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        marked[s] = true;
        count++;
        // 遍历到节点 Can Do Something
        System.out.println("search at: " + s);

        while (!queue.isEmpty()) {
            int v = queue.poll();

            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    queue.add(w);

                    marked[w] = true;
                    count++;
                    // 遍历到节点 Can Do Something
                    System.out.println("search at: " + w);
                }
            }
        }
    }


    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }
}
