package com.shizhen.chapter_four.section_three;

import com.shizhen.util.Constant;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.StdOut;

public class PrimMST {

    private boolean[] marked;
    private IndexMinPQ<Double> pq;
    private Edge[] edgeTo;
    private double[] distTo;

    public PrimMST(EdgeWeightGraph G) {
        marked = new boolean[G.V()];
        pq = new IndexMinPQ<>(G.V());
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        distTo[0] = 0.0;
        pq.insert(0, 0.0);
        while (!pq.isEmpty()) {
            visit(G, pq.delMin());
        }
    }

    private void visit(EdgeWeightGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (marked[w]) {
                continue;
            }
            if (e.weight() < distTo[w]) {
                edgeTo[w] = e;
                distTo[w] = e.weight();
                if (pq.contains(w)) {
                    pq.changeKey(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    public Iterable<Edge> edges() {
        Bag<Edge> b = new Bag<>();
        for (Edge edge : edgeTo) {
            b.add(edge);
        }
        return b;
    }

    public double weight() {
        double weight = 0;
        for (double d : distTo) {
            weight += d;
        }
        return weight;
    }

    public static void main(String[] args) {
        EdgeWeightGraph G = new EdgeWeightGraph(new In(Constant.DIR + "tinyEWG.txt"));
        PrimMST mst = new PrimMST(G);
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.println(mst.weight());
    }
}
