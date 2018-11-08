package com.shizhen.chapter_four.section_one.test;

import com.shizhen.chapter_four.section_one.CC;
import com.shizhen.chapter_four.section_one.Graph;
import com.shizhen.util.Constant;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class TestCC {

    public static void main(String[] args) {
        Graph G = new Graph(new In(Constant.DIR + "tinyG.txt"));
        CC cc = new CC(G);

        int count = cc.count();
        StdOut.println(count + "components");

        Bag<Integer>[] components = new Bag[count];
        for (int i = 0; i < count; i++) {
            components[i] = new Bag<>();
        }
        for (int i = 0; i < G.V(); i++) {
            components[cc.id(i)].add(i);
        }
        for (int i = 0; i < count; i++) {
            for (Integer v : components[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
    }

}
