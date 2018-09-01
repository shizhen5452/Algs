package com.shizhen.chapter_two;

public class JuniorSortAlgorithms extends BaseSortAlgorithms {

    /**
     * Selection sort
     * Firstly, find the minimum element of the array and exchange value with the first element
     * Secondly, ignore the first element, find the minimum element of the remaining array and exchange value with the second element
     * ......
     * Finally, we got it
     */
    public static void selectSort(Comparable[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    /**
     * Insertion sort
     * For i in a[], each time we start from a[i] to a[0], for example, for(int j=i;j>0;j--),
     * we compare a[j] with a[j-1], if(a[j]<a[j-1]), then we exchange a[j] and a[j-1]
     */
    public static void insertSort(Comparable[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                }
            }
        }
    }

    /**
     * Shell sort
     * h=4
     * L E E A M H L E P S O L T S X R
     * L-------M-------P-------T
     *   E-------H-------S-------S
     *     E-------L-------O-------X
     *       A-------E-------L-------R
     */
    public static void shellSort(Comparable[] a) {
        int len = a.length;
        int h = 1;
        while (h < len / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (less(a[j], a[j - h])) {
                        exch(a, j, j - h);
                    }
                }
            }
            h = h / 3;
        }
    }
}
