package mt;

import java.util.*;

public class TestThis {
    public static void main(String[] args) {
        /*
        String s = "Java is a funny language and I love java";
        //avaJ
        StringBuilder ans = new StringBuilder();
        Arrays.stream(s.split(" ")).map(sf -> new StringBuilder(sf).reverse()).forEach(ele -> ans.append(ele).append(" "));
        System.out.println(ans);
        */

        /*int[] apple = {5, 5, 5};
        int[] capacity = {2, 4, 2, 7};
        System.out.println(minimumBoxes(apple, capacity));*/

        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        int[] freq = new int[1001];
        List<Integer> ans = new ArrayList<>();

        for (int ele : nums1) {
            if (freq[ele] == 0) {
                freq[ele]++;
            }
        }

        for (int ele : nums2) {
            if (freq[ele] == 1) {
                freq[ele]++;
                ans.add(ele);
            }
        }

        int[] res = new int[ans.size()];
        int index = 0;
        for (int ele : ans) {
            res[index++] = ele;
        }

        return res;
    }

    private static int minimumBoxes(int[] apple, int[] capacity) {

        Arrays.sort(capacity);

        int totalApples = 0;
        for (int ele : apple) {
            totalApples += ele;
        }

        int ans = 1;
        int totalCapacity = 0;
        for (int k = capacity.length - 1; k >= 0; k--) {
            totalCapacity += capacity[k];
            if (totalCapacity >= totalApples) {
                return ans;
            } else {
                ++ans;
            }
        }


        return ans;
    }

    private static String reverseStr(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}
