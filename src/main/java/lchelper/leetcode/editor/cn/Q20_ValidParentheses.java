/**
 * Q20 有效的括号
 * 难度：Easy
 * 标签：栈 | 字符串
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 */

// 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "()" 
// 
//
// 输出：true 
//
// 示例 2： 
//
// 
// 输入：s = "()[]{}" 
// 
//
// 输出：true 
//
// 示例 3： 
//
// 
// 输入：s = "(]" 
// 
//
// 输出：false 
//
// 示例 4： 
//
// 
// 输入：s = "([])" 
// 
//
// 输出：true 
//
// 示例 5： 
//
// 
// 输入：s = "([)]" 
// 
//
// 输出：false 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics栈 | 字符串 
//
// 👍 4850, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package lchelper.leetcode.editor.cn;

import java.util.*;
import lchelper.leetcode.editor.common.*;

public class Q20_ValidParentheses {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            char[] cs = s.toCharArray();
            int n = cs.length;
            if (n % 2 != 0) {
                return false;
            }
            Stack<Character> stk = new Stack<>();
            Map<Character, Character> map = new HashMap<>();
            map.put(')', '(');
            map.put(']', '[');
            map.put('}', '{');
            for (char c : cs) {
                if (map.containsKey(c)) {
                    if (stk.isEmpty() || !stk.pop().equals(map.get(c))) {
                        return false;
                    }
                } else {
                    stk.push(c);
                }
            }
            if (!stk.isEmpty()) {
                return false;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new Q20_ValidParentheses().new Solution();
        // put your test code here
        
    }
}