package leetcode.PalindromeNumber_9;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * click to show spoilers.
 * 
 * Some hints: Could negative integers be palindromes? (ie, -1)
 * 
 * If you are thinking of converting the integer to string, note the restriction
 * of using extra space.
 * 
 * You could also try reversing an integer. However, if you have solved the
 * problem "Reverse Integer", you know that the reversed integer might overflow.
 * How would you handle such case?
 * 
 * There is a more generic way of solving this problem.
 * 
 * @author Tianlong
 *
 */
public class Solution {

	/**
	 * 网友版本：效率更高，只需判断一半数字
	 * @param x
	 * @return
	 */
	public boolean isPalindrome2(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0))
			return false;
		int rev = 0;
		while (x > rev) {
			rev = rev * 10 + x % 10;
			x = x / 10;
		}
		return (x == rev || x == rev / 10);
	}

	/**
	 * 第一版，算出数字位数，对前后对应每一位依次比较
	 * 
	 * @param x
	 * @return
	 */
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int len = 1;
		int tmp = x;
		while ((tmp = tmp / 10) != 0) {
			len++;
		}
		int i = 1;
		while (i <= len / 2) {
			if ((x / (int) Math.pow(10, i - 1)) % 10 != (x / (int) Math.pow(10, len - i)) % 10)
				break;
			i++;
		}
		return (i > len / 2) ? true : false;
	}
}