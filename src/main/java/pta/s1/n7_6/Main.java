package pta.s1.n7_6;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] st = in.nextLine().split(",");
        System.out.println(checkMapping(st[0], st[1]));
    }
    public static int checkMapping(String s, String t) {
        int[] mapping = new int[128];
        int[] valUsed = new int[128];
        for (int i = 0; i < mapping.length; i++)
            mapping[i] = -1;
        for (int i = 0; i < s.length(); i++) {
            int key = (int) s.charAt(i);
            int val = (int) t.charAt(i);
            int existVal = mapping[key];
            if (existVal == -1) {
                if (valUsed[val] == 1) {
                    return 0;
                } else {
                    mapping[key] = val;
                    valUsed[val] = 1;
                }
            } else if (existVal != val) {
                return 0;
            }
        }
        return 1;
    }
}
