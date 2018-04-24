package algorithm.string;

/**
 * 字符串全排列，如abc，输出6种不同排列方式
 * @author ctl
 *
 */
public class QuanPailie {
	
	private static int count = 0;
	
	public static void main(String[] args) {
		char[] str = "abc".toCharArray();
		quanPaiLie(str, 0);
//		quanPaiLieDistinct(str, 0);
		System.out.println(count);
	}
	
	/*
	 * n为字符数组的索引，输出从n开始的全排列
	 * 思路：对n位置处，一次循环，将每个字符交换到n处，再对n-1位置开始的字符递归调用，直到数组最后一位，O(n!)
	 */
	public static void quanPaiLie(char[] str, int n) {
		if (n == str.length - 1) {
			System.out.println(str);
			count++; // 统计一共有几种排列：n!
			return;
		}
		for (int i = n; i < str.length; ++i) {
			swap(str, n, i);
			quanPaiLie(str, n + 1);
			swap(str, n, i);
		}
	}
	
	/*
	 * 去重的全排列递归实现，比如输入aaa，只输出aaa
	 * 大部分代码和不去重一样，只是增加一个是否交换的判断
	 */
	public static void quanPaiLieDistinct(char[] str, int n) {
		if (n == str.length - 1) {
			System.out.println(str);
			count++; // 统计一共有几种排列
			return;
		}
		for (int i = n; i < str.length; ++i) {
			if (isNeedSwap(str, n, i)) { // 增加一个是否交换的判断
				swap(str, n, i);
				quanPaiLieDistinct(str, n + 1);
				swap(str, n, i);
			}
		}
	}
	
	// 判断在n~i-1下标范围内，是否存在和i位置相同的字符，若存在，则不需要交换，返回false
	public static boolean isNeedSwap(char[] str, int n, int i) {
		for (int j = n; j < i; ++j) {
			if (str[j] == str[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void swap(char[] c, int x, int y) {
		char tmp = c[x];
		c[x] = c[y];
		c[y] = tmp;
	}

}
