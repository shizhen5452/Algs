package com.shizhen.chapter_two;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {
    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        switch (alg) {
            case "Insertion":
                JuniorSortAlgorithms.insertSort(a);
                break;
            case "Selection":
                JuniorSortAlgorithms.selectSort(a);
                break;
            case "Shell":
                break;
            case "Merge":
                break;
            case "Quick":
                break;
            case "Heap":
                break;
            default:
                break;
        }
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N; j++) {
                a[j]=StdRandom.uniform();
            }
            total += time(alg,a);
        }
        return total;
    }
}
