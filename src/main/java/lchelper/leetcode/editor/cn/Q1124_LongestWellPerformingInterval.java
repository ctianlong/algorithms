/**
 * Q1124 表现良好的最长时间段
 * 难度：Medium
 * 标签：栈 | 数组 | 单调栈
 *
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 */ 
//
// 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。 
//
// 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。 
//
// 请你返回「表现良好时间段」的最大长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：hours = [9,9,6,0,6,6,9]
//输出：3
//解释：最长的表现良好时间段是 [9,9,6]。 
//
// 示例 2： 
//
// 
//输入：hours = [6,6,6]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= hours.length <= 10⁴ 
// 0 <= hours[i] <= 16 
// 
//
// Related Topics栈 | 数组 | 哈希表 | 前缀和 | 单调栈 
//
// 👍 583, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package lchelper.leetcode.editor.cn;

import java.util.*;
import lchelper.leetcode.editor.common.*;

public class Q1124_LongestWellPerformingInterval {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestWPI(int[] hours) {
            // 首先归一化，>8为1，否则为-1
            int n = hours.length;
            // 前缀和
            int[] preSum = new int[n + 1];
            preSum[0] = 0;
            // 前缀和与索引对应
            Map<Integer, Integer> sum2idx = new HashMap<>();
            sum2idx.put(0, 0);
            // 单调栈，每次将更小的前缀和入栈
            Stack<Integer> orderPreSumStack = new Stack<>();
            orderPreSumStack.push(0);
            for (int i = 1; i <= n; i++) {
                if (hours[i - 1] > 8) {
                    preSum[i] = preSum[i - 1] + 1;
                } else {
                    preSum[i] = preSum[i - 1] - 1;
                }
                if (orderPreSumStack.peek() > preSum[i]) {
                    orderPreSumStack.push(preSum[i]);
                    sum2idx.put(preSum[i], i);
                }
            }
            int res = 0;
            for (int i = n; i >= 1; i--) {
                Integer valid = null;
                while (!orderPreSumStack.isEmpty() && orderPreSumStack.peek() < preSum[i]) {
                    valid = orderPreSumStack.pop();
                }
                if (valid != null) {
                    int tmp = i - sum2idx.get(valid);
                    res = Math.max(res, tmp);
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new Q1124_LongestWellPerformingInterval().new Solution();
        // put your test code here
        
    }
}