package pta.s1.n7_20;

import java.util.Scanner;

/**
 * 7-20 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0
 *
 * 输入格式:
 * 每个测试用例一行，以“,”分隔，代表price数组
 *
 * 输出格式:
 * 对每一组输入，在一行中输出最大的利润，如果不能获取利润，返回0。
 *
 *
 * 输入样例1:
 * 在这里给出一组输入。例如：
 *
 * 7,1,5,3,6,4
 * 输出样例1:
 * 在这里给出相应的输出。例如：
 *
 * 5
 * 输入样例2:
 * 在这里给出一组输入。例如：
 *
 * 7,6,4,3,1
 * 输出样例2:
 * 在这里给出相应的输出。例如：
 *
 * 0
 */
public class Main0 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(",");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        int max = 0;
        for (int i = 0; i < s.length - 1; i++) {
            int a = nums[i];
            for (int j = i + 1; j < s.length; j++) {
                max = Math.max(nums[j] - a, max);
            }
        }
        System.out.println(max);
    }

}
