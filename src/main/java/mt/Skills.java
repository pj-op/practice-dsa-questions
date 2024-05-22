package mt;

import java.util.*;
import java.util.stream.Collectors;

public class Skills {
    public static void main(String[] args) {
        int[] skills =
//                {4, 2, 3, 1};
                {4, 2, 7, 3, 1, 8, 6, 5};
//        System.out.println(Arrays.toString(testSkillsForRound(skills)));

        List<String> words = Arrays.asList("amazing", "give", "amagniz", "am", "help", "code");
        Collections.sort(words);
        System.out.println(words);


    }


    private static int[] testSkillsForRound(int[] skills) {
        int n = skills.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        if (n == 2) return ans;

        int round = n / 2;
        Map<Integer, Integer> indexMap = new HashMap<>();

        int index = 0;
        for (int ele : skills) {
            indexMap.put(ele, index);
            index++;
        }

        while (round > 1) {
            for (int i = 1; i < n; i += 2) {
                if (skills[i] != 0 && skills[i - 1] != 0) {
                    if (skills[i] > skills[i - 1]) {
                        ans[indexMap.get(skills[i])]++;
                        skills[i - 1] = 0;
                    } else {
                        ans[indexMap.get(skills[i - 1])]++;
                        skills[i] = 0;
                    }
                }
            }
            int k = 0;
            int j = 0;
            while (k < n && j < n) {
                if (skills[k] != 0) {
                    skills[j++] = skills[k];
                }
                k++;
            }
            if (j == 2) break;
            while (j < n) {
                skills[j++] = 0;
            }
            round--;
        }
        return ans;
    }
}
