package com.shizhen.chapter_four;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

import java.util.Arrays;

public class BreadthFirstPaths {
    private boolean[] marked;//到达该顶点的最短路径已知吗？
    private int s;           //起点
    private int[] edgeTo;    //到达该顶点的已知路径上的最后一个顶点
    private int[] distTo;    //到达该顶点的最短路径


    public BreadthFirstPaths(Graph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        Arrays.fill(distTo,Integer.MAX_VALUE);
        Queue<Integer> queue = new Queue<>();
        marked[v] = true;
        queue.enqueue(v);
        distTo[v] = 0;
        while (!queue.isEmpty()) {
            Integer x = queue.dequeue();
            for (Integer w : G.adj(x)) {
                if (!marked[w]) {
                    edgeTo[w] = x;
                    distTo[w] = distTo[x] + 1;
                    marked[w] = true;
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

    public int distTo(int v) {
        return distTo[v];
    }

}
