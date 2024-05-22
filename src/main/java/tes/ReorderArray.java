package tes;

import java.util.Arrays;

public class ReorderArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(reorderArray(arr)));
    }

    private static int[] reorderArray(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            sw(i, j, arr);
            i++;
            j--;
        }

        return arr;
    }

    private static void sw(int fIndex, int sIndex, int[] arr) {
        int temp = arr[fIndex];
        arr[fIndex] = arr[sIndex];
        arr[sIndex] = temp;
    }
}
