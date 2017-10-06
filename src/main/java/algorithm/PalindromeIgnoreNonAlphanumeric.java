package algorithm;

import javax.swing.JOptionPane;

/**
 * 忽略既非字母又非数字的字符，判断回文串，利用翻转判断
 * @author tianlong
 *
 */
public class PalindromeIgnoreNonAlphanumeric {

	public static void main(String[] args) {
		String s = JOptionPane.showInputDialog("Enter a string:");
		String output = "Ignoring nonalphanumeric character, \nis " + s + " a palindrome? " + isPalindrome(s);
		JOptionPane.showMessageDialog(null, output);
	}
	
	public static boolean isPalindrome(String s) {
		String s1 = filter(s);
		String s2 = reverse(s1);
		return s1.equals(s2);
	}
	
	public static String filter(String s) {
		StringBuffer strbuf = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			if(Character.isLetterOrDigit(s.charAt(i)))
				strbuf.append(s.charAt(i));
		}
		return strbuf.toString();
	}
	
	public static String reverse(String s) {
		StringBuffer strbuf = new StringBuffer(s);
		strbuf.reverse();
		return strbuf.toString();
	}
}
