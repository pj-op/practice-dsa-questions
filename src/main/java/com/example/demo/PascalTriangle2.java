package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PascalTriangle2 {
    public static void main(String[] args) {
        int rowIndex = 3;
        System.out.println(getRowUsingIntArray(rowIndex));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> firstList = List.of(1);
        List<Integer> secondList = List.of(1, 1);

        ans.add(firstList);
        ans.add(secondList);

        for (int i = 2; i <= rowIndex; i++) {
            List<Integer> thirdList = new ArrayList<>();
            thirdList.add(1);
            for (int j = 0; j + 1 < ans.get(i - 1).size(); j++) {
                thirdList.add(ans.get(i - 1).get(j) + ans.get(i - 1).get(j + 1));
            }
            thirdList.add(1);
            ans.add(thirdList);
        }
//        System.out.println(ans);
        return ans.get(rowIndex);
    }

    public static List<Integer> getRowUsingIntArray(int rowIndex) {
        int[][] ans = new int[rowIndex + 1][rowIndex + 1];
        int[] firstArray = new int[]{1};
        int[] secondArray = new int[]{1, 1};

        if(rowIndex==0) return Arrays.stream(firstArray).boxed().collect(Collectors.toList());
        if(rowIndex==1) return Arrays.stream(secondArray).boxed().collect(Collectors.toList());

        ans[0] = firstArray;
        ans[1] = secondArray;

        for (int i = 2; i <= rowIndex; i++) {
            int[] thirdArray = new int[i + 1];
            thirdArray[0] = 1;
            int count = 1;
            for (int j = 0; j + 1 < ans[i - 1].length; j++) {
                thirdArray[count++] = ans[i - 1][j] + ans[i - 1][j + 1];
            }
            thirdArray[thirdArray.length - 1] = 1;
            ans[i] = thirdArray;
        }
//        System.out.println(ans);
        System.out.println(Arrays.deepToString(ans));
        return Arrays.stream(ans[rowIndex]).boxed().collect(Collectors.toList());
    }
}
