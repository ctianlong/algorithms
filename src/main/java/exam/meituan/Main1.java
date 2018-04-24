package exam.meituan;

import java.util.Scanner;

public class Main1 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int n = in.nextInt();
		int m = in.nextInt();
		int p = in.nextInt();
		int[] A = new int[N + 1];
		A[1] = p;
		for (int i = 2; i <= N; ++i) {
			A[i] = (A[i - 1] + 153) % p;
		}
		int sum = 0;
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= m; ++j) {
				sum += A[gcd(i, j)];
			}
		}
		System.out.println(sum);
	}
	
	public static int gcd(int x, int y) {
		if (y == 0) return x;
		int r = x % y;
		return gcd(y, r);
	}

}
