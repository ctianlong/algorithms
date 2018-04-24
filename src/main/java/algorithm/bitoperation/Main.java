package algorithm.bitoperation;

public class Main {

	public static void main(String[] args) {
		int n = 7;
		System.out.println(nextN(n) == nextN2(n));
	}

	/**
	 * 统计二进制数中位1的个数
	 * 
	 * @param x
	 * @return
	 */
	public static int countBitOne(int x) {
		int count = 0;
		while (x != 0) {
			count++;
			x = x & (x - 1); // 该操作能够将二进制表示中右起第一个1置为0
			// x = x | (x + 1) 右起第一个0置为1，数0的算法，同时修改循环条件，
		}
		return count;
	}

	/*
	 * 给定一个正整数 N，求最小的、比 N 大的正整数 M，使得 M 与 N 的二进制表示中有相同数目的 1 
	 * 枚举法：逐个比较，效率低
	 */
	public static int nextN(int n) {
		int k = countBitOne(n);
		do {
			++n;
		} while (k != countBitOne(n));
		return n;
	}

	/*
	 * O(1)时间高效方法，原理暂不知。。。
	 */
	public static int nextN2(int n) {
		int x = n & (-n);
		int t = n + x;
		int ans = t | ((n ^ t) / x) >> 2;
		return ans;
	}

}
