package leetcode.LongestSubstringWithoutRepeatingCharacters_3;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * @author ctl
 * 
 * 启示：
 * 判断重复可以用Set（如字符，字符串等），各种contains…方法，进一步，如果要保存某种状态（如该字符的下标），可以用Map，键为该字符，值为某种状态
 * 工具类方法，Math工具类
 * 对数组进行滑动窗口可以用形如：while (i < n && j < n) {}
 *
 */
public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
	}

	public int lengthOfLongestSubstring(String s) {
		char[] array = s.toCharArray();
		int l = 0, m = 0;
		int i, j;
		for (i = 1; i < array.length; i++) {
			char cur = array[i];
			for (j = m; j < i; j++)
				if (array[j] == cur) break;
			if (j < i) {
				if (i - m > l) l = i - m;
				m = j + 1;
			}
		}
		return i - m > l ? i - m : l;
	}
}
