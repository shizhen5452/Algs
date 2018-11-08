package com.shizhen.chapter_four.section_one.exercise;

import com.shizhen.chapter_four.section_one.DepthFirstPaths;
import com.shizhen.chapter_four.section_one.Graph;
import com.shizhen.chapter_four.section_one.SymbolGraph;
import com.shizhen.util.Constant;
import edu.princeton.cs.algs4.StdOut;

/**
 * 4.1.25
 * Will cause stackOverflowError?
 */
public class DegreeOfSeparationDFS {

    public static void main(String[] args) {
        SymbolGraph sg = new SymbolGraph(Constant.DIR + "movies.txt", "/");
        Graph G = sg.G();
        String source = "Bacon, Kevin";
        if (!sg.contains(source)) {
            StdOut.println("no such name : " + source);
            return;
        }

        int v = sg.index(source);
        DepthFirstPaths dfp = new DepthFirstPaths(G, v);
        if (dfp.hasPathTo(v)) {
            for (Integer w : dfp.pathTo(v)) {
                StdOut.println(" "+sg.name(w));
            }
        }
    }

}
