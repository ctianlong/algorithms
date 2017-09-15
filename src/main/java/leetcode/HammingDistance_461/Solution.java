package leetcode.HammingDistance_461;

/**
 * 汉明距离
 * The Hamming distance between two integers is the number of positions at which
 * the corresponding bits are different.
 * 
 * Given two integers x and y, calculate the Hamming distance.
 * 
 * Note: 0 ≤ x, y < 231.
 * 
 * Example:
 * 
 * Input: x = 1, y = 4
 * 
 * Output: 2
 * 
 * Explanation: 1 (0 0 0 1) 4 (0 1 0 0) ? ?
 * 
 * The above arrows point to positions where the corresponding bits are
 * different.
 * 
 * @author Tianlong
 *
 */
public class Solution {

	/**
	 * 使用 异或 逻辑
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public int hammingDistance2(int x, int y) {
		return Integer.bitCount(x ^ y);
	}

	/**
	 * 按照十进制转化为二进制的方法依次比较，一般
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public int hammingDistance(int x, int y) {
		int count = 0;
		while (x != 0 || y != 0) {
			if (x % 2 != y % 2) {
				count++;
			}
			x /= 2;
			y /= 2;
		}
		return count;
	}

}
