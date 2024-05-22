package tes;

import java.util.Arrays;

public class Hkl {
    public static void main(String[] args) {
        String s = "abc";
        String t = "bac";
        System.out.println(findPermutationDifference(s, t));
    }

    private static int findPermutationDifference(String s, String t) {
        int ans = 0;
        int n = s.length();
        int index = 0;
        while (index < n) {
            ans += Math.abs(index - t.indexOf(s.charAt(index)));
            index++;
        }


        return ans;
    }

    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n + 2];
        Arrays.fill(dp, 0);

        int maxval = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if ((i + k) >= n) {
                dp[i] = energy[i];
            }
            else {
                dp[i] = dp[i + k] + energy[i];
            }
            maxval = Math.max(maxval, dp[i]);
        }

        return maxval;
    }
}