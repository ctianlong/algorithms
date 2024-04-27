package algorithm;

/**
 * 字符串匹配算法；
 * 暴力搜索、KMP采用一维next数组实现，参考：https://mp.weixin.qq.com/s?__biz=MzUzNzcyMzE4OA==&mid=2247483944&idx=1&sn=43a0f157660364d08e8831d6ed6d31d0&chksm=fae3ea73cd946365d3495423f28c19c9be92d920364821f1e6d0969f033fede5fd8f84b1423c&scene=21#wechat_redirect
 * https://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
 *
 * KMP采用DFA理解的方式实现，参考：https://blog.csdn.net/congduan/article/details/45459963
 * DFA代码实现参考:
 * @see algs4.edu.princeton.cs.algs4.KMP
 *
 * @author ctl
 * @date 2021/10/28
 */
public class KMP {

	public static void main(String[] args) {
		String txt = "BBC ABCDAB ABCDABCDABDE";
		String pat = "ABCDABD";
		System.out.println(searchNextArray(txt, pat));
		System.out.println(searchBruteForce(txt, pat));
	}

	/**
	 * 朴素搜索，暴力，模式串每次平移1位。
	 * n为主串长度，m为模式串长度。时间复杂度为O(nm)。
	 */
	public static int searchBruteForce(String txt, String pat) {
		int n = txt.length();
		int m = pat.length();
		// 代码写法1，
//		for (int i = 0; i < n - m + 1; i++) {
//			// 判断txt的(i,i+m)和整个pat是否相同
//			if (subSeqEqual(txt, i, pat, 0, m)) {
//				return i;
//			}
//		}
//		return n;
		// 代码写法2
		int i, j;
		for (i = 0, j = 0; i < n && j < m; i++) {
			if (txt.charAt(i) == pat.charAt(j)) {
				j++;
			} else {
				// 模式串整体右移1位，再从头开始匹配，主串指针回退
				i -= j;
				j = 0;
			}
		}
		if (j == m) {
			// match
			return i - m;
		}
		// not match
		return n;
	}


	public static int searchNextArray(String txt, String pat) {
		int n = txt.length();
		int m = pat.length();
		// 构建模式串的next数组
		int[] next = getNextArray(pat);
		int i, j;
		for (i = 0, j = 0; i < n && j < m; i++) {
			if (txt.charAt(i) == pat.charAt(j)) {
				j++;
			} else {
				// todo 与上述代码写法2相似，不同点在于字符不相同时的指针重新定位操作
				// 模式串整体右移offset位，且模式串不是从头开始匹配
				if (j != 0) {
					int offset = j - next[j - 1];
					j -= offset;
					i--;
				}
			}
		}
		if (j == m) {
			// match
			return i - m;
		}
		// not match
		return n;
	}

	private static int[] getNextArray(String pat) {
		int[] next = new int[pat.length()];
		for (int i = 0; i < pat.length(); i++) {
			int len = i + 1;
			for (int j = len - 1; j > 0; j--) {
				if (subSeqEqual(pat, 0, pat, len - j, j)) {
					next[i] = j;
					break;
				}
			}
		}
		return next;
	}

	/**
	 * 比较s1从offset1开始和s2从offset2开始的子字符串是否相同，比较长度为length；
	 * 若从offset开始长度不足length，会抛数组下标越界异常
	 */
	private static boolean subSeqEqual(String s1, int offset1, String s2, int offset2, int length) {
		for (int i = 0; i < length; i++) {
			if (s1.charAt(offset1 + i) != s2.charAt(offset2 + i)) {
				return false;
			}
		}
		return true;
	}

}
