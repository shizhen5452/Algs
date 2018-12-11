package com.shizhen.chapter_four.section_four;

import com.shizhen.chapter_four.section_two.Topological;
import com.shizhen.util.Constant;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class AcyclicSP {

    private DirectedEdge[] edgeTo;
    private double[] distTo;

    public AcyclicSP(EdgeWeightedDiagraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        Topological top = new Topological(G);
        if (top.isDAG()) {
            for (Integer v : top.order()) {
                relax(G, v);
            }
        }
    }

    private void relax(EdgeWeightedDiagraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
            }
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        Stack<DirectedEdge> stack = new Stack<>();
        DirectedEdge f = edgeTo[v];
        while (f != null) {
            stack.push(f);
            f = edgeTo[f.from()];
        }
        return stack;
    }

    public static void main(String[] args) {
        EdgeWeightedDiagraph G = new EdgeWeightedDiagraph(new In(Constant.DIR+"tinyEWDAG.txt"));

        int s = 5;
        AcyclicSP sp = new AcyclicSP(G, s);
        for (int v = 0; v < G.V(); v++) {
            if (sp.hasPathTo(v)) {
                StdOut.printf("%d to %d (%.2f)  ", s, v, sp.distTo(v));
                for (DirectedEdge e : sp.pathTo(v)) {
                    StdOut.print(e + "   ");
                }
                StdOut.println();
            }
            else {
                StdOut.printf("%d to %d         no path\n", s, v);
            }
        }
    }
}
