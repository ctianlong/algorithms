package pta.s1.n7_8;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int maxLen = 0, maxStartIndex = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (maxLen >= len - i) {
                break; // 优化，减少不必要遍历
            }
            int low = 0, up = 0;
            for (int j = i; j < len; j++) {
                char x = s.charAt(j);  // 从j开始遍历字串
                if (x >= 'a' && x <= 'z') {
                    low = low | (1 << (x - 'a'));
                } else {
                    up = up | (1 << (x - 'A'));
                }
                if (low == up && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    maxStartIndex = i;
                }
            }
        }
        if (maxLen > 0) {
            System.out.println(s.substring(maxStartIndex, maxStartIndex + maxLen));
        } else {
            System.out.println("");
        }
    }
}
