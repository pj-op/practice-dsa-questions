package com.test;

import java.util.Arrays;

public class RotateByKPositions {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(rotateElementsByKPositions(arr, k)));
    }

    private static int[] rotateElementsByKPositions(int[] arr, int k) {
        int n = arr.length - 1;
        int i = 0;
        // 1 : Reversing whole array
        reverseElements(i, n, arr);
        System.out.println(Arrays.toString(arr));
        reverseElements(i, k - 1, arr);
        System.out.println(Arrays.toString(arr));
        reverseElements(k, n, arr);

        return arr;
    }


    private static void reverseElements(int fIndex, int sIndex, int[] arr) {

        while (fIndex <= sIndex) {
            int temp = arr[fIndex];
            arr[fIndex] = arr[sIndex];
            arr[sIndex] = temp;

            fIndex++;
            sIndex--;
        }
    }
}
