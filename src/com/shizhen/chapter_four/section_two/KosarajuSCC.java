package com.shizhen.chapter_four.section_two;

import com.shizhen.util.Constant;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class KosarajuSCC {
    private boolean[] marked;//已访问过的顶点
    private int[] id;//强连通分量的标识符
    private int count;//强连通分量的数量

    public KosarajuSCC(DiGraph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        DepthFirstOrder dfo = new DepthFirstOrder(G.reverse());
        for (Integer s : dfo.reversePost()) {
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(DiGraph G, Integer v) {
        marked[v] = true;
        id[v] = count;
        for (Integer w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        KosarajuSCC kosarajuSCC = new KosarajuSCC(new DiGraph(new In(Constant.DIR + "tinyDG.txt")));
        StdOut.println(kosarajuSCC.count() + " components");

    }
}
