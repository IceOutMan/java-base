package com.meiken.graph.depth;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @Author glf
 * @Date 2022/6/23
 */
public class DepthTest {


    public static void main(String[] args) {
        // 深度优先搜索遍历
        depthFirstSearchTest();

        // 深度优先搜索遍历 路径
        depthFirstSearchPathTest();
    }

    private static void depthFirstSearchPathTest() {
        String fileName = "/Users/xmly/IdeaProjects/java-base/datastructalgorithm/src/main/java/com/meiken/graph/data/tinyCG.txt";
        Graph graph = new Graph(new In(fileName));
        int s = 3;
        int v= 2;

        DepthFirstPaths depthFirstPaths = new DepthFirstPaths(graph, s);
        System.out.print( v + " TO " + s + " PATH: ");
        for(int vertex : depthFirstPaths.pathTo(v)){
            if (vertex == s) {
                StdOut.print(vertex);
            } else {
            System.out.print( vertex + "-");
            }
        }
    }

    public static void depthFirstSearchTest(){
        String fileName = "/Users/xmly/IdeaProjects/java-base/datastructalgorithm/src/main/java/com/meiken/graph/data/tinyCG.txt";
        Graph graph = new Graph(new In(fileName));

        new DepthFirstSearch(graph, 3);
    }
}
