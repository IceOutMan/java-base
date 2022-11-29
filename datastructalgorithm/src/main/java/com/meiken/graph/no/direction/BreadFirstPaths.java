package com.meiken.graph.no.direction;


import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;

import java.net.URL;
import java.nio.file.FileSystem;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 * 广度优先遍历搜索-路径
 */
public class BreadFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;

    private final int s;

    public BreadFirstPaths(Graph G, int s){
        this.s = s;

        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];

        bfs(G,s);
    }

    private void bfs(Graph G,int s){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(s);
        marked[s] = true;

        while (!queue.isEmpty()){

            int v = queue.poll();

            for(int w: G.adj(v)){
                if(!marked[w]){
                    queue.add(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                }
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }

        Stack<Integer> path = new Stack<>();

        int x=v;
        while (x != s){
            path.push(x);
            x = edgeTo[x];
        }

        path.push(s);
        return path;
    }

    public static void main(String[] args) {
        String fileName = "datastructalgorithm/src/main/resources/noDirectionTinyCG.txt";

        Graph graph = new Graph(new In(fileName));
        int s = 0;
        int v =5;

        BreadFirstPaths breadFirstPaths = new BreadFirstPaths(graph, s);
        System.out.print(v+" TO "+ s + " PATH : ");
        for (Integer vertex : breadFirstPaths.pathTo(5)) {
            if (vertex == s) {
                System.out.print(vertex);
            } else {
                System.out.print( vertex + "-");
            }
        }
    }


}
