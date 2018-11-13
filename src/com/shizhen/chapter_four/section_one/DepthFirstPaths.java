package com.shizhen.chapter_four.section_one;


import edu.princeton.cs.algs4.Stack;

public class DepthFirstPaths {
    private boolean[] marked;//顶点是否访问过的列表
    private int count;
    private int s;           //起点
    private int[] edgeTo;    //到达该顶点的已知路径上的最后一个顶点


    public DepthFirstPaths(Graph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
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
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }
}
