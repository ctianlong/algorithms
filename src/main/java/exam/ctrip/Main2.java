package exam.ctrip;

import java.util.Scanner;
public class Main2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		String[] fir = s.split(" ");
		int n = fir.length;
		int[][] mat = new int[n][n];
		for (int i = 0; i < n; i++)
			mat[i][n - 1] = Integer.valueOf(fir[i]);
		for (int y = n - 2; y >= 0; y--)
			for (int x = 0; x < n; x++)
				mat[x][y] = in.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j == n - 1)
					System.out.print(mat[i][j]);
				else
					System.out.print(mat[i][j] + " ");
			}
			if (i != n -1)
				System.out.println();
		}
	}
}
