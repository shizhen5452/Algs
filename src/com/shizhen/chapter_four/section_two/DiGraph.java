package com.shizhen.chapter_four.section_two;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class DiGraph {
    private int V;
    private int E;
    private Bag<Integer>[] adj;

    public DiGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public DiGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public DiGraph reverse() {
        DiGraph diGraph = new DiGraph(V);
        for (int v = 0; v < V; v++) {
            for (Integer w : adj(v)) {
                diGraph.addEdge(w, v);
            }
        }
        return diGraph;
    }

    @Override
    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int w : this.adj(v)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }
}
