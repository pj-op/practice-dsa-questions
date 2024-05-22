package tes;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Parity {
    static List<List<Integer>> ans;
    static int res = 0;

    public static void main(String[] args) {
        /*
        int[] nums = {4, 3, 1, 6};
        int[] nums = {3, 7, 8};
        int[][] queries = {{0, 2}, {1, 2}};

        System.out.println(Arrays.toString(isArraySpecialII(nums, queries)));
         */

        /*int[] arr = new int[19];
        Random random = new Random();
        IntStream.range(0, arr.length).forEach(i -> arr[i] = random.nextInt(100));
        System.out.println(Arrays.toString(arr));
//        qs(arr);
//        ms(arr);
        System.out.println(Arrays.toString(arr));*/

        /*int[] arr = {5, 1, 6};

        Arrays.stream(arr)
                .reduce((a, b) -> a | b)
                .getAsInt();

        System.out.println(createAllSubArrays(arr));*/


        /* List<String> list = List.of("apple", "banana", "apple", "orange", "banana", "apple");*/
        /*String s = list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(","));*/

        /*Collections.max(
                list.stream()
                        .collect(Collectors.groupingBy(String::length, Collectors.toSet()))
                        .entrySet(), Map.Entry.comparingByKey()
        ).getValue().forEach(System.out::println);*/

        /*List<List<String>> nestedList = List.of(
                List.of("a", "b", "c"),
                List.of("ab", "bc", "cd"),
                List.of("abcd", "bcde", "cefg")
        );

        var s = nestedList
                .stream()
                .flatMap(List::stream)
                .mapToInt(String::length)
                .sum();*/

        /*String str = "banana";

        var s = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get();*/

        /*List<String> grpAnagrams = List.of("listen", "silent", "enlist", "google", "gooegl", "apple");

        grpAnagrams
                .stream()
                .collect(Collectors.groupingBy(Parity::anagram, Collectors.toList()))
                .forEach((key, value) -> System.out.println(key + " " + value));*/

        /*List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple", "banana", "banana", "orange");
        words.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
//                .skip(1)
                .forEach(System.out::println);*/

        /*//Cartesian Product
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5);

        list1.forEach(i -> list2.forEach(j -> System.out.println(i * j)));*/

        /*List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");
        strings.stream()
                .collect(Collectors.toMap(word -> word, String::length))
                .forEach((k, v) -> System.out.println(k + " " + v));*/

        /*List<String> rt = List.of("madam", "racecar", "apple", "level", "banana");
        rt.stream()
                .filter((word) -> new StringBuilder(word).reverse().toString().equals(word))
                .forEach(System.out::println);
//                .collect(Collectors.groupingBy(Parity::palindrome, Collectors.toList()))
//                .forEach((k, v) -> System.out.println(k + "  " + v));*/

        List<Integer> list = new ArrayList<>(List.of(1, 2, 5, 4, 9, 10, 3));
        list.sort(Integer::compare);
        System.out.println(list);
    }

    private static String palindrome(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    private static String anagram(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private static List<List<Integer>> createAllSubArrays(int[] arr) {
        ans = new ArrayList<>();
        solving(arr, 0, new ArrayList<>());
        System.out.println(res);
        return ans;
    }

    private static void solving(int[] arr, int index, ArrayList<Integer> temp) {
        if (index >= arr.length) {
            int x = 0;
            if (!temp.isEmpty()) {
                x = temp.stream().reduce((a, b) -> a ^ b).get();
            }
            res += x;
            return;
        }
        temp.add(arr[index]);
        solving(arr, index + 1, temp);
        temp.remove(temp.size() - 1);
        solving(arr, index + 1, temp);
    }

    private static void ms(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        IntStream.range(0, mid).forEach(idx -> left[idx] = arr[idx]);
        IntStream.range(mid, n).forEach(idx -> right[idx - mid] = arr[idx]);

        ms(left);
        ms(right);

        mergeSortedChunksAgain(arr, left, right);
    }

    private static void mergeSortedChunksAgain(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    private static void qs(int[] arr) {
        qs(arr, 0, arr.length - 1);
    }

    private static void qs(int[] arr, int lowerIndex, int highIndex) {
        if (lowerIndex >= highIndex) {
            return;
        }
        int pivot = arr[highIndex];
        int leftPointer = lowerIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (pivot > arr[leftPointer] && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (pivot <= arr[rightPointer] && leftPointer < rightPointer) {
                rightPointer--;
            }
            s(arr, leftPointer, rightPointer);
        }
        s(arr, leftPointer, highIndex);

        qs(arr, lowerIndex, leftPointer - 1);
        qs(arr, leftPointer + 1, highIndex);
    }

    private static void s(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    private static boolean[] isArraySpecialII(int[] nums, int[][] queries) {

        int qLength = queries.length;
        int nLength = nums.length;
        int ansIdx = 0;
        boolean[] ans = new boolean[qLength];

        if (nLength == 1) {
            Arrays.fill(ans, true);
            return ans;
        }

        for (int[] query : queries) {
            int upperLimit = query[0];
            int lowerLimit = query[1];

            if (upperLimit == lowerLimit) {
                ans[ansIdx] = true;
            } else {
                for (int j = upperLimit; j + 1 <= lowerLimit && j + 1 < nLength; j++) {
                    if (nums[j] % 2 != 0 && nums[j + 1] % 2 != 0) {
                        ans[ansIdx] = false;
                        break;
                    } else if (nums[j] % 2 == 0 && nums[j + 1] % 2 == 0) {
                        ans[ansIdx] = false;
                        break;
                    } else if ((nums[j] % 2 != 0 && nums[j + 1] % 2 == 0) || (nums[j] % 2 == 0 && nums[j + 1] % 2 != 0)) {
                        ans[ansIdx] = true;
                        break;
                    }

                }
            }
            ansIdx++;
        }

        return ans;
    }

    public static boolean isArraySpecial(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return true;
        }

        int i = 1;

        while (i < n) {
            System.out.println(nums[i] + " " + nums[i - 1]);
            if (nums[i] % 2 != 0 && nums[i - 1] % 2 != 0) {
                return false;
            }
            if (nums[i] % 2 == 0 && nums[i - 1] % 2 == 0) {
                return false;
            }
            i++;
        }
        return true;
    }
}
