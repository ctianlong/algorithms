package algorithm.recursion;

import javax.swing.JOptionPane;

/**
 * 递归，斐波那契数列，不实用
 * @author tianlong
 *
 */
public class ComputeFibonacci {

	public static void main(String[] args) {
		String intString = JOptionPane.showInputDialog("Enter an index for the Fibonacci number:");
		int index = Integer.parseInt(intString);
		JOptionPane.showMessageDialog(null, "Fibonacci number at index " + index + " is " + fib2(index));
	}

	//递归方法
	public static long fib(long index) {
		return (index > 1) ? (fib(index -1) + fib(index - 2)) : index; 
	}
	
	
	//用非递归实现，用三个变量实现
	public static long fib2(long index){
		if(index == 1 || index == 2){
			return 1L;
		}
		
		long f1 = 1L;
		long f2 = 1L;
		long f = 0L;
		
		for(int i = 0; i < index - 2; i++){
			f = f1 + f2;
			f1 = f2;
			f2 = f;
		}
		
		return f;
	}

}
