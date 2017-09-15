package leetcode.AddTwoNumbers_2;

import org.junit.Test;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 * 
 * @author Tianlong
 *
 */
public class Solution {

	@Test
	public void test() {
		// do some test
	}

	/**
	 * 方案2：通过类似加法笔算的方式，只涉及一位数字加法，计算量小，速度快，可以计算无限长数字。
	 * 	添加头部虚拟节点，解决firstNode的创建问题
	 * 	可以用 或条件 将整个问题包含在一个循环中，或者用 与条件 将问题分成两部分
	 * 
	 * Your runtime beats 39.18 % of java submissions.
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p1 = l1, p2 = l2, curr = dummyHead;
		int sum = 0;
		while ((p1 != null) && (p2 != null)) {
			sum += p1.val + p2.val;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			sum /= 10;
			p1 = p1.next;
			p2 = p2.next;
		}
		ListNode p = null;
		if (p1 == null) {
			p = p2;
		} else {
			p = p1;
		}
		while (p != null) {
			sum += p.val;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			sum /= 10;
			p = p.next;
		}
		if (sum > 0) {
			curr.next = new ListNode(sum);
		}
		return dummyHead.next;
	}

	/**
	 * 方案1（不通过）：如果从两个链表中分别生成数字，将两个数字相加，再将所得的结果转换为链表。
	 * 	该方案会受限于数字最大范围（最大为long），一旦数字大小超过long便无法转换。
	 * 	同时从链表生成数字和从数字生成链表这两个过程都非常耗时，计算量相对较大。
	 * 	无法处理无限长度的数字，且数字越长，所涉及的计算数字越大，速度越慢。
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		long num1 = getNumFromList(l1);
		long num2 = getNumFromList(l2);
		long sum = num1 + num2;
		return getListFromNum(sum);
	}

	private long getNumFromList(ListNode list) {
		long num = 0;
		ListNode cur;
		long mult;
		for (cur = list, mult = 1; cur != null; cur = cur.next, mult *= 10) {
			num += cur.val * mult;
		}
		return num;
	}

	private ListNode getListFromNum(long num) {
		ListNode firstNode = new ListNode((int) (num % 10));
		ListNode curNode = firstNode;
		num /= 10;
		while (num > 0) {
			ListNode nextNode = new ListNode((int) (num % 10));
			curNode.next = nextNode;
			curNode = nextNode;
			num /= 10;
		}
		return firstNode;
	}

}

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
