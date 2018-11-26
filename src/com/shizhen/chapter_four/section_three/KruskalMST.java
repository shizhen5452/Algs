package com.shizhen.chapter_four.section_three;

import com.shizhen.chapter_one.UF;
import com.shizhen.util.Constant;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class KruskalMST {
    private Queue<Edge> mst;
    private double weight;

    public KruskalMST(EdgeWeightGraph G) {
        mst = new Queue<>();
        MinPQ<Edge> pq = new MinPQ<>();
        for (Edge e : G.edges()) {
            pq.insert(e);
        }
        UF uf = new UF(G.V());

        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge min = pq.delMin();
            int v = min.either();
            int w = min.other(v);
            if (uf.connected(v, w)) {
                continue;
            }
            uf.connected(v, w);
            mst.enqueue(min);
            weight += min.weight();
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        return weight;
    }

    public static void main(String[] args) {
        EdgeWeightGraph G = new EdgeWeightGraph(new In(Constant.DIR + "tinyEWG.txt"));
        KruskalMST mst = new KruskalMST(G);
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.println(mst.weight());
    }
}
