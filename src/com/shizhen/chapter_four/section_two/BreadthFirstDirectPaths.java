package com.shizhen.chapter_four.section_two;

import com.shizhen.util.Constant;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class BreadthFirstDirectPaths {
    private int s;//起点
    private boolean[] marked;//标记是否访问过的顶点列表
    private int[] edgeTo;//到达该顶点的已知路径上的最后一个顶点


    public BreadthFirstDirectPaths(DiGraph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        bfs(G, s);
    }

    private void bfs(DiGraph G, int s) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(s);
        marked[s] = true;
        while (!queue.isEmpty()) {
            Integer x = queue.dequeue();
            for (Integer w : G.adj(x)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = x;
                    queue.enqueue(w);
                }
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
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
        DiGraph G = new DiGraph(new In(Constant.DIR + "tinyDG.txt"));
        StdOut.println(G.toString());
        BreadthFirstDirectPaths bfdp = new BreadthFirstDirectPaths(G, 0);
        for (int v = 0; v < G.V(); v++) {
            if (bfdp.hasPathTo(v)) {
                for (Integer w : bfdp.pathTo(v)) {
                    StdOut.print(w + "-");
                }
                StdOut.println();
            }
        }
    }
}
