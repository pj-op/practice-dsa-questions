package tes;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class StudentAttendanceRecordII {
    static int MOD = 10_000_000_07;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Times: ");
        int n = scan.nextInt();

        while (n != 0) {
            System.out.print("Enter Test Case: ");
            int k = scan.nextInt();
            System.out.println("checkRecord: " + checkRecord(k));
            System.out.println("checkRecordC: " + checkRecordC(k));
            System.out.println("checkRecordRec: " + checkRecordRec(k));
            n--;
        }
    }

    private static int checkRecordRec(int n) {
        int[][][] dp = new int[100001][2][3];
        IntStream.range(0, dp.length).forEach(i -> IntStream.range(0, dp[i].length).forEach(j -> Arrays.fill(dp[i][j], -1)));
        return solveI(n, 0, 0, dp);
    }

    private static int solveI(int n, int abs, int cons_late, int[][][] dp) {
        /*if (abs >= 2 || cons_late >= 3) {
            return 0;
        }
        if (n == 0) {
            return dp[n][abs][cons_late] = 1;
        }
        if (dp[n][abs][cons_late] != -1) {
            return dp[n][abs][cons_late];
        }
        int A = solveI(n - 1, abs + 1, 0, dp) % MOD;
        int L = solveI(n - 1, abs, cons_late + 1, dp) % MOD;
        int P = solveI(n - 1, abs, 0, dp) % MOD;

        return dp[n][abs][cons_late] = ((A + L) % MOD + P) % MOD;*/
        if (abs >= 2 || cons_late >= 3) {
            return 0;
        }

        if (n == 0)
            return 1;

        if (dp[n][abs][cons_late] != -1) {
            return dp[n][abs][cons_late];
        }

        int A = solveI(n - 1, abs + 1, 0, dp) % MOD;
        int L = solveI(n - 1, abs, cons_late + 1, dp) % MOD;
        int P = solveI(n - 1, abs, 0, dp) % MOD;

        return dp[n][abs][cons_late] = ((A + L) % MOD + P) % MOD;
    }

    private static int checkRecord(int n) {
        int[][][] dp = new int[n + 1][2][3];

        for (int i = 0; i <= n; i++) {
            for (int A = 0; A < 2; A++) {
                for (int L = 0; L < 3; L++) {
                    if (i == 0) {
                        dp[i][A][L] = 1;
                    } else {
                        int ans = (A == 0 ? dp[i - 1][A + 1][0] % MOD : 0);
                        ans = ans % MOD + (L < 2 ? dp[i - 1][A][L + 1] % MOD : 0);
                        ans = ans % MOD + dp[i - 1][A][0] % MOD;

                        dp[i][A][L] = ans % MOD;
                    }
                }
            }
        }

        return dp[n][0][0];
    }

    private static int checkRecordC(int n) {
        int M = 1000000007;
        int[][][] t = new int[n + 1][2][3];

        // Base Case - 0 number of days. So, t[0][A][L], we return 1
        for (int A = 0; A <= 1; ++A) {
            for (int L = 0; L <= 2; ++L) {
                t[0][A][L] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int A = 0; A <= 1; A++) {
                for (int L = 0; L <= 2; L++) {

                    long result = t[i - 1][A][0];            // P ---> solve(n-1, absent, 0) % M;
                    result += (L < 2 ? t[i - 1][A][L + 1] : 0);  // L ---> solve(n-1, absent, consecutive_late+1) % M;
                    result += (A == 0 ? t[i - 1][A + 1][0] : 0);  // A ---> solve(n-1, absent+1, 0) % M;

                    t[i][A][L] = (int) (result % M);
                }
            }
        }

        return t[n][0][0];
    }
}
