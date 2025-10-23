package pta.s1.n7_21;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 7-21 向数组中追加 K 个整数
 * 给你一个整数数组 nums 和一个整数 k 。请你向 nums 中追加 k 个 未 出现在 nums 中的、互不相同 的 正 整数，并使结果数组的元素和 最小 。
 *
 * 返回追加到 nums 中的 k 个整数之和。
 *
 * 输入格式:
 * 第一行输入整数数组nums，各元素之间用空格分开，第二行输入k
 *
 * 1 <= nums.length <= 1000
 *
 * 1 <= nums[i], k <= 100
 *
 * 输出格式:
 * 输出nums中的k个整数之和
 *
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * 1 4 25 10 25
 * 2
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * 5
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] data = in.nextLine().split(" ");
        Set<Integer> numSet = new HashSet<>();
        for (String str : data) {
            numSet.add(Integer.parseInt(str));
        }
        int k = in.nextInt();
        int count = 0;
        int res = 0;
        for (int i = 1; ; i++) {
            if (!numSet.contains(i)) {
                count++;
                res += i;
            }
            if (count >= k) {
                break;
            }
        }
        System.out.println(res);
    }

}
