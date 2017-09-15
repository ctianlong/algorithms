package algorithm;

import javax.swing.JOptionPane;

/**
 * 统计字符串中的每个字母出现次数，忽略大小写
 * @author tianlong
 *
 */
public class CountEachLetter {

	public static void main(String[] args) {
		String s = JOptionPane.showInputDialog("Enter a string:");
		int[] count = countLetters(s.toLowerCase());
		String output = "";
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0)
				output += (char) ('a' + i) + " appears " + count[i] + (count[i] == 1 ? " time\n" : " times\n");
		}

		JOptionPane.showMessageDialog(null, output);
	}

	public static int[] countLetters(String s) {
		int[] count = new int[26];
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLowerCase(s.charAt(i)))
				count[s.charAt(i) - 'a']++;
		}
		return count;
	}

}
