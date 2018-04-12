package exam.zhaoshang;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		int cnt = 0;
		int res = 0;
		while (cnt < n) {
			res++;
			int t = res;
			boolean f = true;
			while (t != 1 && f) {
				if (t % 5 == 0) {
					t /= 5;
				} else if (t % 3 == 0) {
					t /= 3;
				} else if ((t & 1) == 0) {
					t >>= 1;
				} else {
					f = false;
				}
			}
			if (f) cnt++;
		}
		System.out.println(res);
	}
}
