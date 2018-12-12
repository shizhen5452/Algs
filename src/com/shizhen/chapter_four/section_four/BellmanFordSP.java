package com.shizhen.chapter_four.section_four;

import com.shizhen.util.Constant;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class BellmanFordSP {

    private double[] distTo;//从起点到某个顶点的路径长度
    private DirectedEdge[] edgeTo;//从起点到某个顶点的最后一条边
    private boolean[] onQ;//该顶点是否在队列中
    private Queue<Integer> queue;//正在被放松的顶点
    private int cost;
    private boolean hasCycle;

    public BellmanFordSP(EdgeWeightedDiagraph G, int s) {
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        onQ = new boolean[G.V()];
        queue = new Queue<>();
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        queue.enqueue(s);
        onQ[s] = true;
        while (!queue.isEmpty() && !hasNegativeCycle()) {
            int v = queue.dequeue();
            onQ[v] = false;
            relax(G, v);
        }
    }

    private void relax(EdgeWeightedDiagraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (!onQ[w]) {
                    queue.enqueue(w);
                    onQ[w] = true;
                }
            }
        }
        if (cost++ % G.V() == 0) {
            findNegativeCycle();
        }
    }

    private void findNegativeCycle() {
        int V = edgeTo.length;
        EdgeWeightedDiagraph diagraph = new EdgeWeightedDiagraph(V);
        for (int v = 0; v < V; v++) {
            if (edgeTo[v] != null) {
                diagraph.addEdge(edgeTo[v]);
            }
        }
        EdgeWeightedDirectedCycle cf = new EdgeWeightedDirectedCycle(diagraph);
        hasCycle = cf.hasCycle();
    }

    private boolean hasNegativeCycle() {
        return hasCycle;
    }

    private boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    private double distTo(int v) {
        return distTo[v];
    }

    private Iterable<DirectedEdge> pathTo(int v) {
        Stack<DirectedEdge> stack = new Stack<>();
        DirectedEdge f = edgeTo[v];
        while (f != null) {
            stack.push(f);
            f = edgeTo[f.from()];
        }
        return stack;
    }

    public static void main(String[] args) {
        EdgeWeightedDiagraph G = new EdgeWeightedDiagraph(new In(Constant.DIR + "tinyEWDn.txt"));
        int s = 0;
        BellmanFordSP sp = new BellmanFordSP(G, s);

        if (!sp.hasNegativeCycle()) {
            for (int v = 0; v < G.V(); v++) {
                if (sp.hasPathTo(v)) {
                    StdOut.printf("%d to %d (%5.2f)  ", s, v, sp.distTo(v));
                    for (DirectedEdge e : sp.pathTo(v)) {
                        StdOut.print(e + "   ");
                    }
                    StdOut.println();
                } else {
                    StdOut.printf("%d to %d           no path\n", s, v);
                }
            }
        }

    }
}
