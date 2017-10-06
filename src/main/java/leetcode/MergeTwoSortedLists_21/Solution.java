package leetcode.MergeTwoSortedLists_21;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * 二路归并
 * 
 * @author Tianlong
 *
 */
public class Solution {

	/**
	 * 一般的二路归并算法，依次取两个链表的前两个元素比较，将排序靠前的元素ele加入返回结果链表中， 再取ele元素的下一个比较，直到其中一个链表结束。
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode priv = new ListNode(0);
		ListNode p = priv;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				p.next = l1;
				p = l1; //1
				l1 = l1.next;
			} else {
				p.next = l2;
				p = l2; //2
				l2 = l2.next;
			}
//			p = p.next; //可用于代替上面的1和2
		}
		p.next = (l1 == null) ? l2 : l1;
		return priv.next;
	}
	
	/**
	 * 递归方式二路归并,代码简介
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

}

/**
 * Definition for singly-linked list.
 * 
 * @author Tianlong
 *
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
