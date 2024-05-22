package com.test;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class MTest {
    public static void main(String[] args) {
        /*int n = 8;
        System.out.println(pivotInteger(n));*/

        /*int[] arr = {1, 0, 1, 0, 1};
        int goal = 2;
*/
//        generateAllSubArraysU(arr, goal);
        /*String str = "abcdef";
        generateAllSubStringsU(str);*/

        /*String s=null;
        System.out.println(Long.parseLong(s));*/


        int[] arr = {0, 0, 0, 0, 0, 2, 99, 0, 2, 3, 0, 4, 0, 1};
        System.out.println(Arrays.toString(moveZerosToEnd(arr)));

    }

    private static int[] moveZerosToEnd(int[] arr) {
        int i = 0;
        int j = 0;
        int n = arr.length;

        while (i < n) {
            if (arr[i] != 0) {
                arr[j++] = arr[i];
            }
            i++;
        }
        while (j < n) {
            arr[j++] = 0;
        }

        return arr;
    }

    private static void generateAllSubStringsU(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                System.out.println(str.substring(i, j + 1));
            }
            System.out.println();
        }
    }

    private static void generateAllSubArraysU(int[] arr, int goal) {
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                AtomicInteger sum = new AtomicInteger();

                IntStream.rangeClosed(i, j).forEach(idx -> sum.addAndGet(arr[idx]));
                /*for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }*/
                if (sum.get() == goal) {
                    count++;
                }
            }
        }
        System.out.println("count: " + count);
    }

    private static int pivotInteger(int n) {
        int end = n;
        int mid = n / 2;

        int totalSum = (n * (n + 1)) / 2;

        int suffSum = 0;
        while (end >= mid) {
            suffSum += end;
            if ((suffSum + end - 1) == (totalSum - suffSum)) {
                return end - 1;
            }
            end--;
        }

        return -1;

    }
}
