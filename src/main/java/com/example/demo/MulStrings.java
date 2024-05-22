package com.example.demo;

public class MulStrings {
    public static void main(String[] args) {
        String s1 = "1234";
        String s2 = "400";
        System.out.println(mulStrings(s1, s2));
    }

    private static String mulStrings(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[] res = new int[l1 + l2];
        int pf = 0;
        int i = l1 - 1;
        while (i >= 0) {
            int iVal = s1.charAt(i) - '0';
            i--;
            int carry = 0;
            int k = res.length - 1 - pf;
            int j = l2 - 1;
            while (j >= 0 || carry != 0) {
                int jVal = j >= 0 ? s2.charAt(j) - '0' : 0;
                j--;
                int prod = iVal * jVal + res[k] + carry;
                res[k] = prod % 10;
                carry = prod / 10;
                k--;
            }
            pf++;
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int a : res) {
            if (!flag && a == 0) continue;
            else {
                flag = true;
                sb.append(a);
            }
        }
        return sb.toString();
    }
}
