/**
 * Q525 连续数组
 * 难度：Medium
 * 标签：数组 | 哈希表 | 前缀和
 *
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 */ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,1]
//输出：2
//说明：[0, 1] 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0]
//输出：2
//说明：[0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 示例 3： 
//
// 
//输入：nums = [0,1,1,1,1,1,0,0,0]
//输出：6
//解释：[1,1,1,0,0,0] 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1 
// 
//
// Related Topics数组 | 哈希表 | 前缀和 
//
// 👍 812, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package lchelper.leetcode.editor.cn;

import java.util.*;
import lchelper.leetcode.editor.common.*;

public class Q525_ContiguousArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxLength(int[] nums) {
            // 前缀和+哈希表
            // 用一个变量遍历记录前i个元素和，用哈希表记录某个和出现的最早下标位置
            Map<Integer, Integer> sumIndexMap = new HashMap<>();
            int preSum = 0;
            int res = 0;
            sumIndexMap.put(0, -1);
            for (int i = 0; i < nums.length; i++) {
                // 将0当成-1，1还是1，这样当某两个前缀和相减为0时，表示中间的元素和为0，也即0和1个数相同
                if (nums[i] == 0) {
                    preSum--;
                } else {
                    preSum++;
                }
                Integer oldIndex = sumIndexMap.get(preSum);
                if (oldIndex != null) {
                    int tmp = i - oldIndex;
                    if (tmp > res) {
                        res = tmp;
                    }
                } else {
                    sumIndexMap.put(preSum, i);
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new Q525_ContiguousArray().new Solution();
        // put your test code here
        
    }
}