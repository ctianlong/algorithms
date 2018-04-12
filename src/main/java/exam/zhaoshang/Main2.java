package exam.zhaoshang;

import java.util.Scanner;

public class Main2 {
	
	public static void main(String[] args) {
		int x = new Scanner(System.in).nextInt();
		x = x < 0 ? -x : x;
		if (x == 0) System.out.println(0);
		System.out.println(x);
	}

}
