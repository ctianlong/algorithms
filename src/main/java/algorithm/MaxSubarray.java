package algorithm;

/**
 * 输入一个整形数组，数组里有正数也有负数。
 * 数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。
 * 求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * 
 * 例如：输入的数组为1, -2, 3, 10, -4, 7, 2, -5，和最大的子数组为3, 10, -4, 7, 2，因此输出为该子数组的和18。
 * 
 * @author Tianlong
 *
 */
public class MaxSubarray {
	
	public static void main(String[] args) {
		int[] arr = new int[]{-2, 2, -1, -5, -9};
		int result = findMaxSumOfSubarray(arr);
		System.out.println(result);
	}
	
	/*
	 * 分析数组规律
	 */
	public static int findMaxSumOfSubarray(int[] arr) {
		if (arr == null || arr.length == 0) {
			return Integer.MIN_VALUE;
		}
		int maxSum = Integer.MIN_VALUE;
		int tmp = 0;
		for (int i = 0; i < arr.length; i++) {
			if (tmp <= 0) {
				tmp = arr[i];
			} else {
				tmp += arr[i];
			}
			if (tmp > maxSum) {
				maxSum = tmp;
			}
		}
		return maxSum;
	}
	
	/*
	 * 动态规划，f(i)表示以第i个数字结尾的子数组的最大和
	 * 状态转移方程如下:
	 * f(i)=arr[i]  (i= 0或者f(i-1)<=0)
	 * f(i)=f(i-1)+arr[i]  (i> 0或者f(i-1)>0)
	 * 最终只需求出max[f(i)]即可
	 * 该方法思想其实和分析数组规律一样，代码其实也一致，相当于tmp作为f(i)，因为f(i)只和f(i-1)有关，所以其实可以不用dp数组，只用一个tmp变量就可以
	 */
	public static int findMaxSumOfSubarray2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return Integer.MIN_VALUE;
		}
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		int maxSum = dp[0];
		for (int i = 1; i < arr.length; ++i) {
			if (dp[i - 1] <= 0) {
				dp[i] = arr[i];
			} else {
				dp[i] = dp[i - 1] + arr[i];
			}
			if (dp[i] > maxSum) {
				maxSum = dp[i];
			}
		}
		return maxSum;
	}

}
