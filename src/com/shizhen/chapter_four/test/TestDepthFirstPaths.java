package com.shizhen.chapter_four.test;

import com.shizhen.chapter_four.DepthFirstPaths;
import com.shizhen.chapter_four.Graph;
import com.shizhen.util.Constant;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class TestDepthFirstPaths {

    public static void main(String[] args) {
        Graph G = new Graph(new In(Constant.DIR + "tinyCG.txt"));
        int s = 0;
        DepthFirstPaths search = new DepthFirstPaths(G, s);
        for (int v = 0; v < G.V(); v++) {
            StdOut.print(s + " to " + v + ": ");
            if (search.hasPathTo(v)) {
                for (Integer x : search.pathTo(v)) {
                    if (x == s) {
                        StdOut.print(x);
                    } else {
                        StdOut.print("-" + x);
                    }
                }
            }
            StdOut.println();
        }
    }

}
