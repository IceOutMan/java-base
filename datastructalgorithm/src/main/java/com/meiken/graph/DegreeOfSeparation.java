package com.meiken.graph;

import java.io.*;

/**
 * @Author glf
 * @Date 2020/10/8
 */
public class DegreeOfSeparation {

    public static void degreeOfSeparation(String fileName,String sp,String source) throws IOException {
        SymbolGraph sg =  new SymbolGraph(fileName,sp);
        Graph G = sg.G();

        if(!sg.contains(source)){
            System.out.println(source + "not in database.");
            return;
        }

        int s = sg.index(source);
        BreadFirstPaths bfs = new BreadFirstPaths(G,s);

        String sink = "LAS";
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
        DegreeOfSeparation.degreeOfSeparation(filePath," ","JFK");
    }
}
