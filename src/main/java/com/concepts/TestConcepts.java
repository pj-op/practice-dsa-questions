package com.concepts;

interface TestInterface {
    void m2();
    private void m1() {
        System.out.println("this is private method interface");
    }
    default void m4() {
        System.out.println("This is default interface method");
    }
    static void m5() {
        System.out.println("This is interface static method");
    }
    private static void m3() {
        System.out.println("This is static void interface method");
    }
}

public class TestConcepts implements TestInterface {

    @Override
    public void m2() {
        System.out.println("Inside the implemented method");
    }

   /* @Override
    public void m4() {
        System.out.println("Inside m4 implemented method");
    }*/

    public static void main(String[] args) {
        new TestConcepts().m2();
        TestInterface.m5();
    }
}