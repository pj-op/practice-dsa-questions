package com.practice;

import java.util.*;
import java.util.stream.IntStream;

public class SortingAlgos {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        IntStream.range(0, arr.length).forEach(i -> arr[i] = random.nextInt(100));
//        System.out.println(Arrays.toString(arr));
//        selectSort(arr);
//        insertSorting(arr);
//        quickSort(arr);
//        merSort(arr);
//        bubSort(arr);
//        countSort(arr);
//        radixSort(arr);
//        insertionSortModified(arr);
//        System.out.println(Arrays.toString(arr));
        String s1 = "12534152436123";
        String s2 = "400";
//        multiplyStrings(s1, s2);

//        System.out.println(Arrays.toString(maxSumSubArray(arr)));
        int rs = 5;
        int[] coins = {1, 2, 5};
//        System.out.println(coinChange(rs, coins));

        String str1 = "SEND", str2 = "MORE", str3 = "MONEY";
//        String str1 = "BASE", str2 = "BALL", str3 = "GAMES";
//        String str1 = "BBAT", str2 = "YELL", str3 = "YETI";
        cryptSolve(str1, str2, str3);

    }

    private static void cryptSolve(String str1, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> numCharMap = new HashMap<>();
        List<String> strings = Arrays.asList(str1, str2, str3);
        populateMap(numCharMap, strings, sb);
        boolean[] usedNum = new boolean[10];
        solve(sb, 0, usedNum, numCharMap, str1, str2, str3);
    }

    private static void solve(StringBuilder uniqueString, int idx, boolean[] usedNum, Map<Character, Integer> numCharMap, String str1, String str2, String str3) {
        if (numCharMap.get(str1.charAt(0)) == 0 || numCharMap.get(str2.charAt(0)) == 0 || numCharMap.get(str3.charAt(0)) == 0)
            return;
        if (idx == uniqueString.length()) {
            int n1 = getNum(str1, numCharMap);
            int n2 = getNum(str2, numCharMap);
            int n3 = getNum(str3, numCharMap);
            if (n1 + n2 == n3) System.out.println("n1: " + n1 + ", n2: " + n2 + ", n3: " + n3);
            return;
        }
        char ch = uniqueString.charAt(idx);
        for (int i = 0; i <= 9; i++) {
            if (!usedNum[i]) {
                usedNum[i] = true;
                numCharMap.put(ch, i);
                solve(uniqueString, idx + 1, usedNum, numCharMap, str1, str2, str3);
                usedNum[i] = false;
                numCharMap.put(ch, -1);
            }
        }
    }

    private static int getNum(String num, Map<Character, Integer> numCharMap) {
        StringBuilder sb = new StringBuilder();
        for (char ch : num.toCharArray()) {
            sb.append(numCharMap.get(ch));
        }
        return Integer.parseInt(sb.toString());
    }

    private static void populateMap(Map<Character, Integer> numCharMap, List<String> strings, StringBuilder sb) {
        for (String str : strings) {
            int left = 0;
            while (left < str.length()) {
                char ch = str.charAt(left++);
                if (!numCharMap.containsKey(ch)) {
                    numCharMap.put(ch, -1);
                    sb.append(ch);
                }
            }
        }
    }

    private static int coinChange(int rs, int[] coins) {
        int[] dp = new int[rs + 1];
        for (int coin : coins) {
            dp[0] = 1;
            for (int i = coin; i < dp.length; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[rs];
    }

    private static void insertionSortModified(int[] arr) {
        int n = arr.length;
        int gap = arr.length / 2;
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int minVal = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > minVal) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = minVal;
            }
            gap /= 2;
        }
    }

    private static int[] maxSumSubArray(int[] arr) {

        int sum = 0;
        int ansJ = -1;
        int ansI = -1;
        int startI = -1;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (sum == 0) {
                startI = i;
            }
            sum += arr[i];
            if (sum > maxSum) {
                maxSum = sum;
                ansI = startI;
                ansJ = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }

        int idx = 0;
        int[] ans = new int[ansJ - ansI + 1];

        for (int i = ansI; i <= ansJ; i++) {
            ans[idx++] = arr[i];
        }

        return ans;
    }

    private static void multiplyStrings(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[] res = new int[l1 + l2];

        int pf = 0;
        int i = l1 - 1;

        while (i >= 0) {
            int iVal = s1.charAt(i) - '0';
            i--;

            int carry = 0;
            int j = l2 - 1;
            int k = res.length - 1 - pf;
            while (j >= 0 || carry != 0) {
                int jVal = j >= 0 ? s2.charAt(j) - '0' : 0;
                j--;

                int prod = iVal * jVal + carry + res[k];
                carry = prod / 10;
                res[k] = prod % 10;
                k--;
            }
            pf++;
        }
        boolean flag = false;
        StringBuilder sb = new StringBuilder();

        for (int ele : res) {
            if (ele == 0 && !flag) continue;
            else {
                flag = true;
                sb.append(ele);
            }
        }

        System.out.println(sb.toString());
    }

    private static void radixSort(int[] arr) {
        int exponent = 1;
        int maxElement = Integer.MIN_VALUE;

        for (int ele : arr) maxElement = Math.max(maxElement, ele);

        while (exponent <= maxElement) {
            countingSortThis(arr, exponent);
            exponent *= 10;
        }
    }

    private static void countingSortThis(int[] arr, int exponent) {
        int[] ans = new int[arr.length];
        //preparing freq Array
        int[] freqArray = new int[10];

        for (int ele : arr) freqArray[ele / exponent % 10]++;

        //Suffix Sum
        for (int i = freqArray.length - 2; i >= 0; i--) {
            freqArray[i] = freqArray[i] + freqArray[i + 1];
        }

        for (int ele : arr) {
            int index = freqArray[ele / exponent % 10] - 1;
            if (index >= 0) {
                ans[index] = ele;
                freqArray[ele / exponent % 10]--;
            }
        }

        System.arraycopy(ans, 0, arr, 0, arr.length);

    }

    private static void countSort(int[] arr) {
        int[] res = new int[arr.length];
        int minElement = Integer.MAX_VALUE;
        int maxElement = Integer.MIN_VALUE;

        for (int ele : arr) {
            minElement = Math.min(minElement, ele);
            maxElement = Math.max(maxElement, ele);
        }
        //Preparing freqArray
        int[] freqArray = new int[maxElement - minElement + 1];

        for (int ele : arr) {
            freqArray[ele - minElement]++;
        }
        //Suffix Sum
        for (int i = freqArray.length - 2; i >= 0; i--) {
            freqArray[i] = freqArray[i] + freqArray[i + 1];
        }

        for (int ele : arr) {
            int index = freqArray[ele - minElement] - 1;
            if (index >= 0) {
                res[index] = ele;
                freqArray[ele - minElement]--;
            }
        }
        System.arraycopy(res, 0, arr, 0, arr.length);
    }

    private static void bubSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) swappingArrayElements(arr, i, j);
            }
        }
    }

    private static void merSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;

        int[] leftArray = new int[mid];
        int[] rightArray = new int[arr.length - mid];

        IntStream.range(0, mid).forEach(i -> leftArray[i] = arr[i]);
        IntStream.range(mid, arr.length).forEach(i -> rightArray[i - mid] = arr[i]);

        merSort(leftArray);
        merSort(rightArray);

        mergingSmallChunksInSortedOrder(arr, leftArray, rightArray);
    }

    private static void mergingSmallChunksInSortedOrder(int[] arr, int[] leftArray, int[] rightArray) {
        int i = 0, j = 0, k = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] > rightArray[j]) arr[k++] = leftArray[i++];
            else arr[k++] = rightArray[j++];
        }
        while (i < leftArray.length) arr[k++] = leftArray[i++];
        while (j < rightArray.length) arr[k++] = rightArray[j++];
    }

    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) return;
        //Choosing the pivot
        int pivot = arr[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        while (leftPointer < rightPointer) {
            while (arr[leftPointer] > pivot && leftPointer < rightPointer) leftPointer++;
            while (arr[rightPointer] <= pivot && leftPointer < rightPointer) rightPointer--;
            swappingArrayElements(arr, leftPointer, rightPointer);
        }
        swappingArrayElements(arr, highIndex, leftPointer);

        quickSort(arr, lowIndex, leftPointer - 1);
        quickSort(arr, leftPointer + 1, highIndex);
    }

    private static void insertSorting(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int maxVal = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j + 1] < maxVal) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = maxVal;
        }
    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int maxPosition = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[maxPosition]) maxPosition = j;
            }
            if (i != maxPosition) swappingArrayElements(arr, i, maxPosition);
        }
    }

    private static void swappingArrayElements(int[] inputArray, int firstIndex, int secondIndex) {
        int temp = inputArray[firstIndex];
        inputArray[firstIndex] = inputArray[secondIndex];
        inputArray[secondIndex] = temp;
    }
}
