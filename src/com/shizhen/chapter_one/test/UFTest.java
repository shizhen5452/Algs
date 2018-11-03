package com.shizhen.chapter_one.test;

import com.shizhen.chapter_one.UF;
import com.shizhen.util.Constant;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class UFTest {

    public static void main(String[] args) {
        In in = new In(Constant.DIR + "largeUF.txt");
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
