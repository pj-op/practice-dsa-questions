package com.test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class SortingAlgos {
    public static void main(String[] args) {
        int[] arr = new int[30];
        Random random = new Random();
        IntStream.range(0, arr.length).forEach(i -> arr[i] = random.nextInt(100));

        System.out.println(Arrays.toString(arr));
        quickSorting(arr);
//        mergeSorting(arr);
//        insertionSorting(arr);
//        selectionSorting(arr);
//        bubbleSorting(arr);
//        countSorting(arr);
//        radixSorting(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSorting(int[] arr) {
        quickSorting(arr, 0, arr.length - 1);
    }

    private static void quickSorting(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) return;
        int pivot = arr[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (pivot > arr[leftPointer] && leftPointer < rightPointer) leftPointer++;
            while (pivot <= arr[rightPointer] && leftPointer < rightPointer) rightPointer--;
            swappElementsInArray(arr, leftPointer, rightPointer);
        }
        swappElementsInArray(arr, leftPointer, highIndex);

        quickSorting(arr, lowIndex, leftPointer - 1);
        quickSorting(arr, leftPointer + 1, highIndex);
    }

    private static void mergeSorting(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[arr.length - mid];
        IntStream.range(0, mid).forEach(i -> leftArray[i] = arr[i]);
        IntStream.range(mid, arr.length).forEach(i -> rightArray[i - mid] = arr[i]);

        mergeSorting(leftArray);
        mergeSorting(rightArray);

        mergSmallChuncks(arr, leftArray, rightArray);
    }

    private static void mergSmallChuncks(int[] arr, int[] leftArray, int[] rightArray) {
        int i = 0, j = 0, k = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) arr[k++] = leftArray[i++];
            else arr[k++] = rightArray[j++];
        }

        while (i < leftArray.length) arr[k++] = leftArray[i++];
        while (j < rightArray.length) arr[k++] = rightArray[j++];
    }

    private static void insertionSorting(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int minVal = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > minVal) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = minVal;
        }
    }

    private static void selectionSorting(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minPosition = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minPosition]) minPosition = j;
            }
            if (minPosition != i) swappElementsInArray(arr, i, minPosition);
        }
    }

    private static void bubbleSorting(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) swappElementsInArray(arr, i, j);
            }
        }
    }

    private static void swappElementsInArray(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    private static void countSorting(int[] arr) {
        int[] res = new int[arr.length];
        int minElement = Integer.MAX_VALUE;
        int maxElement = Integer.MIN_VALUE;

        for (int ele : arr) {
            minElement = Math.min(minElement, ele);
            maxElement = Math.max(maxElement, ele);
        }

        int[] freqArray = new int[maxElement - minElement + 1];

        int finalMinElement = minElement;
        IntStream.range(0, arr.length).forEach(i -> freqArray[arr[i] - finalMinElement]++);
        IntStream.range(1, freqArray.length).forEach(i -> freqArray[i] = freqArray[i] + freqArray[i - 1]);

        for (int i = arr.length - 1; i >= 0; i--) {
            int index = freqArray[arr[i] - minElement] - 1;
            if (index >= 0) {
                res[index] = arr[i];
                freqArray[arr[i] - minElement]--;
            }
        }

        System.arraycopy(res, 0, arr, 0, arr.length);

    }

    private static void radixSorting(int[] arr) {
        int maxElement = Integer.MIN_VALUE;
        for (int ele : arr) maxElement = Math.max(maxElement, ele);
        int exponent = 1;
        while (exponent <= maxElement) {
            countingSort(arr, exponent);
            exponent *= exponent * 10;
        }
    }

    private static void countingSort(int[] arr, int exponent) {
        int[] res = new int[arr.length];
        int[] freqArr = new int[10];

        IntStream.range(0, arr.length).forEach(i -> freqArr[arr[i] / exponent % 10]++);
        IntStream.range(1, freqArr.length).forEach(i -> freqArr[i] = freqArr[i] + freqArr[i - 1]);

        for (int i = arr.length - 1; i >= 0; i--) {
            int index = freqArr[arr[i] / exponent % 10] - 1;
            if (index >= 0) {
                res[index] = arr[i];
                freqArr[arr[i] / exponent % 10]--;
            }
        }
        System.arraycopy(res, 0, arr, 0, arr.length);
    }

}
