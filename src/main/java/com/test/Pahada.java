package com.test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Pahada {
    public static void main(String[] args) {
        printPahada();
        Random random = new Random();
        int[] arr = new int[10];
        IntStream.range(0, arr.length).forEach(i -> arr[i] = random.nextInt(200));
        System.out.println(Arrays.toString(arr));
//        radixSortAgain(arr);
//        countSortAgain(arr);
//        insertionSortAgain(arr);
//        selectionSortAgain(arr);
//        mergeSortAgain(arr);
//        quickSortAgain(arr);
//        bubbleSortAgain(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSortAgain(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) swapEle(i, j, arr);
            }
        }
    }

    private static void quickSortAgain(int[] arr) {
        quickSortAgain(arr, 0, arr.length - 1);
    }

    private static void quickSortAgain(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) return;
        int pivot = arr[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (arr[leftPointer] < pivot && leftPointer < rightPointer) leftPointer++;
            while (arr[rightPointer] >= pivot && leftPointer < rightPointer) rightPointer--;
            swapEle(leftPointer, rightPointer, arr);
        }
        swapEle(leftPointer, highIndex, arr);

        quickSortAgain(arr, lowIndex, leftPointer - 1);
        quickSortAgain(arr, leftPointer + 1, highIndex);
    }

    private static void mergeSortAgain(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[arr.length - mid];

        IntStream.range(0, mid).forEach(i -> leftArr[i] = arr[i]);
        IntStream.range(mid, arr.length).forEach(i -> rightArr[i - mid] = arr[i]);

        mergeSortAgain(leftArr);
        mergeSortAgain(rightArr);

        mergSortedParts(leftArr, rightArr, arr);
    }

    private static void mergSortedParts(int[] leftArr, int[] rightArr, int[] arr) {
        int i = 0, j = 0, k = 0;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] < rightArr[j]) arr[k++] = leftArr[i++];
            else arr[k++] = rightArr[j++];
        }
        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
    }

    private static void selectionSortAgain(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minPosition = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minPosition]) minPosition = j;
            }
            if (i != minPosition) swapEle(i, minPosition, arr);
        }
    }

    private static void insertionSortAgain(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int minVal = arr[i];
            while (j >= 0 && arr[j] > minVal) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = minVal;
        }
    }

    private static void countSortAgain(int[] arr) {
        int[] ans = new int[arr.length];
        int minEle = Integer.MAX_VALUE;
        int maxEle = Integer.MIN_VALUE;
        for (int ele : arr) {
            minEle = Math.min(minEle, ele);
            maxEle = Math.max(maxEle, ele);
        }
        int[] freq = new int[maxEle - minEle + 1];
        for (int ele : arr) freq[ele - minEle]++;
        IntStream.range(1, freq.length).forEach(i -> freq[i] = freq[i] + freq[i - 1]);

        for (int i = arr.length - 1; i >= 0; i--) {
            int index = freq[arr[i] - minEle] - 1;
            if (index >= 0) {
                ans[index] = arr[i];
                freq[arr[i] - minEle]--;
            }
        }
        System.arraycopy(ans, 0, arr, 0, arr.length);
    }

    private static void radixSortAgain(int[] arr) {
        int maxEle = Integer.MIN_VALUE;
        for (int ele : arr) maxEle = Math.max(maxEle, ele);
        int exponent = 1;
        while (exponent <= maxEle) {
            countingSortAgain(arr, exponent);
            exponent *= 10;
        }
    }

    private static void countingSortAgain(int[] arr, int exponent) {
        int[] ans = new int[arr.length];
        //Creating freqArray
        int[] freqArr = new int[10];
        for (int ele : arr) freqArr[ele / exponent % 10]++;
        //Prefix sum
        IntStream.range(1, freqArr.length).forEach(i -> freqArr[i] = freqArr[i] + freqArr[i - 1]);

        for (int i = arr.length - 1; i >= 0; i--) {
            int index = freqArr[arr[i] / exponent % 10] - 1;
            if (index >= 0) {
                ans[index] = arr[i];
                freqArr[arr[i] / exponent % 10]--;
            }
        }
        System.arraycopy(ans, 0, arr, 0, arr.length);
    }

    private static void printPahada() {
        for (int j = 1; j <= 10; j++) {
            for (int i = 2; i <= 10; i++) {
                System.out.print((i * j) + "\t");
            }
            System.out.println();
        }
    }

    private static void swapEle(int firstIndex, int secondIndex, int[] arr) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
