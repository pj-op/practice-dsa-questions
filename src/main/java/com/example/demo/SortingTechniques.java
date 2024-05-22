package com.example.demo;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class SortingTechniques {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[random.nextInt(17)];
        IntStream.range(0, arr.length).forEach(i -> arr[i] = random.nextInt(101));
        System.out.println(Arrays.toString(arr));
        //quickSortingTech(arr);
        //mergeSortingTech(arr);
        //selectionSortingTech(arr);
        insertionSortingTech(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSortingTech(int[] arr) {
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

    private static void selectionSortingTech(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) minIndex = j;
            }
            if (i != minIndex) swapElement(arr, i, minIndex);
        }
    }

    private static void mergeSortingTech(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[arr.length - mid];
        IntStream.range(0, leftArr.length).forEach(i -> leftArr[i] = arr[i]);
        IntStream.range(mid, arr.length).forEach(i -> rightArr[i - mid] = arr[i]);
        mergeSortingTech(leftArr);
        mergeSortingTech(rightArr);

        mergeChunksInSortedOrder(arr, leftArr, rightArr);
    }

    private static void mergeChunksInSortedOrder(int[] arr, int[] leftArr, int[] rightArr) {
        int i = 0, j = 0, k = 0;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] < rightArr[j]) arr[k++] = leftArr[i++];
            else arr[k++] = rightArr[j++];
        }
        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
    }

    private static void quickSortingTech(int[] arr) {
        quickSortingTech(arr, 0, arr.length - 1);
    }

    private static void quickSortingTech(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) return;
        int pivot = arr[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (pivot > arr[leftPointer] && leftPointer < rightPointer) leftPointer++;
            while (pivot <= arr[rightPointer] && leftPointer < rightPointer) rightPointer--;
            swapElement(arr, leftPointer, rightPointer);
        }
        swapElement(arr, leftPointer, highIndex);

        quickSortingTech(arr, lowIndex, leftPointer - 1);
        quickSortingTech(arr, leftPointer + 1, highIndex);
    }

    private static void swapElement(int[] inputArray, int firstIndex, int secondIndex) {
        int temp = inputArray[firstIndex];
        inputArray[firstIndex] = inputArray[secondIndex];
        inputArray[secondIndex] = temp;
    }
}
