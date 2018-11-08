package com.shizhen.chapter_four.section_one;

import com.shizhen.chapter_one.UF;

public class Search {
    private int s;
    private UF uf;

    public Search(Graph G, int s) {
        this.s = s;
        uf = new UF(G.V());
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (uf.connected(v, w)) {
                    continue;
                }
                uf.union(v, w);
            }
        }
    }

    public boolean marked(int v) {
        return uf.connected(s, v);
    }

    public int count() {
        return uf.vCount();
    }
}
