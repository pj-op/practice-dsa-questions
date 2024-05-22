package com.arr;

import java.util.*;

public class FindKMostOccuringElementsInGivenArray {
    public static void main(String[] args) {
        int[] arr = {2, 2, 8};
        int k = 2;

//        System.out.println(Arrays.toString(print_N_mostFrequentNumber(arr, k)));

        int[] nums = {2, 0, 2, 1, 1, 0};
        System.out.println(Arrays.toString(sortColors(nums)));
    }

    private static int[] print_N_mostFrequentNumber(int[] arr, int k) {
        int minEle = Integer.MAX_VALUE;
        int maxEle = Integer.MIN_VALUE;
        Map<Integer, Integer> mp = new HashMap<>();

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int ele : arr) {
            minEle = Math.min(ele, minEle);
            maxEle = Math.max(ele, maxEle);
        }

        int[] freqArr = new int[maxEle - minEle + 1];
        for (int ele : arr) {
            freqArr[ele - minEle]++;
        }

        for (int i = 0; i < freqArr.length; i++) {
            if (freqArr[i] >= k) {
                mp.put(freqArr[i], i + minEle);
            }
        }

        return mp.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .mapToInt(Map.Entry::getValue).toArray();
    }

    public static int[] sortColors(int[] nums) {
        //Creating freq Array
        int[] freqArray = new int[3];

        for (int ele : nums) {
            freqArray[ele]++;
        }

        int idx = 0;
        for (int i = 0; i < freqArray.length; i++) {
            while (freqArray[i] > 0) {
                nums[idx++] = i;
                freqArray[i]--;
            }
        }

        return nums;
    }
}
