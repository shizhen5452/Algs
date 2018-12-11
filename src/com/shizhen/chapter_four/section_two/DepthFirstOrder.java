package com.shizhen.chapter_four.section_two;

import com.shizhen.chapter_four.section_four.DirectedEdge;
import com.shizhen.chapter_four.section_four.EdgeWeightedDiagraph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class DepthFirstOrder {
    private boolean[] marked;//标记是否访问过的顶点列表
    private Queue<Integer> pre;//所有顶点的前序排列
    private Queue<Integer> post;//所有顶点的后序排列
    private Stack<Integer> reversePost;//所有顶点的逆后序排列

    public DepthFirstOrder(DiGraph G) {
        marked = new boolean[G.V()];
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    public DepthFirstOrder(EdgeWeightedDiagraph G) {
        marked = new boolean[G.V()];
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(DiGraph G, int v) {
        pre.enqueue(v);
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        post.enqueue(v);
        reversePost.push(v);
    }

    private void dfs(EdgeWeightedDiagraph G, int v) {
        pre.enqueue(v);
        marked[v] = true;
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        post.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }

}
