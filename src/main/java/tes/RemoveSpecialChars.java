package tes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RemoveSpecialChars {
    public static void main(String[] args) {
        String s = "Raam) Krishna@ La!xman Ra^m Kr#'ishna Raam";

        String modifiedS = removeSpecialChars(s);

        Map<String, Integer> freqMap = new HashMap<>();
        Arrays.stream(modifiedS.split(" "))
                .forEach(w -> freqMap.put(w, freqMap.getOrDefault(w, 0) + 1));

        System.out.println(freqMap);

    }

    private static String removeSpecialChars(String s) {
        String[] words = s.split(" ");

        StringBuilder ans = new StringBuilder();

        for (String word : words) {
            char[] chars = word.toCharArray();
            StringBuilder filteredWord = new StringBuilder();
            for (char c : chars) {
                if (Character.isAlphabetic(c)) {
                    filteredWord.append(c);
                }
            }
            ans.append(filteredWord).append(" ");
        }

        return ans.toString();
    }
}
