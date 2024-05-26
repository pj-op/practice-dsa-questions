package tes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindOccurrencesElementinanArray {
    public static void main(String[] args) {
        int x = 1;
        int[] nums = {1, 3, 1, 7}, queries = {1, 3, 2, 4};
        System.out.println(Arrays.toString(occurrencesOfElement(nums, queries, x)));
    }

    public static int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int n = queries.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        List<Integer> appearance = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                appearance.add(i);
            }
        }

        for (int i = 0; i < n; i++) {
            if (queries[i] <= appearance.size()) {
                res[i] = appearance.get(queries[i] - 1);
            }
        }
        return res;
    }
}
