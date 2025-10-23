package pta.s2.n7_17;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 7-17 根据数字的补数排序
 * 分数 30
 * 作者 网易
 * 单位 网易
 * 对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
 *
 * 例如，整数 5 的二进制表示是 "101" （没有前导零位），取反后得到 "010" ，再转回十进制表示得到补数 2 。
 *
 * 给你一个整数数组 arr 。请你将数组中的元素按照其补数升序排序。如果补数相同，则按照原数值大小升序排列。
 *
 * 请你返回排序后的数组。
 *
 * 提示：
 *
 * 1 <= arr.length <= 500
 *
 * 0 <= arr[i] <= 10^4
 *
 * 输入格式:
 * 整数数组arr，以",”分隔字符串的形式作为输入
 *
 * 输出格式:
 * 排好序的整数数组，以",”分隔字符串的形式作为输出
 *
 * 输入样例:
 * 原始数组arr：
 *
 * 5,10,4,2
 * 输出样例:
 * 排序后的arr：
 *
 * 2,5,4,10
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(",");
        List<Num> nums = new ArrayList<>();
        for (String s : split) {
            Num n = new Num();
            n.ori = Integer.parseInt(s);
            n.com = getCom(n.ori);
            nums.add(n);
        }
        nums.sort((x, y) -> {
            if (x.com == y.com) {
                return x.ori - y.ori;
            }
            return x.com - y.com;
        });
        StringBuilder sb = new StringBuilder();
        for (Num n : nums) {
            sb.append(n.ori).append(",");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    public static int getCom(int x) {
        if (x == 0) {
            return 1;
        }
        int res = 0;
        int i = 0;
        while (x > 0) {
            res += ((x & 1) == 1 ? 0 : 1) << (i++);
            x = x / 2;
        }
        return res;
    }

    public static class Num {
        int ori;
        int com;
    }

}
