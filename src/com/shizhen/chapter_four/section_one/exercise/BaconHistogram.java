package com.shizhen.chapter_four.section_one.exercise;

import com.shizhen.chapter_four.section_one.BreadthFirstPaths;
import com.shizhen.chapter_four.section_one.Graph;
import com.shizhen.chapter_four.section_one.SymbolGraph;
import com.shizhen.util.Constant;
import edu.princeton.cs.algs4.StdOut;

/**
 * 4.1.22
 */
public class BaconHistogram {

    public static void main(String[] args) {
        SymbolGraph sg = new SymbolGraph(Constant.DIR + "movies.txt", "/");
        Graph G = sg.G();
        String source = "Bacon, Kevin";
        if (!sg.contains(source)) {
            StdOut.println("no such name : " + source);
            return;
        }
        BreadthFirstPaths bfp = new BreadthFirstPaths(G, sg.index(source));


        int MAX_BACON = 100;
        int[] hist = new int[MAX_BACON + 1];
        for (int v = 0; v < G.V(); v++) {
            int dist = Math.min(MAX_BACON, bfp.distTo(v));
            hist[dist]++;
        }
        for (int i = 0; i < MAX_BACON; i += 2) {
            if (hist[i] == 0) {
                break;
            }
            StdOut.printf("%3d %8d\n", i / 2, hist[i]);
        }
        StdOut.printf("Inf %8d\n", hist[MAX_BACON]);
    }

}
