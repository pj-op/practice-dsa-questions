package com.exp;

import java.util.HashMap;
import java.util.Map;

abstract class Test {
    static int i = 102;

    static void TestMethod() {
        System.out.println("hi !! I am good !!");
    }
}

public class TestIt {
    public static void main(String[] args) {
        Test.TestMethod();
        var i = Test.i;
        System.out.println(i);
        Map map = new HashMap<>();
    }
}
