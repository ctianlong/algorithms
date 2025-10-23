package pta.s1.n7_15;

import java.util.Scanner;

/**
 * 7-15 字符串编辑距离
 *
 * 给定一个源串和目标串，能够对源串进行如下操作：
 *
 * 在给定位置上插入一个字符
 *
 * 替换任意字符
 *
 * 删除任意字符
 *
 * 写一个程序，返回最小操作数，使得对源串进行这些操作后等于目标串
 *
 * 输入格式:
 * 函数的输入是一行包含两个字符串，word1 和 word2，以空格分割
 *
 * 每个字符串的长度大于0同时小于500，word1 和 word2 由小写英文字母组成
 *
 * 输出格式:
 * 输出两个字符的编辑距离，是一个整数
 *
 * 输入样例1:
 * 在这里给出一组输入。例如：
 *
 * horse ros
 * 输出样例1:
 * 在这里给出相应的输出。例如：
 *
 * 3
 * 输入样例2:
 * 在这里给出一组输入。例如：
 *
 * intention execution
 * 输出样例2:
 * 在这里给出相应的输出。例如：
 *
 * 5
 *
 * @author ctl
 * @createTime 2024/07/29 10:18
 * @description
 */
public class Main {

    /**
     * if s1[i] == s2[j]:
     *     啥都别做（skip）
     *     i, j 同时向前移动
     * else:
     *     三选一：
     *         插入（insert）
     *         删除（delete）
     *         替换（replace）
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        String a = s[0];
        String b = s[1];
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1,
                            dp[i - 1][j - 1] + 1
                    );
                }
            }
        }
        System.out.println(dp[m][n]);
    }

    public static int min(int x, int y, int z) {
        return Math.min(x, Math.min(y, z));
    }

}
