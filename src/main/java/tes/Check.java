package tes;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Check {
    public static void main(String[] args) {
        /*String[][] students = {
                {"Sarah", "91"},
                {"Goldie", "92"},
                {"Elaine", "93"},
                {"Elaine", "95"},
                {"Goldie", "94"},
                {"Sarah", "93"},
                {"pranjal", "10"},
                {"pranjal", "15"},
                {"pranjal", "15"},
        };

        Arrays.stream(students)
                .collect(Collectors.groupingBy(arr -> arr[0], Collectors.averagingDouble(arr -> Double.parseDouble(arr[1]))))
                .forEach((key, val) -> System.out.println(key + " -- " + val));*/

        /*List<String> names = List.of("pranjal", "puja", "rahul", "raj", "kamal");
        names
            .stream()
            .collect(Collectors.groupingBy(name -> name.charAt(0), Collectors.toList()))
            .values()
            .stream()
            .filter(entry -> entry.size() > 1)
            .flatMap(List::stream)
            .collect(Collectors.toMap(name -> name, String::length))
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(System.out::println);*/

        /*//Test Data
        List<Product> products = List.of(
                new Product("Laptop", 1000, "Electronics"),
                new Product("Headphones", 50, "Electronics"),
                new Product("Shirt", 20, "Clothing"),
                new Product("Dress", 30, "Clothing"),
                new Product("Book", 15, "Books")
        );
        // Group products by category and calculate average price
        products
                .stream()
                .collect(Collectors.groupingBy(prd -> prd.category, Collectors.averagingDouble(prd -> prd.price)))
                .forEach((k, v) -> System.out.println(k + " -- " + v));*/

        /*DoubleSummaryStatistics statistics = products
                .stream()
                .collect(Collectors.summarizingDouble(prd -> prd.price));
        System.out.println(statistics);*/

        /*IntStream.range(0, 100)
                .boxed()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0))
                .forEach((k, v) -> System.out.println(k + " " + v));*/

        /*var series = IntStream.range(2, 100)
                .filter(x -> IntStream.rangeClosed(2, (int) Math.sqrt(x))
                        .noneMatch(y -> x % y == 0))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println(series);*/

        /*Stream.iterate(new int[]{0, 1}, arr -> new int[]{arr[1], arr[0] + arr[1]})
                .map(arr -> String.valueOf(arr[0]).concat(" "))
                .limit(10)
                .forEach(System.out::print);*/

        /*String str = "aab";
        System.out.println(getAllPalindromicPartitions(str));*/

        String s1 = "SEND";
        String s2 = "MORE";
        String s3 = "MONEY";

        solveCryptQuestion(s1, s2, s3);
    }

    private static void solveCryptQuestion(String s1, String s2, String s3) {
        Map<Character, Integer> dataMap = new HashMap<>();

        List<String> list = List.of(s1, s2, s3);
        StringBuilder sb = new StringBuilder();

        populateMap(dataMap, list, sb);
        boolean[] isTaken = new boolean[10];

        solveIt(dataMap, sb, 0, isTaken, s1, s2, s3);
    }

    private static void solveIt(Map<Character, Integer> dataMap, StringBuilder sb, int index, boolean[] isTaken, String s1, String s2, String s3) {

        if (dataMap.get(s1.charAt(0)) == 0 || dataMap.get(s2.charAt(0)) == 0 || dataMap.get(s3.charAt(0)) == 0) {
            return;
        }

        if (index >= sb.length()) {
            int n1 = getNum(dataMap, s1);
            int n2 = getNum(dataMap, s2);
            int n3 = getNum(dataMap, s3);

            if (n1 + n2 == n3) {
                System.out.println("n1: " + n1 + " n2: " + n2 + " = n3: " + n3);
            }
            return;
        }

        char ch = sb.charAt(index);
        for (int i = 0; i < 10; i++) {
            if (!isTaken[i]) {
                isTaken[i] = true;
                dataMap.put(ch, i);
                solveIt(dataMap, sb, index + 1, isTaken, s1, s2, s3);
                dataMap.put(ch, -1);
                isTaken[i] = false;
            }
        }
    }

    private static int getNum(Map<Character, Integer> dataMap, String num) {
        StringBuilder sb = new StringBuilder();
        for (char ch : num.toCharArray()) {
            if (dataMap.containsKey(ch)) {
                sb.append(dataMap.get(ch));
            }
        }
        return Integer.parseInt(sb.toString());
    }

    private static void populateMap(Map<Character, Integer> dataMap, List<String> strs, StringBuilder sb) {
        for (String word : strs) {
            char[] chars = word.toCharArray();
            for (char ch : chars) {
                if (!dataMap.containsKey(ch)) {
                    dataMap.put(ch, -1);
                    sb.append(ch);
                }
            }
        }
    }

    private static List<List<String>> getAllPalindromicPartitions(String str) {
        List<List<String>> ans = new ArrayList<>();
        solveUsingRecursionAndBackTracking(str, 0, new ArrayList<>(), ans);
        return ans;
    }

    private static void solveUsingRecursionAndBackTracking(String str, int index, ArrayList<String> temp, List<List<String>> ans) {
        if (index >= str.length()) {
            ans.add(new ArrayList<>(temp));
        }

        for (int i = index; i < str.length(); i++) {
            if (isPalindrome(str, index, i)) {
                temp.add(str.substring(index, i + 1));
                solveUsingRecursionAndBackTracking(str, i + 1, temp, ans);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String str, int fromIndex, int toIndex) {
        while (fromIndex < toIndex) {
            if (str.charAt(fromIndex) != str.charAt(toIndex)) {
                return false;
            }
            fromIndex++;
            toIndex--;
        }
        return true;
    }
}

class Product {
    String name;
    double price;
    String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
}