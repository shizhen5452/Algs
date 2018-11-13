package com.shizhen.chapter_four.section_two;

import com.shizhen.util.Constant;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class DepthFirstDirectedPaths {
    private int s;//起点
    private boolean[] marked;//标记是否访问过的顶点列表
    private int[] edgeTo;//到达该顶点的已知路径上的最后一个顶点

    public DepthFirstDirectedPaths(DiGraph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G, s);
    }

    private void dfs(DiGraph G, int v) {
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = v; i != s; i = edgeTo[i]) {
            stack.push(i);
        }
        stack.push(s);
        return stack;
    }

    public static void main(String[] args) {
        DiGraph G = new DiGraph(new In(Constant.DIR + "tinyDG.txt"));
        StdOut.println(G.toString());
        DepthFirstDirectedPaths dfdp = new DepthFirstDirectedPaths(G, 0);
        for (int v = 0; v < G.V(); v++) {
            if (dfdp.hasPathTo(v)) {
                for (Integer w : dfdp.pathTo(v)) {
                    StdOut.print(w + "-");
                }
                StdOut.println();
            }
        }
    }
}
