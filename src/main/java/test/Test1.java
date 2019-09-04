package test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class Test1 {
	
	public static void main(String[] args) {
		int num = 8;
		System.out.println(num & ~(num - 1));
		System.out.println(-757 == ~757 + 1);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		StringBuffer sb = new StringBuffer();
		int[] arr = new int['z'];
		System.out.println((long) Math.sqrt(4));
		System.out.println((2 & 1) == 1);
		System.out.println(Math.pow(0, -1)); // Infinity
		System.out.println(-1 & 0xFF);
		System.out.println(1 << -1);
		int x = 2; int y = 3;
		System.out.println((double) x / (double) y);
		System.out.println(Integer.parseInt("00FF", 16));
		Map<Integer, Integer> map = new TreeMap<>();
		map.put(1, 3);
		map.put(3, 5);
		map.put(2, 1);
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			System.out.println(e.getKey() + ":" + e.getValue());
		}
		for (Integer i : map.keySet()) {
			System.out.println(i);
		}
		for (Integer j : map.values()) {
			System.out.println(j);
		}
		Collection<Integer> values = map.values();
		Iterator<Integer> iterator = values.iterator();
		
	}
	
	@Test
	public void test1() {
		StringBuffer sb = new StringBuffer("we are happy");
		int i = 0;
		while (i < sb.length()) {
			if (' ' == sb.charAt(i)) {
				sb.replace(i, i + 1, "%20");
				i = i + 3;
			} else {
				i++;
			}
		}
		System.out.println(sb.toString());
	}
	
	@Test
	public void test2 () {
		int[] array = {2,1,4,5,6,8,7,3};
		int p = -1;
        for (int i = 0; i < array.length; ++i) {
            if ((array[i] & 1) == 1) {
                if (p + 1 != i) {
                    int tmp = array[i];
                    for (int j = i - 1; j >= p + 1; --j) {
                        array[j + 1] = array[j];
                    }
                    array[p + 1] = tmp;
                }
                ++p;
            }
        }
        System.out.println(Arrays.toString(array));
	}
	
	@Test
	public void test3() {
		StringBuffer str = new StringBuffer("   ");
		/*
		 * 以下解法时间复杂度为O(n2)，从前往后替换，每次replace时都会将替换点之后的字符往后移，移动次数多 int i = 0; while (i <
		 * str.length()) { if (' ' == str.charAt(i)) { str.replace(i, i + 1, "%20"); i =
		 * i + 3; } else { i++; } } return str.toString();
		 */
		/* 采用从后往前替换，先遍历求出空格数，改变数组长度，再从后往前移，时间复杂度 O(n) */
		int oldLen = str.length();
		int spaceNum = 0;
		for (int i = 0; i < oldLen; ++i) {
			if (' ' == str.charAt(i))
				++spaceNum;
		}
		int newLen = oldLen + 2 * spaceNum;
		str.setLength(newLen);
		int oldIndex = oldLen - 1;
		int newIndex = newLen - 1;
		while (oldIndex >= 0 && oldIndex < newIndex) {
			if (str.charAt(oldIndex) == ' ') {
				str.setCharAt(newIndex--, '0');
				str.setCharAt(newIndex--, '2');
				str.setCharAt(newIndex--, '%');
			} else {
				str.setCharAt(newIndex--, str.charAt(oldIndex));
			}
			--oldIndex;
		}
		System.out.println(str);
	}
	
	@Test
	public void test111() {
		int n = 3;
		int bit = 1;
		while ((n = n / 10) != 0)
			++bit;
		System.out.println(bit);
	}

}
