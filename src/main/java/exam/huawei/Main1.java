package exam.huawei;

import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int len = s.length();
		if (len < 2) System.out.println(len);
		char[] c = s.toCharArray();
		int res = 1;
		int x, y, t;
		for (int i = 0; i < len; i++) {
			x = i - 1;
			y = i + 1;
			t = 1;
			while (x >= 0 && y < len && c[x] == c[y]) {
				t = t + 2;
				x--;
				y++;
			}
			if (t > res) res = t;
			x = i;
			y = i + 1;
			t = 0;
			while (x >= 0 && y < len && c[x] == c[y]) {
				t = t + 2;
				x--;
				y++;
			}
			if (t > res) res = t;
		}
		System.out.println(res);
	}
}
