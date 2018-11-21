package com.shizhen.chapter_four.section_three;

import com.shizhen.util.Constant;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class LazyPrimMST {

    private boolean[] marked;
    private Queue<Edge> mst;
    private MinPQ<Edge> pq;

    public LazyPrimMST(EdgeWeightGraph G) {
        marked = new boolean[G.V()];
        mst = new Queue<>();
        pq = new MinPQ<>();

        visit(G, 0);
        while (!pq.isEmpty()) {
            Edge min = pq.delMin();
            int v = min.either();
            int w = min.other(v);
            if (marked[v] && marked[w]) {
                continue;
            }
            mst.enqueue(min);
            if (!marked[v]) {
                visit(G, v);
            }
            if (!marked[w]) {
                visit(G, w);
            }
        }
    }

    private void visit(EdgeWeightGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            if (!marked[e.other(v)]) {
                pq.insert(e);
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        double weight = 0;
        for (Edge e : mst) {
            weight += e.weight();
        }
        return weight;
    }

    public static void main(String[] args) {
        EdgeWeightGraph G = new EdgeWeightGraph(new In(Constant.DIR + "tinyEWG.txt"));
        LazyPrimMST mst = new LazyPrimMST(G);
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.println(mst.weight());
    }
}
