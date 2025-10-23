package pta.s1.n7_22;

import java.util.Scanner;

/**
 * 7-22 计算右侧小于当前元素的个数
 * 给你一个整数数组 nums ，按要求返回一个新数组 counts 。
 *
 * 数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 nums[i] 的元素的数量。
 *
 * 输入格式：
 * 整数序列，用空格分隔。
 *
 * 输出格式：
 * 整数序列，用空格分隔。
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * 5 2 6 1
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * 2 1 1 0
 * 提示
 * 1<= nums.length <= 10^5
 *
 * -10^4 <= nums[i] <= 10^4
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            int c = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    c++;
                }
            }
            sb.append(c).append(" ");
        }
        sb.setLength((sb.length() - 1));
        System.out.println(sb);
    }


}
