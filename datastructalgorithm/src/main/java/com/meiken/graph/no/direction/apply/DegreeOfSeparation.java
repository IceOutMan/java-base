package com.meiken.graph.no.direction.apply;

import com.meiken.graph.no.direction.BreadFirstPaths;
import com.meiken.graph.no.direction.SymbolGraph;
import edu.princeton.cs.algs4.Graph;

import java.io.*;

/**
 * 间隔的度数
 * @Author glf
 * @Date 2020/10/8
 */
public class DegreeOfSeparation {

    /**
     *
     * @param fileName  数据的文件
     * @param sp 分隔符
     * @param source 起始点
     * @param sink 目标点
     * @throws IOException
     */
    public static void degreeOfSeparation(String fileName,String sp,String source, String sink) throws IOException {
        SymbolGraph sg =  new SymbolGraph(fileName,sp);
        Graph G = sg.G();

        if(!sg.contains(source)){
            System.out.println(source + "not in database.");
            return;
        }

        int s = sg.index(source);
        BreadFirstPaths bfs = new BreadFirstPaths(G,s);

        if(sg.contains(sink)){
            int t = sg.index(sink);

            if(bfs.hasPathTo(t)){
                for (int v:bfs.pathTo(t)){
                    System.out.println("    "+sg.name(v));
                }
            }else{
                System.out.println("Not connected");
            }
        }else{
            System.out.println("Not in database");
        }
    }


    public static void main(String[] args) throws IOException {
        String filePath = "datastructalgorithm/src/main/resources/routes.txt";
        DegreeOfSeparation.degreeOfSeparation(filePath," ","JFK","LAS");
    }
}
