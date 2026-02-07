/**
 * Q61 旋转链表
 * 难度：Medium
 * 标签：链表 | 双指针
 *
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
// 
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 10⁹ 
// 
//
// Related Topics链表 | 双指针 
//
// 👍 1168, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package lchelper.leetcode.editor.cn;

import java.util.*;
import lchelper.leetcode.editor.common.*;

public class Q61_RotateList {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            // 先成环，再断开，找到新链表的尾节点，断开后继节点
            if (k == 0) {
                return head;
            }
            // 先统计节点个数，同时找到尾节点
            int n = 0;
            ListNode p = head;
            ListNode tail = null;
            while (p != null) {
                n++;
                tail = p;
                p = p.next;
            }
            if (n == 0) {
                return null;
            }
            k = k % n;
            if (k == 0) {
                return head;
            }
            // 新链表的尾节点为原链表中的第(n-k)个节点，从1开始数
            // 成环
            tail.next = head;
            // 找到原链表中的第(n-k)个节点
            p = head;
            int i = 1;
            while (i < n - k) {
                p = p.next;
                i++;
            }
            ListNode newHead = p.next;
            p.next = null;
            return newHead;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new Q61_RotateList().new Solution();
        // put your test code here
        
    }
}