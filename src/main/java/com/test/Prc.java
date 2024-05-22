package com.test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prc implements Int1, Int2 {
    public static void main(String[] args) {
//        streamsTest();
//1-20
//        streamAPITest();
        new Prc().m1();
        /*System.out.println("test" + 10 + 20);
        System.out.println(10 + 20 + "test");
        System.out.println("test" + 10 * 20);
        System.out.println(10 * 20 + "test");*/

    }

    @Override
    public void m1() {
        Int2.super.m1();
    }

    private static void streamAPITest() {

        /*//Even
        IntStream.rangeClosed(1, 20).filter(i -> i % 2 == 0).forEach(System.out::println);

        System.out.println("==================");

        //Odd
        IntStream.rangeClosed(1, 20).filter(i -> i % 2 != 0).forEach(System.out::println);*/

        /*String name = "banana";

        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : name.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }*/


    }
}

interface Int1 {
    default void m1() {
        System.out.println("this is m1 from int1 method");
    }
}

interface Int2 {
    default void m1() {
        System.out.println("this is m1 from int2 method");
    }
}

interface Func1 {
    void method();
}

interface Func2 extends Func1 {
    void method1();
}