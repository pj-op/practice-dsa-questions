package tes;

import java.util.*;
import java.util.stream.Collectors;

public class TestingPrb {
    static List<List<Integer>> allSubSets;

    public static void main(String[] args) {
        String str = "This is Pranjal Soni I am from Sagar MP complex";

        System.out.println(findMaxLengthWord(str));

        /*int[][][] myNumbers = {{{1, 2, 3, 4}}, {{5, 6, 7}}};

        int sum = Arrays.stream(myNumbers)
                .flatMap(Arrays::stream)
                .flatMapToInt(Arrays::stream)
                .sum();
        System.out.println(sum);*/

//        Employee:
//            E1 - Mumbai
//            E2 - Pune
//            E3 - Nasik
        /*
        select * from Employee e where e.city IN(M,P,N)
        union ALL
        select * from Employee e order by e.city ASC;
        */

        /*List<String> list = List.of("war", "pat", "tap", "run", "raw", "apt");
        List<List<String>> ans = new ArrayList<>();
        list
                .stream()
                .collect(Collectors.groupingBy(TestingPrb::sortString, Collectors.toList()))
                .forEach((k, v) -> ans.add(new ArrayList<>(v)));
        System.out.println(ans);*/

        /*int[] nums = {3, 1};
        System.out.println(countMaxOrSubsets(nums));*/

        String[][] students = {
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
                .collect(Collectors.groupingBy(arr -> arr[0].toLowerCase(), Collectors.averagingDouble(arr -> Double.parseDouble(arr[1]))))
                .forEach((k, v) -> System.out.println(k + " -- " + v));

        Map<String, Double> studentMarks = new HashMap<>();
        for (String[] student : students) {
            studentMarks.merge(student[0], Double.parseDouble(student[1]), (a, b) -> (a + b) / 2);
        }
        System.out.println(studentMarks);
    }

    private static String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private static List<String> findMaxLengthWord(String str) {
        /*return Arrays.stream(str.split(" "))
                .max(Comparator.comparingInt(String::length))
                .orElse(null);*/

        return Collections.max(Arrays.stream(str.split(" "))
                .collect(Collectors.groupingBy(String::length, Collectors.toList()))
                .entrySet(), Map.Entry.comparingByKey()).getValue();


    }

    public static int countMaxOrSubsets(int[] nums) {
        int maxOr = Integer.MIN_VALUE;
        allSubSets = new ArrayList<>();
        int count = 0;
        solve(0, nums, new ArrayList<>());

        for (List<Integer> list : allSubSets) {
            int currOr = list.stream().reduce((a, b) -> a | b).orElse(0);
            if (maxOr < currOr) {
                maxOr = currOr;
            }
            if (maxOr == currOr) {
                count++;
            }
        }

        return count;
    }

    private static void solve(int index, int[] nums, ArrayList<Integer> temp) {
        if (index >= nums.length) {
            if (!allSubSets.contains(temp)) {
                allSubSets.add(new ArrayList<>(temp));
            }
            return;
        }
        temp.add(nums[index]);
        solve(index + 1, nums, temp);
        temp.remove(temp.size() - 1);
        solve(index + 1, nums, temp);
    }

}
