package tes;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
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