package com.shizhen.chapter_two;

public class MergeSortAlgorithms extends BaseSortAlgorithms {
    private static Comparable[] aux;

    /**
     * From top to bottom, split long array to short array, and merge short array
     */
    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (lo+hi)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

    /**
     * From bottom to top, merge short array and then merge longer array
     */
    public static void sort2(Comparable[] a){
        int len = a.length;
        aux = new Comparable[len];
        for (int i=1;i<len;i=2*i){
            for(int j=0;j<len-i;j+=2*i){
                merge(a,j,j+i-1,Math.min(j+2*i-1,len-1));
            }
        }
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid+1;
        System.arraycopy(a,0,aux,0,a.length);
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[j++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

}
