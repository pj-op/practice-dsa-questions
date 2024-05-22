package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
//        System.out.println(printPascalTriangle());
        int poured = 2, query_row = 1, query_glass = 1;
        System.out.println(champagneTower(poured, query_row, query_glass));
    }

    public static double champagneTower(int poured, int query_row, int query_glass) {
        double[][] res = new double[101][101];
        res[0][0] = poured;
        for (int i = 0; i < res.length - 1; i++) {
            for (int j = 0; j <= i; j++) {
                if (res[i][j] >= 1) {
                    res[i + 1][j] += (res[i][j] - 1) / 2.0;
                    res[i + 1][j + 1] += (res[i][j] - 1) / 2.0;
                    res[i][j] = 1;
                }
            }
        }
        System.out.println(Arrays.deepToString(res));
        return res[query_row][query_glass];
    }

    private static List<List<Integer>> printPascalTriangle() {
        List<Integer> firstArray = List.of(1);
        List<Integer> secondArray = List.of(1, 1);

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(firstArray);
        ans.add(secondArray);

        for (int i = 2; i < 5; i++) {
            List<Integer> nextList = new ArrayList<>();
            nextList.add(1);
            List<Integer> prevList = ans.get(i - 1);
            for (int j = 0; j < prevList.size() - 1; j++) {
                nextList.add(prevList.get(j) + prevList.get(j + 1));
            }
            nextList.add(1);
            ans.add(nextList);
        }
        return ans;
    }
}
