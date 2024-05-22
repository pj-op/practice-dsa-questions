package com.arr;

import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        /*int[] arr = new int[10];
        Random random = new Random();
        IntStream.range(0, arr.length).forEach(i -> arr[i] = random.nextInt(100));
        System.out.println(Arrays.toString(arr));
        countSorting(arr);
        System.out.println(Arrays.toString(arr));*/

        String s1 = "THISISNOT";
        String s2 = "THISISNOT";
        String s3 = "THISNSDNS";

        cryptArithmetic(s1, s2, s3);

    }

    private static void cryptArithmetic(String s1, String s2, String s3) {
        Map<Character, Integer> charMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        List<String> strings = Arrays.asList(s1, s2, s3);
        populateCharMap(charMap, sb, strings);

        System.out.println(charMap);

        boolean[] isNumUsed = new boolean[10];

        performCrypt(sb, charMap, 0, isNumUsed, s1, s2, s3);

    }

    private static void performCrypt(StringBuilder uniqueString, Map<Character, Integer> charMap, int index, boolean[] isNumUsed, String s1, String s2, String s3) {

        if (charMap.get(s1.charAt(0)) == 0 || charMap.get(s2.charAt(0)) == 0 || charMap.get(s3.charAt(0)) == 0)
            return;

        if (index == uniqueString.length()) {
            int n1 = getNumsFromString(charMap, s1);
            int n2 = getNumsFromString(charMap, s2);
            int n3 = getNumsFromString(charMap, s3);

            if (n1 + n2 == n3) {
                System.out.println(n1 + " + " + n2 + " = " + n3);
            }
            return;
        }

        char ch = uniqueString.charAt(index);

        for (int i = 0; i <= 9; i++) {
            if (!isNumUsed[i]) {
                charMap.put(ch, i);
                isNumUsed[i] = true;
                performCrypt(uniqueString, charMap, index + 1, isNumUsed, s1, s2, s3);
                charMap.put(ch, -1);
                isNumUsed[i] = false;
            }
        }

    }

    private static int getNumsFromString(Map<Character, Integer> charMap, String str) {
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            sb.append(charMap.get(c));
        }

        return Integer.parseInt(sb.toString());
    }

    private static void populateCharMap(Map<Character, Integer> charMap, StringBuilder sb, List<String> strings) {
//        charMap = new HashMap<>();

        for (String s : strings) {
            for (char c : s.toCharArray()) {
                if (!charMap.containsKey(c)) {
                    charMap.put(c, -1);
                    sb.append(c);
                }
            }
        }
    }

    private static void countSorting(int[] arr) {
        int maxEle = Integer.MIN_VALUE;
        int minEle = Integer.MAX_VALUE;

        for (int ele : arr) {
            maxEle = Math.max(maxEle, ele);
            minEle = Math.min(minEle, ele);
        }

        //Creating freq Array
        int[] freq = new int[maxEle - minEle + 1];
        for (int ele : arr) freq[ele - minEle]++;

        //Prefix Sum
        IntStream.range(1, freq.length).forEach(i -> freq[i] = freq[i] + freq[i - 1]);

        System.out.println(Arrays.toString(freq));

        int[] ans = new int[arr.length];
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            int index = freq[arr[i] - minEle] - 1;
            if (index >= 0) {
                ans[index] = arr[i];
                freq[arr[i] - minEle]--;
            }
        }

        System.arraycopy(ans, 0, arr, 0, arr.length);

    }

    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        int[][] dp = new int[110][110];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = 9999;
            }
        }
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                int cnt = 0, del = 0;
                for (int l = i; l >= 1; l--) {
                    if (s.charAt(l - 1) == s.charAt(i - 1)) cnt++;
                    else del++;
                    if (j - del >= 0)
                        dp[i][j] = Math.min(dp[i][j], dp[l - 1][j - del] + 1 + (cnt >= 100 ? 3 : cnt >= 10 ? 2 : cnt >= 2 ? 1 : 0));
                }
                if (j > 0) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
            }
        }
        return dp[n][k];
    }
}