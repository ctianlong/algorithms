/**
 * Q523 连续的子数组和
 * 难度：Medium
 * 标签：数组 | 哈希表 | 前缀和
 *
 * 给你一个整数数组 nums 和一个整数 k ，如果 nums 有一个 好的子数组 返回 true ，否则返回 false：
 */ 
//
// 一个 好的子数组 是： 
//
// 
// 长度 至少为 2 ，且 
// 子数组元素总和为 k 的倍数。 
// 
//
// 注意： 
//
// 
// 子数组 是数组中 连续 的部分。 
// 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终 视为 k 的一个倍数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [23,2,4,6,7], k = 6
//输出：true
//解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。 
//
// 示例 2： 
//
// 
//输入：nums = [23,2,6,4,7], k = 6
//输出：true
//解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。 
//42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
// 
//
// 示例 3： 
//
// 
//输入：nums = [23,2,6,4,7], k = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 0 <= sum(nums[i]) <= 2³¹ - 1 
// 1 <= k <= 2³¹ - 1 
// 
//
// Related Topics数组 | 哈希表 | 数学 | 前缀和 
//
// 👍 641, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package lchelper.leetcode.editor.cn;

import java.util.*;
import lchelper.leetcode.editor.common.*;

public class Q523_ContinuousSubarraySum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            // 前缀和+哈希表
            // 遍历前缀和
            int preSum = 0;
            // 计算每个前缀和除以k的余数和下标做映射
            Map<Integer, Integer> remMap = new HashMap<>();
            remMap.put(0, -1);
            for (int i = 0; i < nums.length; i++) {
                preSum += nums[i];
                int rem = preSum % k;
                Integer preIndex = remMap.get(rem);
                if (preIndex != null) {
                    if (i - preIndex > 1) {
                        return true;
                    }
                } else {
                    remMap.put(rem, i);
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new Q523_ContinuousSubarraySum().new Solution();
        // put your test code here
        
    }
}