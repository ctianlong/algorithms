/**
 * Q5 最长回文子串
 * 难度：Medium
 * 标签：字符串 | 动态规划
 *
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 */ 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics双指针 | 字符串 | 动态规划 
//
// 👍 7930, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package lchelper.leetcode.editor.cn;

import java.util.*;
import lchelper.leetcode.editor.common.*;

public class Q5_LongestPalindromicSubstring {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            // 双指针，从中间向两边扩散；同时区分奇偶长度的回文
            String res = "";
            for (int i = 0; i < s.length(); i++) {
                String s1 = find(s, i, i);
                String s2 = find(s, i, i + 1);
                res = s1.length() > res.length() ? s1 : res;
                res = s2.length() > res.length() ? s2 : res;
            }
            return res;

            // 方法二，动态规划
//            char[] chars = s.toCharArray();
//            int n = chars.length;
//            boolean[][] dp = new boolean[n][n];
            // dp[i][j]代表i-j的字符串是否为回文
            // 先不写了
        }

        public String find(String s, int l, int r) {
            // l=r为寻找奇数回文，l+1=r为寻找偶数回文
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            return s.substring(l + 1, r);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new Q5_LongestPalindromicSubstring().new Solution();
        // put your test code here
        
    }
}