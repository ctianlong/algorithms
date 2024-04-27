package pta.s1.n7_7;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        numSplit(k);
    }
    public static void numSplit(int k) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < k; i++) {
            int diff = 1;
            int sum = 0;
            int num = i;
            List<Integer> list = new ArrayList<>();
            while (sum < k) {
                list.add(num);
                sum += num;
                if (sum == k) {
                    res.add(list);
                    break;
                }
                num += diff;
                diff++;
            }
        }
        if (res.isEmpty()) {
            System.out.println("");
            return;
        }
        for (List<Integer> list : res) {
            StringBuilder sb = new StringBuilder();
            for (int i : list) {
                sb.append(i).append(",");
            }
            sb.setLength(sb.length() - 1);
            System.out.println(sb);
        }
    }
}
