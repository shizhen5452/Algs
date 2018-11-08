package com.shizhen.chapter_four.section_one.test;

import com.shizhen.chapter_four.section_one.Graph;
import com.shizhen.chapter_four.section_one.SymbolGraph;
import com.shizhen.util.Constant;
import edu.princeton.cs.algs4.StdOut;

public class TestSymbolGraph {

    public static void main(String[] args) {
        SymbolGraph sg = new SymbolGraph(Constant.DIR + "movies.txt", "/");
        Graph G = sg.G();
        for (int v = 0; v < G.V(); v++) {
            StdOut.println(sg.name(v));
            for (Integer w : G.adj(v)) {
                StdOut.println("  "+sg.name(w));
            }
        }
    }

}
