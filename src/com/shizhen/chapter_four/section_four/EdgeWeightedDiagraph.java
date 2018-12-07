package com.shizhen.chapter_four.section_four;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class EdgeWeightedDiagraph {

    private int V;//顶点总数
    private int E;//边的总数
    private Bag<DirectedEdge>[] adj;//邻接表

    public EdgeWeightedDiagraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public EdgeWeightedDiagraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(new DirectedEdge(v, w, weight));
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    //将e添加到该有向图中
    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        E++;
    }

    //从v指出的边
    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    //该有向图中的所有边
    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> bag = new Bag<>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj[v]) {
                bag.add(e);
            }
        }
        return bag;
    }

}
