package com.shizhen.chapter_four.section_two;

import com.shizhen.util.Constant;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class DirectedCycle {
    private boolean[] marked;//标记是否访问过的顶点列表
    private int[] edgeTo;//到达该顶点的已知路径上的最后一个顶点
    private boolean[] onStack;//递归调用的栈上的所有顶点，每次递归调用都会变化
    private Stack<Integer> cycle;//有项环中的所有顶点（如果存在有项环的话）

    public DirectedCycle(DiGraph G) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        onStack = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(DiGraph G, int v) {
        marked[v] = true;
        onStack[v] = true;
        for (Integer w : G.adj(v)) {
            if (hasCycle()) {
                return;
            }
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    public static void main(String[] args) {
        DiGraph G = new DiGraph(new In(Constant.DIR + "tinyDAG.txt"));
        DirectedCycle dc = new DirectedCycle(G);
        if (dc.hasCycle()) {
            for (Integer x : dc.cycle()) {
                StdOut.print(x + "-");
            }
        }
    }

}
