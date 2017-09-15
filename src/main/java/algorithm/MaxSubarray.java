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
		int[] arr = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
		int result = findMaxSumOfSubarray(arr);
		System.out.println(result);
	}
	
	public static int findMaxSumOfSubarray(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int maxSum = 0;
		int tmp = maxSum;
		for (int i = 0; i < arr.length; i++) {
			tmp += arr[i];
			if (tmp <= 0) {
				tmp = 0;
			} else if (tmp > maxSum) {
				maxSum = tmp;
			}
		}
		return maxSum;
	}

}
