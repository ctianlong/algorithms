package pta.s1.n7_20;

import java.util.*;

/**
 * 7-20 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 * 注：k小于len(nums)
 *
 * 输入格式:
 * 整数数组nums，以及滑动窗口大小k
 *
 * 第一行为nums，以空格分隔
 *
 * 第二行为k
 *
 * 输出格式:
 * 一行整数，包含每个窗口中的最大值，以空格分隔
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * 1 3 -1 -3 5 3 6 7
 * 3
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * 3 3 5 5 6 7
 */
public class Main {

    public static void main(String[] args) {

    }

    public static void way3() {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        int len = s.length;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++)
            nums[i] = Integer.parseInt(s[i]);
        int k = in.nextInt();

        List<String> res = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        res.add(String.valueOf(queue.peek()));
        for (int i = 1, j = k; i < len && j < len; i++, j++) {
            queue.remove(nums[i - 1]);
            queue.add(nums[j]);
            res.add(String.valueOf(queue.peek()));
        }

        System.out.println(String.join(" ", res));
    }

    /**
     * 超内存
     */
    public static void way2() {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        int len = s.length;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        int k = in.nextInt();
        List<String> res = new ArrayList<>();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
        }
        for (int L = 2; L <= k; L++) {
            for (int i = 0; i < len; i++) {
                int j = L + i - 1;
                if (j >= len) {
                    break;
                }
                if (nums[j] >= dp[i][j - 1]) {
                    dp[i][j] = nums[j];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        for (int i = 0; i < len; i++) {
            int j = k + i - 1;
            if (j >= len) {
                break;
            }
            res.add(String.valueOf(dp[i][j]));
        }
        System.out.println(String.join(" ", res));
    }

    /**
     * 超时风险
     */
    public static void way1() {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        int len = s.length;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        int k = in.nextInt();
        List<String> res = new ArrayList<>();
        for (int i = 0, j = k - 1; i < len && j < len; i++, j++) {
            int max = Integer.MIN_VALUE;
            for (int x = i; x <= j; x++) {
                max = Math.max(max, nums[x]);
            }
            res.add(String.valueOf(max));
        }
        System.out.println(String.join(" ", res));
    }

}
