package tes;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class FreqMapOfChars {
    public static void main(String[] args) {
        /*String str = "AVBSEAAAGHAAERAAA";
        System.out.println(calculateFreq(str));*/

        int[] arr =
                {1, 2, 3, 4}
//                {-1, 1, 0, -3, 3}
                ;
        System.out.println(Arrays.toString(productOfArrayExceptSelfU(arr)));
    }

    private static int[] productOfArrayExceptSelfU(int[] arr) {
        int prod = 1;
        int n = arr.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = prod;
            prod *= arr[i];
        }

        prod = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * prod;
            prod *= arr[i];
        }

        return ans;
    }

    private static int[] productOfArrayExceptSelf(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int[] prefProd = new int[n];
        int[] suffProd = new int[n];

        prefProd[0] = arr[0];
        IntStream.range(1, n).forEach(i -> prefProd[i] = arr[i] * prefProd[i - 1]);

        suffProd[n - 1] = arr[n - 1];
        IntStream.range(1, n).forEach(i -> suffProd[n - i - 1] = arr[n - i - 1] * suffProd[n - i]);

        ans[0] = suffProd[1];
        ans[n - 1] = prefProd[n - 2];
        for (int i = 1; i < n - 1; i++) {
            ans[i] = suffProd[i + 1] * prefProd[i - 1];
        }

        return ans;
    }

    private static Map.Entry<Character, Integer> calculateFreq(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        return Collections.max(freqMap.entrySet(), Map.Entry.comparingByValue());
    }
}
