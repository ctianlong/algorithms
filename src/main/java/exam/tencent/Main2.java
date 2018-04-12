package exam.tencent;

import java.util.Scanner;

public class Main2 {
	
	public static void main(String[] args) {
		System.out.println(combine(6, 4));
		Scanner in = new Scanner(System.in);
		int K = in.nextInt();
		int A = in.nextInt();
		int X = in.nextInt();
		int B = in.nextInt();
		int Y = in.nextInt();
		long res = 0;
		int tmp;
		int j;
		for (int i = 0; i <= X; i++) {
			tmp = K - A * i;
			if (tmp % B == 0) {
				j = tmp / B;
				res += combine(X, i) * combine(Y, j);
				if (res >= 1000000007)
					res %= 1000000007;
			}
		}
		System.out.println(res);
	}
	
	public static long combine(int x, int y) {
		if (y == 0) return 0;
		if (y > x / 2)
			y = x - y;
		long a = 1;
		for (int i = 0; i < y; i++) {
			a = a * x;
			x--;
		}
		long b = 1;
		while (y > 1) {
			b = b * y;
			y--;
		}
		return a / b;
	}

}
