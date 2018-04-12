package exam.jd;

import java.util.Scanner;
import java.util.Stack;

public class Main3 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] d = new String[n];
		for (int i = 0; i < n; ++i) {
			d[i] = in.next();
		}
		for (int i = 0; i < n; ++i) {
			String s = d[i];
			int len = s.length();
			boolean f = false;
			out:for (int j = 0; j < len - 1; ++j)
				for (int k = j + 1; k < len; ++k) {
					char[] c = s.toCharArray();
					char t = c[j];
					c[j] = c[k];
					c[k] = t;
					if (isValid(c)) {
						System.out.println("Yes");
						f = true;
						break out;
					}
				}
			if (!f)
				System.out.println("No");
		}
		
	}
	
	public static boolean isValid(char[] c) {
		Stack<Character> stack = new Stack<Character>();
		for (char cc : c) {
			if (cc == '(')
				stack.push(')');
			else if (stack.isEmpty())
				return false;
			else
				stack.pop();
		}
		return stack.isEmpty();
	}
}
