/**
 * Q42 接雨水
 * 难度：Hard
 * 标签：栈 | 数组 | 双指针 | 动态规划 | 单调栈
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */ 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics栈 | 数组 | 双指针 | 动态规划 | 单调栈 
//
// 👍 6081, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package lchelper.leetcode.editor.cn;

import java.util.*;
import lchelper.leetcode.editor.common.*;

public class Q42_TrappingRainWater {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            if (height == null || height.length == 1) {
                return 0;
            }
            // 方法1:动态规划，算出每个柱子左边的最大高度，和右边的最大高度
//            int[] leftM = new int[height.length];
//            int[] rightM = new int[height.length];
//            leftM[0] = height[0];
//            for (int i = 1; i < height.length; i++) {
//                leftM[i] = Math.max(leftM[i - 1], height[i]);
//            }
//            rightM[height.length - 1] = height[height.length - 1];
//            for (int i = height.length - 2; i >= 0; i--) {
//                rightM[i] = Math.max(rightM[i + 1], height[i]);
//            }
//            int res = 0;
//            for (int i = 0; i < height.length; i++) {
//                res += Math.min(leftM[i], rightM[i]) - height[i];
//            }
//            return res;

            // 方法2:双指针
            // 核心思想：每个位置能接的雨水量 = min(左边最大高度, 右边最大高度) - 当前高度
            // 关键insight：当 height[left] < height[right] 时，左边的水位必定由 leftMax 决定
            //            因为右边至少有 height[right] 这么高的柱子挡着，水不会从右边流走
            int left = 0;                      // 左指针，从左向右移动
            int right = height.length - 1;     // 右指针，从右向左移动
            int leftMax = 0;                   // 左边遍历过的最大柱子高度
            int rightMax = 0;                  // 右边遍历过的最大柱子高度
            int res = 0;                       // 结果：接到的总雨水量
            while (left < right) {
                if (height[left] < height[right]) {
                    // 左边柱子较矮，说明左边的水位由 leftMax 决定
                    // （右边有更高的柱子挡着，水不会往右流）
                    if (height[left] >= leftMax) {
                        // 当前柱子比左边所有柱子都高，无法接水，更新 leftMax
                        leftMax = height[left];
                    } else {
                        // 当前柱子比 leftMax 矮，可以接 leftMax - height[left] 的水
                        res += leftMax - height[left];
                    }
                    left++;  // 左指针右移
                } else {
                    // 右边柱子较矮或相等，说明右边的水位由 rightMax 决定
                    // （左边有更高的柱子挡着，水不会往左流）
                    if (height[right] >= rightMax) {
                        // 当前柱子比右边所有柱子都高，无法接水，更新 rightMax
                        rightMax = height[right];
                    } else {
                        // 当前柱子比 rightMax 矮，可以接 rightMax - height[right] 的水
                        res += rightMax - height[right];
                    }
                    right--;  // 右指针左移
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        // Solution solution = new Q42_TrappingRainWater().new Solution();
        // put your test code here
        
    }
}