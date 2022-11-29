package com.meiken.graph.no.direction;

import com.meiken.graph.direction.DirectedDFS;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

import java.util.Stack;


/**
 * 有向图
 *  广度优先遍历 ｜路径
 */
public class BreadthFirstDirectedPaths {

    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;
    private int[] edgeTo;  // edgeTo[v] ,  s -> v 路径中，经过 v 的上一节点
    private int[] distTo; // distTo[v] ,  s -> v 的最短距离

    public BreadthFirstDirectedPaths(Digraph G, int s){
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];
        // 初始化距离
        for(int v=0; v < G.V(); v++){
            distTo[v] = INFINITY;
        }

        validateVertex(s);
        // 广度优先遍历，s开
        bfs(G,s);
    }

    private void bfs(Digraph G, int s){
       Queue<Integer> q =  new Queue<Integer>();

       // 进队列 -> 访问
       q.enqueue(s);
       marked[s] = true;
       distTo[s] = 0; // 初始点到自身距离为0

       while (!q.isEmpty()){
           int v = q.dequeue();
           for(int w : G.adj(v)){
               if(!marked[w]){
                   marked[w] = true;

                   edgeTo[w] = v;
                   distTo[w] = distTo[v] + 1;
                   q.enqueue(w);
               }
           }
       }
    }

    private void bfs(Digraph G, Iterable<Integer> sources){
        Queue<Integer> q = new Queue<Integer>();
        for (int s : sources) {
            marked[s] = true;
            distTo[s] = 0;
            q.enqueue(s);
        }
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }

    }

    public boolean hasPathTo(int v){
        validateVertex(v);
        return marked[v];
    }

    public int distTo(int v){
        validateVertex(v);
        return distTo[v];
    }



    public Iterable<Integer> pathTo(int v){
        validateVertex(v);

        if(!hasPathTo(v)) {
            return null;
        }

        Stack<Integer> path = new Stack<>();
        int x;
        for(x=v; distTo[x] != 0; x=edgeTo[x]){
           path.push(x);
        }
        path.push(x);
        return path;
    }

    private void validateVertex(int v){
        int V= marked.length;
        if(v < 0 || v >= V){
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
        }
    }

    private void validateVertices(Iterable<Integer> vertices) {
        if (vertices == null) {
            throw new IllegalArgumentException("argument is null");
        }
        int V = marked.length;
        int count = 0;
        for (Integer v : vertices) {
            count++;
            if (v == null) {
                throw new IllegalArgumentException("vertex is null");
            }
            validateVertex(v);
        }
        if (count == 0) {
            throw new IllegalArgumentException("zero vertices");
        }
    }

    public static void main(String[] args) {
        String fileName = "datastructalgorithm/src/main/resources/directionTinyCG.txt";

        Digraph digraph = new Digraph( new In(fileName));
        int s = 0;
        BreadthFirstDirectedPaths breadthFirstDirectedPaths = new BreadthFirstDirectedPaths(digraph, s);

        for(int i = 0; i< digraph.V(); i++){
            if(breadthFirstDirectedPaths.hasPathTo(i)){
                System.out.print("PATH " + s + " ->" + i + " exist : ");
                for(int w : breadthFirstDirectedPaths.pathTo(i)){
                    if( w == s ){
                        System.out.println(w);
                    }else {
                        System.out.print(w + "-");
                    }
                }
            }else{
                System.out.println(s + " ->" + i + " NO PATH");
            }
        }

    }


}
