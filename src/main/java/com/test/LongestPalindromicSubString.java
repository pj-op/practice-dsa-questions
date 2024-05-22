package com.test;

public class LongestPalindromicSubString {
    public static void main(String[] args) {
       /* String s = "babad";
        System.out.println(longestPalindrome(s));*/
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) dp[i][j] = true;
                else {
                    boolean first_and_last_char_equals = s.charAt(i) == s.charAt(j);
                    if (gap == 1) dp[i][j] = first_and_last_char_equals;
                    else dp[i][j] = first_and_last_char_equals && dp[i + 1][j - 1];
                }
            }
            System.out.println();
        }


        return null;
    }

    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
