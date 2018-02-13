package algorithm;

import javax.swing.JOptionPane;

/**
 * 检测回文串
 * @author tianlong
 *
 */
public class CheckPalindrome {

	public static void main(String[] args) {
		String s = JOptionPane.showInputDialog("Enter a string:");
		String output = "";
		if(isPalindrome(s))
			output = s + " is a palindrome";
		else 
			output = s + " is not a palindrome";
		
		JOptionPane.showMessageDialog(null, output);
	}
	
	public static boolean isPalindrome(String s) {
		int low = 0;
		int high = s.length() - 1;
		while(low < high){
			if(s.charAt(low) != s.charAt(high))
				return false;
			low++;
			high--;
		}
		return true;
	}
	
}
