package com.meiken.graph.bread;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @Author glf
 * @Date 2022/6/23
 */
public class BreadTest {


    public static void main(String[] args) {
        // 广度优先搜索遍历
        breadFirstSearchTest();

        // 广度优先搜索遍历 路径
        breadFirstPathsTest();
    }

    private static void breadFirstPathsTest() {
        String fileName = "/Users/xmly/IdeaProjects/java-base/datastructalgorithm/src/main/java/com/meiken/graph/data/tinyCG.txt";
        Graph graph = new Graph(new In(fileName));
        int s = 0;
        int v =4;

        BreadFirstPaths breadFirstPaths = new BreadFirstPaths(graph, s);
        System.out.print(v+" TO "+ s + " PATH : ");
        for (Integer vertex : breadFirstPaths.pathTo(v)) {
            if (vertex == s) {
                StdOut.print(vertex);
            } else {
                System.out.print( vertex + "-");
            }
        }
    }

    public static void breadFirstSearchTest(){
        String fileName = "/Users/xmly/IdeaProjects/java-base/datastructalgorithm/src/main/java/com/meiken/graph/data/tinyCG.txt";
        Graph graph = new Graph(new In(fileName));
        int s = 0;

        new BreadFirstSearch(graph, s);
    }
}
