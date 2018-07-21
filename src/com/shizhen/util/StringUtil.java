package com.shizhen.util;

public class StringUtil {

    /**
     * check whether the string is empty(null or length is 0)
     * @param str string to check
     * @return true if is empty(null or length is 0)
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * check whether the string array is empty(null or length is 0)
     * @param arr string array to check
     * @return true if is empty(null or length is 0)
     */
    public static boolean isEmptyArray(String[] arr) {
        return arr == null || arr.length == 0;
    }

    public static int[] stringArray2IntArray(String[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = Integer.valueOf(arr[i]);
        }
        return result;
    }

}
