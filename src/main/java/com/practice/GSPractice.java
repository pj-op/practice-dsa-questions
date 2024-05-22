package com.practice;

import java.util.*;
import java.util.stream.IntStream;

public class GSPractice {
    public static void main(String[] args) {
//        String s1 = "abbccde"; int len = 2;
//        System.out.println(generateAllUniqeTuplesOfGivenLength(s1, len));
//        int[] arr = {1, 2, 0};
//        System.out.println(countLengthOfCycle(arr, 0));

        //TODO: First Non repeating character in the given String
        System.out.println(
                findFirstNonRepeatingCharFromTheString("aabbccd") == 'd'
                        && findFirstNonRepeatingCharFromTheString("abbccddee") == 'a'
                        && findFirstNonRepeatingCharFromTheString("iijjkkllmm") == ' '
        );

    }

    private static char findFirstNonRepeatingCharFromTheString(String inputString) {
        int[] freq = new int[26];

        for (char c : inputString.toCharArray()) {
            freq[c - 'a']++;
        }
        int idx = 0;
        for (char c : inputString.toCharArray()) {
            if (freq[c - 'a'] == 1) return c;
            idx++;
        }

        return ' ';
    }

    private static int countLengthOfCycle(int[] arr, int startIndex) {
        int[] res = new int[arr.length];
        int count = 0;
        int index = startIndex;

        while (res[index] == 0) {
            res[index] = ++count;
            index = arr[index];
        }

        return count - res[index] + 1;
    }

    private static Set<String> generateAllUniqeTuplesOfGivenLength(String s, int len) {
        int n = s.length();
        Set<String> ans = new HashSet<>();
        IntStream.range(0, n).forEach(i -> {
            if (i + len < n) {
                ans.add(s.substring(i, i + len));
            }
        });

        return ans;
    }
}
