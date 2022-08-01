package com.meiken.graph;

import com.meiken.graph.depth.DepthFirstOrder;
import com.meiken.graph.struct.define.Digraph;

/**
 * @Author glf
 * @Date 2020/10/12
 */
public class Topological {

    private Iterable<Integer> order;//顶点的拓扑排序

    public Topological(Digraph G){
        DirectedCycle cyclefinder = new DirectedCycle(G);
        if(!cyclefinder.hasCycle()){
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order(){
        return order;
    }

    public boolean isDAG(){
        return order != null;
    }
}
