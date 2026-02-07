/**
 * Q1352 最后 K 个数的乘积
 * 难度：Medium
 * 标签：数组 | 设计 | 队列 | 前缀和
 *
 * 设计一个算法，该算法接受一个整数流并检索该流中最后 k 个整数的乘积。
 */ 
//
// 实现 ProductOfNumbers 类： 
//
// 
// ProductOfNumbers() 用一个空的流初始化对象。 
// void add(int num) 将数字 num 添加到当前数字列表的最后面。 
// int getProduct(int k) 返回当前数字列表中，最后 k 个数字的乘积。你可以假设当前列表中始终 至少 包含 k 个数字。 
// 
//
// 题目数据保证：任何时候，任一连续数字序列的乘积都在 32 位整数范围内，不会溢出。 
//
// 
//
// 示例： 
//
// 
//输入：
//["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct",
//"getProduct","add","getProduct"]
//[[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]
//
//输出：
//[null,null,null,null,null,null,20,40,0,null,32]
//
//解释：
//ProductOfNumbers productOfNumbers = new ProductOfNumbers();
//productOfNumbers.add(3);        // [3]
//productOfNumbers.add(0);        // [3,0]
//productOfNumbers.add(2);        // [3,0,2]
//productOfNumbers.add(5);        // [3,0,2,5]
//productOfNumbers.add(4);        // [3,0,2,5,4]
//productOfNumbers.getProduct(2); // 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
//productOfNumbers.getProduct(3); // 返回 40 。最后 3 个数字的乘积是 2 * 5 * 4 = 40
//productOfNumbers.getProduct(4); // 返回  0 。最后 4 个数字的乘积是 0 * 2 * 5 * 4 = 0
//productOfNumbers.add(8);        // [3,0,2,5,4,8]
//productOfNumbers.getProduct(2); // 返回 32 。最后 2 个数字的乘积是 4 * 8 = 32 
// 
//
// 
//
// 提示： 
//
// 
// 0 <= num <= 100 
// 1 <= k <= 4 * 10⁴ 
// add 和 getProduct 最多被调用 4 * 10⁴ 次。 
// 在任何时间点流的乘积都在 32 位整数范围内。 
// 
//
// 
//
// 进阶：您能否 同时 将 GetProduct 和 Add 的实现改为 O(1) 时间复杂度，而不是 O(k) 时间复杂度？ 
//
// Related Topics设计 | 数组 | 数学 | 数据流 | 前缀和 
//
// 👍 124, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package lchelper.leetcode.editor.cn;

import java.util.*;
import lchelper.leetcode.editor.common.*;

public class Q1352_ProductOfTheLastKNumbers {

    //leetcode submit region begin(Prohibit modification and deletion)
    class ProductOfNumbers {
        private List<Integer> list;
    
        public ProductOfNumbers() {
//            list = new ArrayList<>();

            // 方法2，前缀积，0特殊处理
            list = new ArrayList<>();
            list.add(1);
        }
        
        public void add(int num) {
            // 类似后缀积，但出现0时会浪费大量无用元素空间
//            list.add(num);
//            if (num != 1) {
//                for (int i = 0; i < list.size() - 1; i++) {
//                    list.set(i, list.get(i) * num);
//                }
//            }

            // 方法2，前缀积，0特殊处理
            if (num == 0) {
                list.clear();
                list.add(1);
            } else {
                list.add((list.get(list.size() - 1)) * num);
            }
        }
        
        public int getProduct(int k) {
//            return list.get(list.size() - k);

            // 方法2，前缀积，0特殊处理
            if (list.size() <= k) {
                return 0;
            }
            return list.get(list.size() - 1) / list.get(list.size() - k - 1);
        }
    }
    
    /**
     * Your ProductOfNumbers object will be instantiated and called as such:
     * ProductOfNumbers obj = new ProductOfNumbers();
     * obj.add(num);
     * int param_2 = obj.getProduct(k);
     */
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
//        Solution solution = new Q1352_ProductOfTheLastKNumbers().new Solution();
        // put your test code here
        
    }
}