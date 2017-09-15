package algorithm.exam;

import java.util.*;

public class Main2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		in.close();
		if (m <= 1 || m >= 100) {
			System.out.println("ERROR!");
		} else {
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i <= 100; i++) {
				list.add(i, i);
			}
			int i = 1;
			while(true) {
				i += (m -1);
				int num = list.size() - 1;
//				int tmp = i;
				if (i > num) {
					i -= num;
				}
//				if (i == 0) {
//					System.out.println(tmp);
//					System.out.println(num);
//					System.out.println(list);
//					System.exit(0);
//				}
				list.remove(i);
				if (num - 1 < m) {
					break;
				}
			}
//			System.out.println(list);
			StringBuilder sb = new StringBuilder();
			for (int j = 1; j < m; j++) {
				sb.append(list.get(j) + ",");
			}
			System.out.println(sb.substring(0, sb.length() - 1));
		}
	}
}
