package algorithm;

/**
 * 最长非降子序列，longest increasing subsequence
 * DP求解O(n^2)，参考https://hawstein.com/2013/03/26/dp-novice-to-advanced/
 * 公式：d(i) = max{1, d(j)+1},其中j<i,A[j]<=A[i]
 * d(i)表示前i个数中以A[i]结尾的最长非降子序列的长度，最终答案是最大的那个d(i)
 * 其它求解方式：排序+LCS，另一种O(nlogn)的算法（参考https://www.felix021.com/blog/read.php?1587）
 *
 * 其它参考：https://mp.weixin.qq.com/s/daK5BmWntCstuTLn6GCmDQ
 */
public class LIS {
	
	public static void main(String[] args) {
		int[] a = {5, 3, 4, 8, 6, 7};
		System.out.println(lis(a));
	}
	
	/**
	 * 输出LIS长度，O(n^2)
	 */
	public static int lis(int[] a) {
		if (a == null || a.length == 0) return 0;
		int n = a.length;
		int res = 1;
		int[] dp = new int[n];
		for (int i = 0; i < n; ++i) {
			dp[i] = 1;
			for (int j = 0; j < i; ++j) {
				if (a[j] <= a[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}

}
