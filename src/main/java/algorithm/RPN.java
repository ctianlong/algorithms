package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/*
 * 中缀表达式转换为逆波兰表达式(后缀表达式)
 * （1）建立两个栈，一个S1用来存放操作符+ - * / ( )，另一个S2用来存放生成的逆波兰表达式
 * （本文中为了方便用一个字符串来存放逆波兰表达式），操作符栈遵循越往栈顶操作符优先级越高的原则。 
 * （2）从中缀表达式的最左端开始逐个读取字符X，按一下规则对X进行处理： 
 * a：如果X为数字，则直接放入S2 
 * b：如果X为操作符，按以下情况处理： 
 * b1— 如果X为’(‘，则直接压入S1 
 * b2— 如果X为’)‘，则将S1中距离栈顶最近的’(‘之间的元素依次弹出放入S2，’(‘直接抛弃 
 * b3— 如果X为’+ - * /‘，若当前S1为空，则直接将X压入S1，否则将X与S1当前栈顶元素比较，若X的优先级大于S1当前栈顶元素优先级，
 * 则将X直接压入S1，否则将S1的栈顶元素弹出，放入S2，直到S1栈顶运算符优先级低于（不包括等于）X的优先级，此时再则将X压入S1 
 * （3）步骤（2）结束之后，将栈S1中剩余的元素依次弹出，放入S2。
 */
public class RPN {

	private static final int LEFT_BRACKET_PRIORITY = 0; // '('的优先级为0
	private static final int PLUS_PRIORITY = 1; // '+'的优先级为1
	private static final int MINUS_PRIORITY = 1; // '-'的优先级为1
	private static final int MULTI_PRIORITY = 2; // '*'的优先级为2
	private static final int DIVISION_PRIORITY = 2; // '/'的优先级为2

	public static void main(String[] args) {
		System.out.println("Please input an infix expression:");
		Scanner scanner = new Scanner(System.in);
		String infixString = scanner.nextLine();

		StringBuilder rPNStringBuilder = new StringBuilder(); // 最后生成的逆波兰表达式字符串
		Stack<Character> operatorStack = new Stack<Character>(); // 操作符栈

		Map<Character, Integer> operatorMap = new HashMap<Character, Integer>(); // 用来存放操作符的优先级
		operatorMap.put('(', LEFT_BRACKET_PRIORITY);
		operatorMap.put('+', PLUS_PRIORITY);
		operatorMap.put('-', MINUS_PRIORITY);
		operatorMap.put('*', MULTI_PRIORITY);
		operatorMap.put('/', DIVISION_PRIORITY);

		int stackLength = 0;// 用来保存操作符栈的长度，便于弹出元素

		for (int i = 0; i < infixString.length(); i++) {
			if (infixString.charAt(i) == '(') { // 如果为'('，则直接入操作符栈
				operatorStack.push('(');
			} else if (infixString.charAt(i) == '-' || infixString.charAt(i) == '+' || infixString.charAt(i) == '/' || infixString.charAt(i) == '*') {
				char nowOpertor = infixString.charAt(i);
				if (operatorStack.size() == 0) { // 如果当前操作符栈为空，则操作符直接入栈
					operatorStack.push(nowOpertor);
				} else if (operatorMap.get(nowOpertor) > operatorMap.get(operatorStack.peek())) { // 如果当前元素优先级大于栈顶元素优先级，则直接入操作符栈
					operatorStack.push(nowOpertor);
				} else { // 如果当前元素优先级不大于栈顶元素优先级，则将操作符栈中元素弹出，直到操作符栈顶元素低于当前操作符的优先级，再将当前操作符入操作符栈
					stackLength = operatorStack.size();
					for (int j = 0; j < stackLength; j++) {
						char c = operatorStack.pop();
						rPNStringBuilder.append(c + " ");
						if (operatorStack.size() == 0) { // 如果当前操作符栈为空，则操作符直接入栈
							operatorStack.push(nowOpertor);
							break;
						} else if (operatorMap.get(nowOpertor) > operatorMap.get(operatorStack.peek())) {
							operatorStack.push(nowOpertor);
							break;
						}
					}

				}
			} else if (infixString.charAt(i) == ')') { // 如果为')'则将操作符栈中元素逐个出栈，直到遇到'('
				stackLength = operatorStack.size();
				for (int j = 0; j < stackLength; j++) {
					char c = operatorStack.pop();
					if (c == '(') {
						break;
					} else {
						rPNStringBuilder.append(c + " ");
					}
				}
			} else { // 数字则直接添加到逆波兰字符串中
				rPNStringBuilder.append(infixString.charAt(i) + " ");
			}

		}

		// 弹出操作符栈中剩余的元素
		stackLength = operatorStack.size();
		for (int i = 0; i < stackLength; i++) { // 弹出操作符栈中剩余的元素
			rPNStringBuilder.append(operatorStack.pop() + " ");
		}
		System.out.println("The RPN is " + rPNStringBuilder);
		scanner.close();
	}

}
