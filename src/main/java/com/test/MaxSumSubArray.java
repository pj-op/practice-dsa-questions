package com.test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] a =
//                {5, 4, -1, 7, 8};
                {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        mxSmSbArry(a);
    }

    private static void mxSmSbArry(int[] a) {
        int ans = 0;
        int sum = 0;
        int startI = -1;
        int endI = -1;

        for (int i = 0; i < a.length; i++) {
            if (sum < 0) {
                sum = 0;
                startI = i;
            }
            sum += a[i];
            if (sum > ans) {
                ans = sum;
                endI = i;
            }
        }

        int[] ansArr = new int[endI - startI + 1];
//        int minIndex = startI;
//        IntStream.rangeClosed(startI, endI).forEach(i -> ansArr[i - minIndex] = a[i]);

        System.arraycopy(a, startI, ansArr, 0, ansArr.length);

        System.out.println(Arrays.toString(ansArr));
    }
}
