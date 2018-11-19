package com.shizhen.chapter_four.section_two;

import com.shizhen.util.Constant;
import edu.princeton.cs.algs4.StdOut;

public class Topological {

    private Iterable<Integer> order;

    public Topological(DiGraph G) {
        DirectedCycle cycle = new DirectedCycle(G);
        if (!cycle.hasCycle()) {
            DepthFirstOrder dfo = new DepthFirstOrder(G);
            order = dfo.reversePost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean isDAG() {
        return order != null;
    }

    public static void main(String[] args) {
        SymbolDigraph sg = new SymbolDigraph(Constant.DIR + "jobs.txt", "/");
        Topological top = new Topological(sg.G());
        for (Integer v : top.order()) {
            StdOut.println(sg.name(v));
        }
    }
}
