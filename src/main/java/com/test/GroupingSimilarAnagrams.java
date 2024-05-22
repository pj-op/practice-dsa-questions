package com.test;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingSimilarAnagrams {
    public static void main(String[] args) {
        /*List<String> list = List.of("cat", "dog", "god", "tac", "roe", "reo");
        System.out.println(groupUsingStreams(list));*/
        /*String s = "mynameispranjalsoni";
        System.out.println(sortingUsingFreqArray(s));*/

        System.out.println(guessNumber(10));
    }


    public static int guessNumber(int n) {
        if (guess(n) == 0) {
            return n;
        }
        return guess(n) > 0 ? guessNumber(n - 1) : guessNumber(n + 1);
    }

    private static int guess(int n) {
        return Integer.compare(n, 20);
    }

    private static String sortingUsingFreqArray(String s) {
        int[] freq = new int[26];
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < freq.length; i++) {
            while (freq[i] != 0) {
                sb.append((char) (i + 'a'));
                freq[i]--;
            }
        }

        return sb.toString();
    }

    private static Map<String, List<String>> groupUsingStreams(List<String> list) {
        Map<String, List<String>> result = new HashMap<>();
        list.forEach(word -> {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            result.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
        });
        return result;
    }

    private static Set<Set<String>> group(List<String> words) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String nWord = new String(chars);

            if (!map.containsKey(nWord)) {
                map.put(nWord, new ArrayList<>());
                map.get(nWord).add(word);
            } else {
                map.get(nWord).add(word);
            }

        }

        System.out.println(map);

        return null;
    }

}
