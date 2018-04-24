package tooffer;

import java.util.Stack;
/*
 * 两个栈拼成一个队列
 */
public class Solution7 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	if (!stack2.isEmpty())
    		return stack2.pop();
    	if (stack1.isEmpty())
    		throw new RuntimeException("Empty queue");
    	while (!stack1.isEmpty()) {
    		stack2.push(stack1.pop());
    	}
    	return stack2.pop();
    }
}
