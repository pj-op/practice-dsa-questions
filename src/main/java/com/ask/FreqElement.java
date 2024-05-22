package com.ask;

import java.util.Arrays;

public class FreqElement {
    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 3, 5};
        System.out.println(Arrays.toString(frequencyCount(arr, arr.length, 5)));
    }

    private static int[] frequencyCount(int[] arr, int n, int P) {

        for (int i = 0; i < n; i++) {
            while (arr[i] > 0) {
                int num = arr[i];
                if (arr[i] <= P) {
                    swapElemen(i, arr[i] - 1, arr);
                    arr[num - 1] = arr[num - 1] < 0 ? arr[num - 1] -= 1 : -1;
                }
            }

            if (arr[i] > P) {
                arr[i] = 0;
            }

        }


        return arr;
    }

    private static void swapElemen(int fIndex, int sIndex, int[] arr) {
        int temp = arr[fIndex];
        arr[fIndex] = arr[sIndex];
        arr[sIndex] = temp;
    }
}
