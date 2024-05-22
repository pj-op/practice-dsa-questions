package com.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CryptArithmeticAg {
    public static void main(String[] args) {
        String s1 = "SEND";
        String s2 = "MORE";
        String s3 = "MONEYS";
        solveCrypt(s1, s2, s3);
    }

    private static void solveCrypt(String s1, String s2, String s3) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> dataMap = prepareDataMap(Arrays.asList(s1, s2, s3), sb);
        boolean[] arr = new boolean[10];
        assignEachCharUniqueInt(arr, sb, 0, dataMap, s1, s2, s3);
    }

    private static void assignEachCharUniqueInt(boolean[] arr, StringBuilder sb, int idx, Map<Character, Integer> dataMap, String s1, String s2, String s3) {

        if (dataMap.get(s1.charAt(0)) == 0 || dataMap.get(s2.charAt(0)) == 0 || dataMap.get(s3.charAt(0)) == 0) {
            return;
        }

        if (idx == sb.length()) {
            int n1 = getNum(s1, dataMap);
            int n2 = getNum(s2, dataMap);
            int n3 = getNum(s3, dataMap);

            if (n1 + n2 == n3) System.out.println("n1 " + n1 + " + n2 " + n2 + " = " + n3);
            return;
        }

        char c = sb.charAt(idx);
        for (int i = 0; i <= 9; i++) {
            if (!arr[i]) {
                arr[i] = true;
                dataMap.put(c, i);
                assignEachCharUniqueInt(arr, sb, idx + 1, dataMap, s1, s2, s3);
                arr[i] = false;
                dataMap.put(c, -1);
            }
        }


    }

    private static Map<Character, Integer> prepareDataMap(List<String> strings, StringBuilder sb) {
        Map<Character, Integer> dataMap = new HashMap<>();
        for (String str : strings) {
            for (char c : str.toCharArray()) {
                if (!dataMap.containsKey(c)) {
                    dataMap.put(c, -1);
                    sb.append(c);
                }
            }
        }
        return dataMap;
    }

    private static int getNum(String str, Map<Character, Integer> dataMap) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            sb.append(dataMap.get(c));
        }
        return Integer.parseInt(sb.toString());
    }
}
