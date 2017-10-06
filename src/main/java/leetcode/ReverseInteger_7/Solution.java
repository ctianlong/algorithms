package leetcode.ReverseInteger_7;

import org.junit.Test;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * 
 * 
 * click to show spoilers.
 * 
 * Have you thought about this? Here are some good questions to ask before
 * coding. Bonus points for you if you have already thought through this!
 * 
 * If the integer's last digit is 0, what should the output be? ie, cases such
 * as 10, 100.
 * 
 * Did you notice that the reversed integer might overflow? Assume the input is
 * a 32-bit integer, then the reverse of 1000000003 overflows. How should you
 * handle such cases?
 * 
 * For the purpose of this problem, assume that your function returns 0 when the
 * reversed integer overflows.
 * 
 * 
 * Note: The input is assumed to be a 32-bit signed integer. Your function
 * should return 0 when the reversed integer overflows.
 * 
 * @author Tianlong
 *
 */
public class Solution {

	@Test
	public void test() {
		// System.out.println(Integer.MAX_VALUE); //2147483647
		// System.out.println(Integer.MIN_VALUE); //-2147483648
		System.out.println(Integer.parseUnsignedInt("2147483649"));
		System.out.println(-123 % 10);

	}
	
	/**
	 * 方案3：每次计算完 temp = r * 10 + x % 10; 后通过反向运算验证是否溢出。
	 * 	反向运算满足溢出条件：temp / 10 != r
	 * @param x
	 * @return
	 */
	public int reverse3(int x) {
		int r = 0, temp = 0;
        while (x != 0) {
            temp = r * 10 + x % 10;
            if (temp / 10 != r) {
                return 0;
            }
            r = temp;
            x /= 10;
        }
        return r;
	}
	
	/**
	 * 方案2：确保每次计算 r = r * 10 + tail; 所得的 r 都在有效范围内
	 * 	通过 min <= r * 10 + tail <= max 确保，计算过程需要保证不等式中的每一小项都不溢出。
	 * 	比如通过 + 10 - 10 的操作
	 * @param x
	 * @return
	 */
	public int reverse2(int x) {
		int tail = 0, r = 0;
        while (x != 0) {
            tail = x % 10;
            if (r < ((Integer.MIN_VALUE + 10 - tail) / 10 - 1) || r > ((Integer.MAX_VALUE - 10 - tail) / 10 + 1)) {
                return 0;
            }
            r = r * 10 + tail;
            x /= 10;
        }
        return r;
	}

	/**
	 * 方案1：将数字转化为字符串操作，离题。。。
	 * @param x
	 * @return
	 */
	public int reverse(int x) {
		int n = (x < 0) ? -x : x;
		// String revStr = new StringBuilder(String.valueOf(n)).reverse().toString();
		char[] c = String.valueOf(n).toCharArray();
		for (int i = 0, j = c.length - 1; i < j; i++, j--) {
			char temp = c[i];
			c[i] = c[j];
			c[j] = temp;
		}
		String revStr = new String(c);
		try {
			int result = Integer.parseInt(revStr);
			return (x < 0) ? -result : result;
		} catch (NumberFormatException e) {
			return 0;
		}
	}

}
