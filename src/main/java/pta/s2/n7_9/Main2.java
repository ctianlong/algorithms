package pta.s2.n7_9;

import java.util.Scanner;

/**
 * @author ctl
 * @createTime 2024/09/23 13:50
 * @description
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(",");
        int n = split.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int[] visit = new int[n];
        System.out.println(dfs(nums, 0, visit));
    }

    public static boolean dfs(int[] nums, int x, int[] visit) {
        if (x < 0 || x > nums.length - 1) {
            return false;
        }
        if (x == nums.length - 1) {
            return true;
        }
        if (visit[x] == 1) {
            return false;
        }
        visit[x] = 1;
        for (int i = 1; i <= nums[x]; i++) {
            if (dfs(nums, x + i, visit)) {
                return true;
            }
            if (dfs(nums, x - i, visit)) {
                return true;
            }
        }
        return false;
    }

}
