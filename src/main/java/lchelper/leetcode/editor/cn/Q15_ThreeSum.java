/**
 * Q15 三数之和
 * 难度：Medium
 * 标签：数组 | 双指针 | 排序
 *
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j !=
 * k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 */ 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics数组 | 双指针 | 排序 
//
// 👍 7756, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package lchelper.leetcode.editor.cn;

import java.util.*;
import lchelper.leetcode.editor.common.*;

public class Q15_ThreeSum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            // 核心思路：排序 + 固定一个数 + 双指针找另外两个数
            List<List<Integer>> res = new ArrayList<>();
            // 1. 先排序，为双指针打下基础
            Arrays.sort(nums);

            // 2. 遍历数组，固定第一个数 nums[i]
            for (int i = 0; i < nums.length - 2; i++) {
                // 剪枝优化：如果最小的数都大于0，后面不可能有三数之和为0
                if (nums[i] > 0) break;

                // 去重：跳过重复的第一个数
                if (i > 0 && nums[i] == nums[i - 1]) continue;

                // 3. 双指针寻找另外两个数
                int left = i + 1;           // 左指针，从 i 的下一个位置开始
                int right = nums.length - 1; // 右指针，从数组末尾开始

                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];

                    if (sum == 0) {
                        // 找到一个三元组
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        // 去重：跳过重复的左指针值
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        // 去重：跳过重复的右指针值
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        // 同时移动左右指针，寻找下一个可能的组合
                        left++;
                        right--;
                    } else if (sum < 0) {
                        // 和太小，需要增大，左指针右移（排序后左边数更小）
                        left++;
                    } else {
                        // 和太大，需要减小，右指针左移（排序后右边数更大）
                        right--;
                    }
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new Q15_ThreeSum().new Solution();
        // put your test code here
        
    }
}