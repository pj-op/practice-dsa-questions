package com.example.demo;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class StreamsTest {
    public static void main(String[] args) {
        StreamsTest streamsTest = new StreamsTest();
        streamsTest.solution();

        Comparator<Integer> myComparator = Integer::compareTo;
        // <0
        // >0
        //  0

        String s1 = "John";
        String s2 = new String("John");
        HashMap<String, Integer> map = new HashMap<>();
        map.put(s1, 20);
        map.put(s2, 30);

        System.out.println(s1.equals(s2));

        System.out.println(s1.hashCode() == s2.hashCode());

        System.out.println(map.size()); // 1


        class Employee {
            String name;
            int age;

            public Employee(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Employee employee = (Employee) o;

                if (age != employee.age) return false;
                return name.equals(employee.name);
            }

            @Override
            public int hashCode() {
                int result = name.hashCode();
                result = 31 * result + age;
                return result;
            }
        }


        Employee emp1 = new Employee("john", 20);
        Employee emp2 = new Employee("john", 20);
        HashMap<Employee, Integer> mapEmp = new HashMap<>();
        mapEmp.put(emp1, 20);
        mapEmp.put(emp2, 20);
        System.out.println(mapEmp.size()); //2


    }

    private void solution() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("AAA", 111, "D1", 1000));
        employees.add(new Employee("BBB", 222, null, 2000));
        employees.add(new Employee("CCC", 333, "D2", 3000));
        employees.add(new Employee("DDD", 444, "D3", 4000));
        employees.add(new Employee("EEE", 555, "D2", 5000));
        employees.add(new Employee("FFF", 666, "D2", 6000));

        employees.stream()
                .filter(employee -> employee.getName().startsWith("A"))
                .forEach(System.out::println);

        //System.out.println(employees);
        //TODO print employee names belongs to dept "D2" -  using streams functions
        var collect = employees.stream()
                .filter(employee -> "D2".equals(employee.deptno))
                .map(emp -> emp.name)
                .collect(Collectors.toList());
//                .forEach(emp -> //System.out.println(emp.name));
        //System.out.println(collect);

        //TODO Print the sum of all employees salaries using streams -  expected to print 21000
        int sal = employees.stream()
//                .filter(employee -> "D2".equals(employee.deptno))
                .mapToInt(Employee::getSalary)
                .sum();
        //System.out.println(sal);

        //TODO Given a sentence find the word that has the highest length using Streams. expected to print "Welcome"
        String input = " Welcome to Java world";
        String output = Arrays.stream(input.split(" "))
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
        //System.out.println(output);

        //TODO Should print most repeated number from the array, using streams or Java 7 features... 
        // number 5 repeated most of the (3)times, Should print 5 and not 3
        int[] arr = {5, 7, 5, 7, 5, 2, 7, 7};
        Map<Integer, Integer> dataMap = new HashMap<>();

        Map.Entry<Integer, Long> maxEntry = Collections.max(
                Arrays.stream(arr)
                        .boxed()
                        .collect(Collectors.groupingBy(num -> num, Collectors.counting()))
                        .entrySet(), Map.Entry.comparingByValue());
        System.out.println(maxEntry.getKey());

        /*int maxFreq = 0;
        for (int val : dataMap.values()) {
            maxFreq = Math.max(maxFreq, val);
        }
        for (Map.Entry<Integer, Integer> entry : dataMap.entrySet()) {
            if (entry.getValue() == maxFreq) {
                //System.out.println(entry.getKey());
                break;
            }
        }*/


//        //System.out.println(dataMap);
//ifPresent()


        //Optional example
        if (employees == null) {
            throw new RuntimeException();
        } else {
//            processEmp(employees);
        }

    }

    private void processEmp(Optional<List<Employee>> employees) {

//        Single Response , Open clo, L, ID
//        Junit refresher
//

    }

    private class Employee {

        private String name;
        private int id;
        private String deptno;
        private int salary;
        private List<String> addresses;


        public Employee(String name, int id, String deptno, int salary) {
            this.name = name;
            this.id = id;
            this.deptno = deptno;
            this.salary = salary;
        }


        @Override
        public String toString() {
            return name + "::" + id + "::" + deptno + "::" + salary;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public String getDeptno() {
            return deptno;
        }

        public int getSalary() {
            return salary;
        }


    }

}