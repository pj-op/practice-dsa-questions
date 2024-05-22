package tes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseEachWord {
    public static void main(String[] args) {
        String s = "pranjal soni java developer";
        //lajnarp inos avja re
        StringBuilder res = new StringBuilder();

        Arrays.stream(s.split(" "))
                .forEach(word -> res.append(new StringBuilder(word).reverse()).append(" "));


        System.out.println(res);

        //list of employee
        //Employee - id name salary age gender -> Gender wise avg salary
        //op : male - 6000, female - 7000

        List<Employee> employees = List.of(
                new Employee(2, "kelly", 20, "female", 3000),
                new Employee(3, "vikram", 20, "female", 2500),
                new Employee(6, "saksham", 20, "female", 2900),
                new Employee(8, "kinder", 20, "female", 2000),
                new Employee(1, "pranjal", 20, "male", 2000),
                new Employee(4, "arjun", 20, "male", 2000),
                new Employee(5, "roha", 20, "male", 2000),
                new Employee(7, "sakila", 20, "male", 2000)
        );

        employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getSalary)))
                .forEach((key, value) -> System.out.println(key + " " + value));


        /* int[] nums1 = {4, 20, 16, 12, 8}, nums2 = {14, 18, 10};
        System.out.println(minimumAddedInteger(nums1, nums2));*/

        /*String sent = "My name is Pranjal soni";
        System.out.println(reverseOddPositionWordsInSentence(sent));
*/
        /*String s = "pranjal";
        System.out.println(revStr(s, 0, 3));
*/

    }

    private static String revStr(String s, int first, int second) {
        int n = s.length();
        char[] chars = s.toCharArray();

        while (first < second && first >= 0 && second <= n - 1) {
            char c = chars[first];
            chars[first] = chars[second];
            chars[second] = c;

            first++;
            second--;
        }

        return String.valueOf(chars);
    }

    private static String reverseOddPositionWordsInSentence(String sentence) {
        //My name is Pranjal soni
        //0   1   2   3      4
        String[] words = sentence.split(" ");

        IntStream.range(0, words.length).filter(i -> i % 2 != 0)
                .forEach(idx -> words[idx] = new StringBuilder(words[idx]).reverse().toString());

//        System.out.println(Integer.parseInt("1001", 2));
//        System.out.println('a' ^ 'b');

        return Arrays.stream(words).reduce((a, b) -> a.concat(" ").concat(b)).get();

    }

    public static int minimumAddedInteger(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index = 0;
        int result = Integer.MAX_VALUE;
        int n1 = nums1.length;
        int n2 = nums2.length;

        while (index >= n1 - 2) {
            int diff = 0;
            for (int i = 0; i < n2; i++) {
                int absDiff = Math.abs(nums1[i] - nums2[i]);

            }

            index++;
        }

        return result;
    }
}

@Getter
@Setter
@AllArgsConstructor
class Employee {
    private int id;
    private String name;
    private int age;
    private String gender;
    private int salary;

}