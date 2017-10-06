package algorithm.exam;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] w = new int[n];
		for (int i = 0; i < n; i++) {
			w[i] = in.nextInt();
		}
		in.close();
		int time = 0;
		int[] now = new int[m];
		for (int i = 0; i < m; i++) {
			now[i] = w[i];
		}
		int next = m;
		while(true) {
			for (int i = 0; i < m; i++) {
				if(now[i] == 0 && next < n) {
					now[i] = w[next];
					next++;
				}
			}
			boolean over = true;
			for (int i = 0; i < m; i++) {
				if (now[i] > 0) {
					now[i]--;
					over = false;
				}
			}
			if(over) {
				break;
			}
			time++;
		}
		System.out.println(time);
	}
}
