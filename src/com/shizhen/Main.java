package com.shizhen;

import com.shizhen.chapter_two.JuniorSortAlgorithms;
import com.shizhen.chapter_two.SortCompare;
import edu.princeton.cs.algs4.StdOut;

public class Main {

    public static void main(String[] args) {
        //oldTest();


        //double t1 = SortCompare.timeRandomInput("Insertion",10000,100);
        //double t2 = SortCompare.timeRandomInput("Selection",10000,100);
        //double t3 = SortCompare.timeRandomInput("Shell",10000,100);
        double t4 = SortCompare.timeRandomInput("Merge",100000,100);
        //StdOut.printf("%s consumes %f s \n","Insertion",t1);
        //StdOut.printf("%s consumes %f s \n","Selection",t2);
        //StdOut.printf("%s consumes %f s \n","Shell",t3);
        StdOut.printf("%s consumes %f s \n","Merge",t4);
    }

    private static void oldTest() {
        //BinarySearch.test(args);

        String[] strArr = {"s","o","r","t","e","x","a","m","p","l","e"};
        JuniorSortAlgorithms.selectSort(strArr);
        JuniorSortAlgorithms.insertSort(strArr);
        JuniorSortAlgorithms.show(strArr);
    }
}
