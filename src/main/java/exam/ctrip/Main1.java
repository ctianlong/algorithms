package exam.ctrip;

import java.util.Scanner;

public class Main1 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int l = in.nextInt();
		int[] a = new int[l];
		for (int i = 0; i < l; i++) {
			a[i] = in.nextInt();
		}
		int cnt = 0;
		for (int i = 0; i < l; i++) {
			if (a[i] == 0) {
				cnt++;
			} else {
				a[i - cnt] = a[i];
			}
		}
		for (int i = l - cnt; i < l; i++) {
			a[i] = 0;
		}
		for (int i : a) {
			System.out.println(i);
		}
	}

}
