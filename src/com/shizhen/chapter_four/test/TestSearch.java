package com.shizhen.chapter_four.test;

import com.shizhen.chapter_four.Graph;
import com.shizhen.chapter_four.Search;
import com.shizhen.util.Constant;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class TestSearch {

    public static void main(String[] args) {
        Graph G = new Graph(new In(Constant.DIR + "tinyG.txt"));
        Search search = new Search(G, 9);
        for (int v = 0; v < G.V(); v++) {
            if (search.marked(v)) {
                StdOut.print(v + " ");
            }
        }
        StdOut.println();

        if (search.count() != G.V()) {
            StdOut.print("NOT ");
        }
        StdOut.println("connected");
    }

}
