package com.test;

import java.util.HashMap;

public class TestApp {
    public static void main(String[] args) {
        String s1 = "John";
        String s2 = new String("John");
        HashMap<String, Integer> map = new HashMap<>();
        map.put(s1, 20);
        map.put(s2, 30);
        System.out.println(map);
        System.out.println(map.size()); //1 - As the equals has same contents

        Employee emp1 = new Employee("john", 20);
        Employee emp2 = new Employee("john", 20);
        HashMap<Employee, Integer> mapEmp = new HashMap<>();
        mapEmp.put(emp1, 20);
        mapEmp.put(emp2, 20);
        System.out.println(mapEmp.size()); // Since we did not override the equals and hashcode output will be: 2


    }
}

class Employee {
    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

}



