package exam.meituan;

import java.util.Scanner;

public class Main2 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int n = 0;
		int res = 0;
		for (int i = 0; i < T; ++i) {
			n = in.nextInt();
			if (n < 10) {
				System.out.println(n);
				continue;
			}
			int tt = n;
			int bit = 1;
			while ((tt = tt / 10) != 0)
				++bit;
			int tmp = 1;
			for (int j = 1; j < bit; ++j) {
				tmp = 1;
				for (int k = 1; k < j; ++k)
					tmp *= 10;
				res += 9 * tmp * j;
			}
			tmp *= 10;
			res += (n - tmp + 1) * bit;
			System.out.println(res);
			res = 0;
		}
	}

}
