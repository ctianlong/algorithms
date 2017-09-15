package leetcode.RomantoInteger_13;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	static final Map<Character, Integer> map = new HashMap<>();
	static {
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
	}
	
	/**
	 * 第二版，取字符操作不重复；字符串转为字符数组；不用map，自己写方法转
	 * @param s
	 * @return
	 */
	public int romanToInt2(String s) {
		char[] list = s.toCharArray();
		int curr = conv(list[0]), next, sum = 0;
		for (int i = 1; i < list.length; i++) {
			next = conv(list[i]);
			if (curr < next) {
				sum -= curr;
			} else {
				sum += curr;
			}
			curr = next;
		}
		sum += conv(list[list.length - 1]);
		return sum;
	}
	
	private int conv(char c){
        switch(c){
            case 'M':
                return 1000;
            case 'I':
                return 1;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'V':
                return 5;
            default:
            	return 0;
        }
    }
	
	/**
	 * 第一版，取对应位置字符操作重复
	 * @param s
	 * @return
	 */
	public int romanToInt1(String s) {
		int len = s.length();
		int sum = 0;
		int curr, next;
		for (int i = 0; i < len - 1; i++) {
			curr = map.get(s.charAt(i));
			next = map.get(s.charAt(i + 1));
			if (curr < next) {
				sum -= curr;
			} else {
				sum += curr;
			}
		}
		sum += map.get(s.charAt(len - 1));
		return sum;
	}

}
