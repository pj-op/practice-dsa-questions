package tes;

import lombok.ToString;

import java.util.*;
import java.util.stream.IntStream;

public class Arrasrs {
    public static void main(String[] args) {
        //Input: A[] = { 6, 4, 12, 10, 22, 54, 32, 42, 21, 11}
        //Output: [(( 4, 12), ( 6, 10)),(( 10, 22) ( 21, 11))]

        /*int[] arr = {6, 4, 12, 10, 22, 54, 32, 42, 21, 11};
        System.out.println(pairSum(arr));*/

        /*String k = "a3$e";
        System.out.println(isValidCh(k));*/

//        Input: exp = “[()]{}”
//        Output: Balanced
//        Input: exp = “[(])”
//        Output: Not Balanced
        /*String input = "[()]{}";
        System.out.println(checkBalancedBrackets(input));*/

        /*String str = "hcltechnologies";
        System.out.println(removeDuplicates(str));
*/

        /*int[] arr = new int[10];
        Random random = new Random();
        IntStream.range(0, arr.length).forEach(i -> arr[i] = random.nextInt(20));
        System.out.println(Arrays.toString(arr));

        Map<Integer, List<Prs>> map = new HashMap<>();

        IntStream.range(0, arr.length)
                .forEach(idx -> IntStream.range(idx + 1, arr.length)
                        .forEach(idx2 -> map.computeIfAbsent(arr[idx] + arr[idx2], k -> new ArrayList<>()).add(new Prs(arr[idx], arr[idx2]))));

        map.values()
                .stream().distinct().filter(list -> list.size() > 2)
                .forEach(System.out::println);*/

       /* //Setup Data
        ListNode nNode = new ListNode(1);
        ListNode nNode1 = new ListNode(8);
        ListNode nNode2 = new ListNode(9);

        nNode.next = nNode1;
        nNode1.next = nNode2;
        nNode2.next = null;

        System.out.println(doubleIt(nNode));*/

        int[] score = {10, 3, 8, 9, 4};
        System.out.println(Arrays.toString(findRelativeRanks(score)));
    }

    private static String[] findRelativeRanks(int[] score) {

        int n = score.length;

        Map<Integer, Integer> indexMap = new HashMap<>();
        IntStream.range(0, n).forEach(idx -> indexMap.put(score[idx], idx));

        Arrays.sort(score);

        String[] ans = new String[n];

        int counter = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (counter == 1) {
                ans[indexMap.get(score[i])] = "Gold Medal";
            } else if (counter == 2) {
                ans[indexMap.get(score[i])] = "Silver Medal";
            } else if (counter == 3) {
                ans[indexMap.get(score[i])] = "Bronze Medal";
            } else {
                ans[indexMap.get(score[i])] = String.valueOf(counter);
            }
            counter++;
        }

        return ans;

    }

    private static ListNode doubleIt(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode prevNode = new ListNode();
        int carry = 0;
        while (!stack.isEmpty()) {
            ListNode curr = stack.pop();

            int doubleVal = 2 * curr.val;
            if (carry > 0) {
                doubleVal += carry;
                carry = 0;
            }
            if (doubleVal > 9) {
                carry = doubleVal / 10;
            }

            curr.val = doubleVal % 10;
            prevNode.next = curr;
        }

        ListNode nNode = null;
        if (carry != 0) {
            nNode = new ListNode(carry);
            nNode.next = prevNode.next;
        }

        return nNode == null ? prevNode.next : nNode;
    }

    private static boolean isValidCh(String word) {

        // Check condition 1: Minimum of 3 characters
        if (word.length() < 3) {
            return false;
        }

        // Check condition 2: Contains only digits, uppercase and lowercase English letters
        if (!word.matches("[0-9A-Za-z]+")) {
            return false;
        }

        // Check condition 3: Includes at least one vowel
        if (!word.matches(".*[aeiouAEIOU].*")) {
            return false;
        }

        // Check condition 4: Includes at least one consonant
        return word.matches(".*[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ].*");
    }

    private static boolean containsVowelAndConsonent(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                || (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }

    private static String removeDuplicates(String str) {

        return Arrays.stream(str.split(""))
                .distinct()
                .reduce(String::concat)
                .orElse(null);

    }

    private static String checkBalancedBrackets(String input) {
        System.out.println("validating: " + input);
        String[] brackets = input.split("");
        Stack<String> stack = new Stack<>();

        for (String bracket : brackets) {
            if (bracket.equals("[") || bracket.equals("{") || bracket.equals("(")) {
                stack.push(bracket);
            } else if (!stack.isEmpty() && stack.peek().equals("(") && bracket.equals(")")) {
                stack.pop();
            } else if (!stack.isEmpty() && stack.peek().equals("[") && bracket.equals("]")) {
                stack.pop();
            } else if (!stack.isEmpty() && stack.peek().equals("{") && bracket.equals("}")) {
                stack.pop();
            }
        }

        return stack.isEmpty() ? "Balanced" : "Not Balanced";
    }

    private static List<List<Prs>> pairSum(int[] arr) {

        int n = arr.length;
        Map<Integer, List<Prs>> map = new HashMap<>();
        List<List<Prs>> ans = new ArrayList<>();

        IntStream.range(0, n)
                .forEach(idx -> IntStream.range(idx + 1, n)
                        .forEach(idx2 -> map.computeIfAbsent(arr[idx] + arr[idx2], k -> new ArrayList<>()).add(new Prs(arr[idx], arr[idx2]))));

        map.entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .forEach(entry -> ans.add(entry.getValue()));

        return ans;
    }
}

class Prs {
    int fNum;
    int sNum;

    public Prs(int fNum, int sNum) {
        this.fNum = fNum;
        this.sNum = sNum;
    }

    @Override
    public String toString() {
        return "[" +
                fNum +
                ", " + sNum +
                ']';
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}