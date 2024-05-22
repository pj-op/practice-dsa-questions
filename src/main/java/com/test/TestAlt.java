package com.test;

public class TestAlt {
    public static void main(String[] args) {
        notifyMe(null);
    }

    public static void notifyMe(Object obj) {
        System.out.println("Inside object method");
    }

    public static void notifyMe(String str) {
        System.out.println("Inside String method");
    }
}