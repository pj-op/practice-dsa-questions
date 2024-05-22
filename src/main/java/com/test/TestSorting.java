package com.test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class TestSorting {
    public static void main(String[] args) {
        /*int[] arr = new int[10];
        Random random = new Random();
        IntStream.range(0, arr.length).forEach(i -> arr[i] = random.nextInt(30));
        System.out.println(Arrays.toString(arr));
//        quicSorting(arr);
//        mergSorting(arr);
//        insertSort(arr);
//        selectSort(arr);
//        bubblSort(arr);
        System.out.println(Arrays.toString(arr));*/

        /*//Multiply Strings
        String s1 = "999", s2 = "9";
        System.out.println(mulStr(s1, s2));*/

        //Calculate prefix min
        int[] arr = {8, 6, 1, 5, 3};
        calculatePrefixMinArr(arr);

    }

    private static void calculatePrefixMinArr(int[] arr) {
        int[] leftMinArray = new int[arr.length];
        int[] rightMinArray = new int[arr.length];

        int n = arr.length;

        leftMinArray[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMinArray[i] = Math.min(leftMinArray[i - 1], arr[i]);
        }
        rightMinArray[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMinArray[i] = Math.min(rightMinArray[i + 1], arr[i]);
        }

        System.out.println(Arrays.toString(leftMinArray));
        System.out.println(Arrays.toString(rightMinArray));
    }

    private static String mulStr(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[] res = new int[l1 + l2];
        int i = l1 - 1;
        int pf = 0;
        while (i >= 0) {
            int iVal = s1.charAt(i) - '0';
            i--;
            int j = l2 - 1;
            int carry = 0;
            int k = res.length - 1 - pf;
            while (j >= 0 || carry != 0) {
                int jVal = j >= 0 ? s2.charAt(j) - '0' : 0;
                j--;
                int prod = iVal * jVal + carry + res[k];
                res[k] = prod % 10;
                carry = prod / 10;
                k--;
            }
            pf++;
        }

        boolean flag = false;
        StringBuilder sb = new StringBuilder();

        for (int a : res) {
            if (a == 0 && !flag) {
                continue;
            } else {
                flag = true;
                sb.append(a);
            }
        }
        return sb.toString();
    }

    private static void bubblSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) swp(arr, i, j);
            }
        }
    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minPosition = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[minPosition]) minPosition = j;
            }
            if (i != minPosition) swp(arr, i, minPosition);
        }
    }

    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int minVal = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < minVal) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = minVal;
        }
    }

    private static void mergSorting(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[arr.length - mid];

        IntStream.range(0, mid).forEach(i -> leftArr[i] = arr[i]);
        IntStream.range(mid, arr.length).forEach(i -> rightArr[i - mid] = arr[i]);

        mergSorting(leftArr);
        mergSorting(rightArr);

        mergChuncks(arr, leftArr, rightArr);
    }

    private static void mergChuncks(int[] arr, int[] leftArr, int[] rightArr) {
        int i = 0, j = 0, k = 0;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] > rightArr[j]) arr[k++] = leftArr[i++];
            else arr[k++] = rightArr[j++];
        }
        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
    }

    private static void quicSorting(int[] arr) {
        quicSorting(arr, 0, arr.length - 1);
    }

    private static void quicSorting(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) return;
        int pivot = arr[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        while (leftPointer < rightPointer) {
            while (pivot < arr[leftPointer] && leftPointer < rightPointer) leftPointer++;
            while (pivot >= arr[rightPointer] && leftPointer < rightPointer) rightPointer--;
            swp(arr, leftPointer, rightPointer);
        }
        swp(arr, leftPointer, highIndex);

        quicSorting(arr, lowIndex, leftPointer - 1);
        quicSorting(arr, leftPointer + 1, highIndex);
    }

    private static void swp(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

}
