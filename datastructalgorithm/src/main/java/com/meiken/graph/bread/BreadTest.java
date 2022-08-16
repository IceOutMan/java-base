package com.meiken.graph.bread;

import com.meiken.graph.struct.define.Graph;

/**
 * @Author glf
 * @Date 2022/6/23
 */
public class BreadTest {


    public static void main(String[] args) {
        // 广度优先搜索遍历
        breadFirstSearchTest();
    }

    public static void breadFirstSearchTest(){
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 5);

        graph.addEdge(2, 5);

        graph.addEdge(1, 3);

        graph.addEdge(3, 5);
        graph.addEdge(3, 4);

        graph.addEdge(4, 5);

        new BreadFirstSearch(graph, 0);
    }
}