package com.shizhen;

import com.shizhen.chapter_one.BinarySearch;
import com.shizhen.chapter_two.JuniorSortAlgorithms;

public class Main {

    public static void main(String[] args) {
        BinarySearch.test(args);

        String[] strArr = {"s","o","r","t","e","x","a","m","p","l","e"};
        //JuniorSortAlgorithms.selectSort(strArr);
        JuniorSortAlgorithms.insertSort(strArr);
        JuniorSortAlgorithms.show(strArr);
    }
}
