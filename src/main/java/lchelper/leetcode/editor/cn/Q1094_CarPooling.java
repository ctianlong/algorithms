/**
 * Q1094 拼车
 * 难度：Medium
 * 标签：数组 | 前缀和 | 排序 | 模拟
 *
 * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
 */ 
//
// 给定整数 capacity 和一个数组 trips , trips[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行
//有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。 
//
// 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：trips = [[2,1,5],[3,3,7]], capacity = 4
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：trips = [[2,1,5],[3,3,7]], capacity = 5
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= trips.length <= 1000 
// trips[i].length == 3 
// 1 <= numPassengersi <= 100 
// 0 <= fromi < toi <= 1000 
// 1 <= capacity <= 10⁵ 
// 
//
// Related Topics数组 | 前缀和 | 排序 | 模拟 | 堆（优先队列） 
//
// 👍 438, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package lchelper.leetcode.editor.cn;

import java.util.*;
import lchelper.leetcode.editor.common.*;

public class Q1094_CarPooling {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            int[] nums = new int[1001];
            Diff diff = new Diff(nums);
            for (int[] update : trips) {
                diff.increment(update[1], update[2] - 1, update[0]);
            }
            int[] res = diff.result();
            for (int i = 0; i < res.length; i++) {
                if (res[i] > capacity) {
                    return false;
                }
            }
            return true;
        }
    }

    class Diff {
        int[] diff;
        public Diff(int[] nums) {
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }
        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }
        public int[] result() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new Q1094_CarPooling().new Solution();
        // put your test code here
        
    }
}