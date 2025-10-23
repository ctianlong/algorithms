package pta.s2.n7_15;

import java.util.Scanner;

/**
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        String[] s1 = split[0].split(" ");
        int[] nums = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            nums[i] = Integer.parseInt(s1[i]);
        }
        int indexDiff = Integer.parseInt(split[1]);
        int valueDiff = Integer.parseInt(split[2]);
        System.out.println(existNear(nums, indexDiff, valueDiff));
    }

    public static int existNear(int[] nums, int indexDiff, int valueDiff) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= i + indexDiff && j < len; j++) {
                if (Math.abs(nums[i] - nums[j]) <= valueDiff) {
                    return 1;
                }
            }
        }
        return 0;
    }

}
