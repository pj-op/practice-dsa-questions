package tes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class TestUST {
    static int count = 0;
    private static final Salary salary = new Salary(10);

    public static void main(String[] args) {
        /*salary.setAmount(100);
        System.out.println(salary.getAmount());*/

        /*try {
            throw new NullPointerException();
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            throw new ArrayIndexOutOfBoundsException();
        }*/

        /*int[] arr = {2, 4, 1, 3, 5};
        divide(arr);
        System.out.println(count);*/

        System.out.println(1^2^3^5);

    }

    private static void divide(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;

        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        IntStream.range(0, mid).forEach(i -> left[i] = arr[i]);
        IntStream.range(mid, arr.length).forEach(i -> right[i - mid] = arr[i]);

        divide(left);
        divide(right);

        countInversions(left, right, arr);
    }

    private static void countInversions(int[] left, int[] right, int[] arr) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                count++;
            }
        }

        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }
}

@Getter
@Setter
@AllArgsConstructor
class Salary {
    private int amount;
}
