package pta.s2.n7_9;

import java.util.Scanner;

/**
 * 知道秘密的人数
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int delay = in.nextInt();
        int forget = in.nextInt();
        long res = knowSecretNum(n, delay, forget);
        System.out.println(res);
    }

    public static long knowSecretNum(int n, int delay, int forget) {
        long mod = 1000000007;
        // dp[i]表示第i天新增的知道秘密的人
        long[] dp = new long[n + 1];
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            // dp[i]的人会对 i+delay 到 i+forget-1 天贡献新增
            for (int j = i + delay; j <= i + forget - 1 && j <= n; j++) {
                dp[j] += dp[i];
                dp[j] = dp[j] % mod;
            }
        }
        long res = 0;
        // 第n天剩余的知道秘密的总人数为 第 n + 1 - forget 到 n 天新增的人之和
        for (int i = n + 1 - forget; i <= n; i++) {
            res += dp[i];
            res = res % mod;
        }
        return res;
    }

}
