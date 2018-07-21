package com.shizhen;

import com.shizhen.util.IOUtil;
import com.shizhen.util.StringUtil;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinarySearch {

    public static int rank(int[] arr, int key) {
        int left = 0;
        int right = arr.length-1;
        while (left <= right) {
            int middle = (left + right)/2;
            if (key < arr[middle]) {
                right = middle-1;
            } else if (key > arr[middle]) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void test(String[] args) {
        if (args != null && args.length >= 2) {
            int[] tinyW = StringUtil.stringArray2IntArray(IOUtil.readArrayFromFile(args[0]));
            int[] tinyT = StringUtil.stringArray2IntArray(IOUtil.readArrayFromFile(args[1]));
            Arrays.sort(tinyW);
            for (int key : tinyT) {
                if (rank(tinyW, key) == -1) {
                    StdOut.println(key);
                }
            }
        }
    }

}
