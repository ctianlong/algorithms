/**
 * Q1109 航班预订统计
 * 难度：Medium
 * 标签：数组 | 前缀和
 *
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 */ 
//
// 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 
//firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。 
//
// 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。 
//
// 
//
// 示例 1： 
//
// 
//输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
//输出：[10,55,45,25,25]
//解释：
//航班编号        1   2   3   4   5
//预订记录 1 ：   10  10
//预订记录 2 ：       20  20
//预订记录 3 ：       25  25  25  25
//总座位数：      10  55  45  25  25
//因此，answer = [10,55,45,25,25]
// 
//
// 示例 2： 
//
// 
//输入：bookings = [[1,2,10],[2,2,15]], n = 2
//输出：[10,25]
//解释：
//航班编号        1   2
//预订记录 1 ：   10  10
//预订记录 2 ：       15
//总座位数：      10  25
//因此，answer = [10,25]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2 * 10⁴ 
// 1 <= bookings.length <= 2 * 10⁴ 
// bookings[i].length == 3 
// 1 <= firsti <= lasti <= n 
// 1 <= seatsi <= 10⁴ 
// 
//
// Related Topics数组 | 前缀和 
//
// 👍 558, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package lchelper.leetcode.editor.cn;

import java.util.*;
import lchelper.leetcode.editor.common.*;

public class Q1109_CorporateFlightBookings {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            int[] nums = new int[n];
            Diff diff = new Diff(nums);
            for (int[] update : bookings) {
                diff.incr(update[0] - 1, update[1] - 1, update[2]);
            }
            return diff.result();
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

        public void incr(int i, int j, int v) {
            diff[i] += v;
            if (j + 1 < diff.length) {
                diff[j + 1] -= v;
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
        Solution solution = new Q1109_CorporateFlightBookings().new Solution();
        // put your test code here
        
    }
}