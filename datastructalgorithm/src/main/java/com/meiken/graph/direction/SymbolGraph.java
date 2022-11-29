package com.meiken.graph.direction;


import edu.princeton.cs.algs4.Graph;

import java.io.*;
import java.util.HashMap;

/**
 * 无向图｜符号图
 * 节点的内容是字符串
 * @Author glf
 * @Date 2020/10/8
 */
public class SymbolGraph {

    private HashMap<String,Integer> st; // 符号名 -> 索引
    private String[] keys;  // 索引 -> 符号名

    private Graph G;    //图

    /**
     * @param fileName  文件路径
     * @param sp    分隔符
     * @throws IOException
     */
    public SymbolGraph(String fileName,String sp) throws IOException {
        st = new HashMap<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line = null;
        // 构造正向索引
        while ((line = in.readLine()) != null ){
            String[] a = line.split(sp);
            for (int i=0;i<a.length;i++){
                if(!st.containsKey(a[i])){
                    st.put(a[i],st.size());
                }
            }
        }

        // 构造反向索引
        keys  = new String[st.size()];
        for (String name : st.keySet()){
            keys[st.get(name)] = name;
        }
        in.close();

        // 第二遍读取，构造图
        G = new Graph(st.size());
        in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        line = null;
        // 构造图
        while ((line = in.readLine()) != null ){
            String[] a = line.split(sp);
            // a[0] -> a[1...n] 之间有连接
            int v =st.get(a[0]);
            for (int i=1;i<a.length;i++){
                G.addEdge(v,st.get(a[i]));
            }
        }
        in.close();
    }

    public boolean contains(String s){
        return st.containsKey(s);
    }

    public int index(String s){
        return st.get(s);
    }

    public String name(int v){
        return keys[v];
    }

    public Graph G(){
        return G;
    }
}
