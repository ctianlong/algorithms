package tooffer;

import java.util.LinkedList;
import java.util.List;

/*
 * 约瑟夫环
 * 0,1,2,...,n-1这n个数围成一个圈，从数字0开始每次从这个圆圈里删除第m个数字，求最后剩下的数字
 */
public class Solution45 {

	/*
	 * 思路1：循环链表模拟，可以自己实现，也可以直接借助java中的链表，比如LinkedList
	 * 时间复杂度O(mn),空间复杂度O(n)
	 */
	public int LastRemaining_Solution0(int n, int m) {
		if (n < 1 || m < 1)
			return -1;
		List<Integer> numbers = new LinkedList<>();
		for (int i = 0; i < n; ++i) {
			numbers.add(i);
		}
		int size;
		int index = 0;
		while ((size = numbers.size()) > 1) {
			index = (index + m - 1) % size;
			numbers.remove(index);
			if (index == size - 1) {
				index = 0;
			}
		}
		return numbers.get(0);
	}
	/*
	 * 自己实现循环链表（单向）
	 */
	public int LastRemaining_Solution1(int n, int m) {
		if (n < 1 || m < 1)
			return -1;
		Node head = new Node(0);
		Node p = head;
		for (int i = 1; i < n; ++i) {
			p.next = new Node(i);
			p = p.next;
		}
		p.next = head; // 此时p指向尾节点
		while (p.next != p) {
			// 使p数到第m-1个节点
			for (int i = 1; i < m; ++i) {
				p = p.next;
			}
			p.next = p.next.next; // 删除第m个节点
		}
		return p.val;
	}
	static class Node {
		int val;
		Node next;
		Node (int val) {
			this.val = val;
		}
	}
	
	/*
	 * 思路2：分析规律，效率高
	 * 通过复杂分析，详见剑指offer，可得：
	 * f(n,m)=0   (n=1)
	 * f(n,m)=(f(n-1,m)+m)%n    (n>1)
	 * 可通过递归或循环实现
	 */
	public int LastRemaining_Solution(int n, int m) {
		if (n < 1 || m < 1)
			return -1;
		int last = 0;
		for (int i = 2; i <= n; ++i) {
			last = (last + m) % i;
		}
		return last;
	}

}
