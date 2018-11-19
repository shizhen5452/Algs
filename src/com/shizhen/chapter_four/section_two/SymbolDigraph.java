package com.shizhen.chapter_four.section_two;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

public class SymbolDigraph {
    private ST<String, Integer> st;//符号名 -> 索引
    private String[] keys;         //索引   -> 符号名
    private DiGraph G;

    public SymbolDigraph(String fileName, String delim) {
        st = new ST<>();
        In in = new In(fileName);
        while (in.hasNextLine()) {
            String[] split = in.readLine().split(delim);
            for (int i = 0; i < split.length; i++) {
                if (!st.contains(split[i])) {
                    st.put(split[i], st.size());
                }
            }
        }
        keys = new String[st.size()];
        for (String key : st.keys()) {
            keys[st.get(key)] = key;
        }

        G = new DiGraph(st.size());
        in = new In(fileName);
        while (in.hasNextLine()) {
            String[] split = in.readLine().split(delim);
            int v = st.get(split[0]);
            for (int i = 1; i < split.length; i++) {
                G.addEdge(v, st.get(split[i]));
            }
        }
    }

    public boolean contains(String key) {
        return st.contains(key);
    }

    public int index(String key) {
        return st.get(key);
    }

    public String name(int v) {
        return keys[v];
    }

    public DiGraph G() {
        return G;
    }
}
