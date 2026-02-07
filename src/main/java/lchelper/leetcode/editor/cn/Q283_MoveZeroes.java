/**
 * Q283 移动零
 * 难度：Easy
 * 标签：数组 | 双指针
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */ 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics数组 | 双指针 
//
// 👍 2785, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package lchelper.leetcode.editor.cn;

import java.util.*;
import lchelper.leetcode.editor.common.*;

public class Q283_MoveZeroes {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int slow = 0, fast = 0;
            while (fast < nums.length) {
                if (nums[fast] != 0) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }
            while (slow < nums.length) {
                nums[slow] = 0;
                slow++;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new Q283_MoveZeroes().new Solution();
        // put your test code here
        
    }
}