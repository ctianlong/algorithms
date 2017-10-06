package algorithm.recursion;

import javax.swing.JOptionPane;

/**
 * 递归概念的演示，计算阶乘，不实用
 * @author tianlong
 *
 */
public class ComputeFactorial {

	public static void main(String[] args) {
		String intString = JOptionPane.showInputDialog("Enter a non-negative interger:");
		int n = Integer.parseInt(intString);
		JOptionPane.showMessageDialog(null, "Factorial of " + n + " is " + factorial(n));
	}

	public static long factorial(int n) {
		if (n == 0)
			return 1;
		else
			return n * factorial(n - 1);
	}

}
