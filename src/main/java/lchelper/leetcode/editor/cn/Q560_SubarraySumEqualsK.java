/**
 * Q560 和为 K 的子数组
 * 难度：Medium
 * 标签：数组 | 哈希表 | 前缀和
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 */ 
//
// 子数组是数组中元素的连续非空序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics数组 | 哈希表 | 前缀和 
//
// 👍 2955, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package lchelper.leetcode.editor.cn;

import java.util.*;
import lchelper.leetcode.editor.common.*;

public class Q560_SubarraySumEqualsK {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int preSum = 0;
            // 遍历前缀和，哈希表记录每个前缀和出现的个数
            // 对于某一个前缀和preSum[i]，计算preSum[i]-k的值是否在之前的前缀和中出现，若出现，则结果计次
            Map<Integer, Integer> preSum2Count = new HashMap<>();
            preSum2Count.put(0, 1);
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                preSum += nums[i];
                Integer count = preSum2Count.get(preSum - k);
                if (count != null) {
                    res += count;
                }
                preSum2Count.put(preSum, preSum2Count.getOrDefault(preSum, 0) + 1);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new Q560_SubarraySumEqualsK().new Solution();
        // put your test code here
        
    }
}