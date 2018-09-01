package com.shizhen.chapter_two;

public class QuickSortAlgorithms extends BaseSortAlgorithms {


    /**
     * Base quick sort
     */
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int partition = partition(a, lo, hi);
        sort(a,lo,partition-1);
        sort(a,partition+1,hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        if (lo + 1 >= hi) {
            return hi;
        }
        int left = lo + 1;
        int right = hi;
        Comparable value = a[lo];
        while (true) {
            while (less(a[left], value)) {
                left++;
                if (left == hi) {
                    break;
                }
            }
            while (less(value, a[right])) {
                right--;
                if (right == lo) {
                    break;
                }
            }
            if (left >= right) {
                break;
            }
            exch(a,left,right);
        }
        exch(a,lo,right);
        return right;
    }

    /**
     *
     */
    public static void sort2(Comparable[] a, int lo, int hi) {

    }

}
