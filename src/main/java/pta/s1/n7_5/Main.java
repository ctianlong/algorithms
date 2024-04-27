package pta.s1.n7_5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int result = isPalindrome(in.nextLine());
        System.out.println(result);
    }
    public static int isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        String ss = sb.toString();
        int left = 0;
        int right = ss.length() - 1;
        while (left < right) {
            if (ss.charAt(left) != ss.charAt(right)) {
                return 0;
            }
            left++;
            right--;
        }
        return 1;
    }
}
