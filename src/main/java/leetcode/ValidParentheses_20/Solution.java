package leetcode.ValidParentheses_20;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * 
 * @author Tianlong
 *
 */
public class Solution {

	public static void main(String[] args) {
		String s = "({[(])})";
		System.out.println(isValid(s));
		// System.out.println('(' + 0);
		// System.out.println(')' + 0);
		// System.out.println('[' + 0);
		// System.out.println(']' + 0);
		// System.out.println('{' + 0);
		// System.out.println('}' + 0);

	}

	/**
	 * 一些比较特殊的错误情况: "","((","))","())?" 
	 * 思路： 若字符串长度n为奇数，返回false；
	 * 使用栈，采用长度固定为len=n/2的数组实现，因为在有效情况下所需要的栈空间最长为n/2，否则均为无效；
	 * 不使用List，防止速度慢；
	 * 栈顶指针top指向栈顶元素下标，初始为-1； 
	 * 遍历长度为n的字符串：
	 * 		1、若为 '(','[','{',则入栈，若此时栈溢出，则程序结束，返回false；
	 * 		2、若为')',']','}',则判断当前栈顶元素是否与之相匹配为一对括号，若匹配，则弹出栈顶元素，若不匹配，则程序结束，返回false；
	 * 遍历结束，判断top回到起始位置-1,若是，则返回true,否则返回false;
	 * @param s
	 * @return
	 */
	public static boolean isValid(String s) {
		char[] c = s.toCharArray();
		if (c.length % 2 == 1)
			return false;
		char[] stack = new char[c.length / 2];
		int top = -1;
		for (int i = 0; i < c.length; i++) {
			switch (c[i]) {
			case '(':
			case '[':
			case '{':
				if (top < stack.length - 1)
					stack[++top] = c[i];
				else
					return false;
				break;
			case ')':
			case ']':
			case '}':
				if (top > -1 && (c[i] - stack[top] == 2 || c[i] - stack[top] == 1))
					top--;
				else
					return false;
				break;
			}
		}
		return true;
	}
	
	/**
	 * 网友答案，直接使用Java中的Stack类，方便，
	 * 遇到'(',入栈')',使用这种方式可以省去后面遇到')'时的匹配，直接判断相等就可以
	 * @param s
	 * @return
	 */
	public static boolean isValid2(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}

}
