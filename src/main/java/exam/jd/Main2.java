package exam.jd;

import java.util.Scanner;

public class Main2 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] d = new long[n];
		for (int i = 0; i < n; ++i) {
			d[i] = in.nextLong();
		}
		boolean ff = false;
		for (int i = 0; i < n; ++i) {
			if (i == n - 1)
				ff = true;
			long v = d[i];
			if ((v & 1) == 1) {
				if (ff)
					System.out.print("No");
				else
					System.out.println("No");
			} else if (v == 2) {
				if (ff)
					System.out.print("1 2");
				else
					System.out.println("1 2");
			} else {
				long sq = (long) Math.sqrt(v);
				long j = 1;
				long x = 0, y = 0;
				boolean f = false;
				for (; j <= sq; ++j) {
					if (v % j == 0) {
						if ((j & 1) == 0) {
							long t = v / j;
							if ((t & 1) == 1) {
								if (ff)
									System.out.print(t + " " + j);
								else
									System.out.println(t + " " + j);
								break;
							}
						} else {
							x = j;
							y = v / j;
							f = true;
						}
					}
				}
				if (j > sq) {
					if (f)
						if (ff)
							System.out.print(x + " " + y);
						else
							System.out.println(x + " " + y);
					else
						if (ff)
							System.out.print("No");
						else
							System.out.println("No");
				}
			}
		}
	}

}
