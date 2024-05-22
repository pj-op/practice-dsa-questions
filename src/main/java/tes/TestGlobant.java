package tes;

import java.util.*;
import java.util.stream.Collectors;

public class TestGlobant {
    public static void main(String[] args) {
        /*
        String s = "Ab,c,de!$";
//        Abcde - edcbA
//        Output: ed,c,bA!$
        int i = 0;
        int j = s.length() - 1;
        char[] chars = s.toCharArray();

        while (i < j) {
            if (!Character.isAlphabetic(chars[i])) {
                i++;
            } else if (!Character.isAlphabetic(chars[j])) {
                j--;
            } else {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
                i++;
                j--;
            }
        }

        System.out.println(String.valueOf(chars).equals("ed,c,bA!$"));
         */

        int[] arr = new int[8];

        List<String> names = List.of("pranjal", "puja", "pankaj", "rahul", "raja", "anuj");
        names.stream()
//                .filter(name -> name.startsWith("p"))
                .collect(Collectors.groupingBy(n -> n.charAt(0), Collectors.toList()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() > 1)
                .forEach(entry -> entry.getValue()
                        .stream()
                        .collect(Collectors.toMap(word -> word, String::length))
                        .forEach((k, v) -> System.out.println(k + " " + v)));
    }
}
