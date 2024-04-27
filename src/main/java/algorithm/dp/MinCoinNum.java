package algorithm.dp;

import java.util.Arrays;

/**
 * 有面值为1元、3元和5元的硬币若干枚，如何用最少的硬币凑够11元？
 * 使用动态规划，状态转移方程: d[i]=min(d[i-V[j]] + 1), i-V[j]>=0, d[i]表示凑够i元所需的最少硬币数量，V[j]表示第j个硬币的面值
 * V[j]通俗含义就是先拿出一枚硬币去尝试
 * 参考：https://hawstein.com/2013/03/26/dp-novice-to-advanced/
 * @author ctl
 * @date 2021/10/27
 */
public class MinCoinNum {

	public static void main(String[] args) {
		int[] coins = new int[]{1, 3, 5};
		int amount = 11;
		int num = minCoinNum(coins, amount);
		if (num == Integer.MAX_VALUE) {
			System.out.println("can not get this amount");
		} else {
			System.out.println("need coin num: " + num);
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

		// 结果打印，非必要操作
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] == Integer.MAX_VALUE) {
				System.out.println(i + "  can not get");
			} else {
				System.out.println(i + "  " + dp[i] + "  " + data[i] + "(" + (i - data[i]) + ")");
			}
		}
		// 具体给出amount钱数需要有哪几枚硬币组合起来
		if (dp[amount] == Integer.MAX_VALUE) {
			System.out.println("can not get amount " + amount);
		} else {
			int[] needCoins = new int[dp[amount]];
			int tmpAmount = amount;
			int i = 0;
			while (tmpAmount > 0) {
				needCoins[i++] = data[tmpAmount];
				tmpAmount -= data[tmpAmount];
			}
			System.out.println(Arrays.toString(needCoins));
		}

		return dp[amount];
	}

}
