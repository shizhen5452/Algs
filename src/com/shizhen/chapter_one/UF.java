package com.shizhen.chapter_one;

import com.shizhen.util.Constant;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class UF {

    private int count;
    private int[] id;
    private int[] sz;

    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        count--;
    }

    public static void main(String[] args) {
        In in = new In(Constant.DIR + "mediumUF.txt");
        int N = in.readInt();
        UF uf = new UF(N);
        boolean b = true;
        while (b) {
            try {
                int p = in.readInt();
                int q = in.readInt();
                if (uf.connected(p, q)) {
                    continue;
                }
                uf.union(p, q);
                StdOut.println(p + " " + q);
            } catch (Exception e) {
                b = false;
            }
        }
        StdOut.println(uf.count() + " components");
    }
}
