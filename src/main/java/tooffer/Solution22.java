package tooffer;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class Solution22 {
	
	public static void main(String[] args) {
		int[] push = {1,2,3,4,5};
		int[] pop = {4,5,3,2,1};
		int[] pop2 = {4,3,5,1,2};
		System.out.println(new Solution22().IsPopOrder(push, pop));
	}

	/*
	 * 创建一个辅助栈，模拟入栈，出栈，按照出栈的顺序来对应入栈顺序，看是否能够完全对应
	 */
	public boolean IsPopOrder(int[] pushA, int[] popA) {
		if (pushA == null || popA == null || pushA.length != popA.length || pushA.length == 0)
			return false;
		Deque<Integer> stack = new ArrayDeque<>();
		int len = pushA.length;
		int in = 0, out = 0;
		while (out < len) {
			if (stack.isEmpty() || stack.peek() != popA[out]) {
				while (in < len && pushA[in] != popA[out]) {
					stack.push(pushA[in++]);
				}
				if (in == len)
					return false;
				++in;
				++out;
			} else {
				stack.pop();
				++out;
			}
		}		
		return true;
	}

}
