package tes;

import java.util.*;

public class FindtheNumberofDistinctColorsAmongtheBalls {
    public static void main(String[] args) {
        /*int limit = 4;
        int[][] queries = {{0, 1}, {1, 2}, {2, 2}, {3, 4}, {4, 5}};
        System.out.println(Arrays.toString(queryResults(limit, queries)));*/

        String str = "catsanddog";
        List<String> wordDict = List.of("cat", "cats", "and", "sand", "dog");
        System.out.println(wordBreak(str, wordDict));

    }

    private static List<String> wordBreak(String str, List<String> wordDict) {
        if (str.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> ans = new ArrayList<>();
        for (int i = 1; i < str.length(); i++) {
            String tempString = str.substring(0, i + 1);

            if (wordDict.contains(tempString)) {
                String remword = str.substring(i + 1);
                List<String> leftWord = wordBreak(remword, wordDict);

                for (String word : leftWord) {
                    String wordToAdd = tempString + (word.isEmpty() ? "" : " ") + word;
                    ans.add(wordToAdd);
                }

            }
        }
        return ans;
    }

    public static int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];

        Map<Integer, List<Integer>> dataMap = new HashMap<>();

        int idx = 0;
        for (int[] query : queries) {
            if (dataMap.containsKey(query[1])) {
                List<Integer> lst = dataMap.get(query[1]);
                lst.add(query[0]);
                dataMap.put(query[1], lst);
                res[idx] = dataMap.size();
            } else {
                dataMap.put(query[1], new ArrayList<>(query[0]));
                res[idx] = dataMap.size();
            }
            idx++;
        }

        return res;
    }
}
