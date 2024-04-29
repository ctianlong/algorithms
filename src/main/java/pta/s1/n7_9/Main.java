package pta.s1.n7_9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // System.out.println(n / 5 + n % 5 / 2 + n % 5 % 2);
        int num = minCoinNum(new int[]{1,2,5}, n);
        if (num == Integer.MAX_VALUE) {
            System.out.println("0");
        } else {
            System.out.println(num);
        }
    }

    public static int minCoinNum(int[] coins, int amount) {
        // dp[i]表示凑够i元所需的最少硬币数量
        int[] dp = new int[amount + 1];
        // 所有元素先赋值为无穷大Infinity(此处用MAX_VALUE代替)，配合min，计算完成后如果dp[i]是无穷大，说明无法凑够i元
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        // 凑够0元需要0个硬币
        dp[0] = 0;
        // 若结果需要给出具体使用哪几个硬币，则需要辅助数组记录相关信息
        int[] data = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                // 需要考虑某些价格总和无法由所提供的硬币组合相加得到
                // dp[i - coins[j]] != Integer.MAX_VALUE 条件满足表示 i - coins[j] 元可以由所提供的硬币组合相加得到
                // 由于Java中Integer.MAX_VALUE无法准确表达无穷Infinity的含义，所以额外加上上述判断条件
                if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE && dp[i - coins[j]] + 1 < dp[i]) {
                    dp[i] = dp[i - coins[j]] + 1;
                    // data记录先拿的那一枚硬币面值
                    data[i] = coins[j];
                }
            }
        }
        return dp[amount];
    }
}
