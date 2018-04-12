package exam.huawei;

import java.util.Scanner;

public class Main2 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		String[] ss = s.split(":");
		int len = ss.length;
		if (len != 8) {
			System.out.println("Error");
			return;
		}
		if (ss[7].equals("0001")) {
			int i;
			for (i = 0; i < 7; i++) {
				if (!ss[i].equals("0000")) break;
			}
			if (i == 7) {
				System.out.println("Loopback");
				return;
			}
		}
		if (ss[7].equals("0000")) {
			int i;
			for (i = 0; i < 7; i++) {
				if (!ss[i].equals("0000")) break;
			}
			if (i == 7) {
				System.out.println("Unspecified");
				return;
			}
		}
		if (ss[0].startsWith("FF")) {
			System.out.println("Multicast");
			return;
		}
		int f16 = Integer.parseInt(ss[0], 16);
		int f10 = f16 & 0xFFC0;
		if (f10 == 0xFE80) {
			System.out.println("LinkLocal");
			return;
		}
		if (f10 == 0xFEC0) {
			System.out.println("SiteLocal");
			return;
		}
		System.out.println("GlobalUnicast");
	}

}
