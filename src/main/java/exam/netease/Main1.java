package exam.netease;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 矩形重叠，网易2018春招（2019实习）
 * https://www.nowcoder.com/discuss/70736?type=0&order=0&pos=14&page=1
 * 时间限制：1秒

	空间限制：32768K
	
	平面内有n个矩形, 第i个矩形的左下角坐标为(x1[i], y1[i]), 右上角坐标为(x2[i], y2[i])。
	
	如果两个或者多个矩形有公共区域则认为它们是相互重叠的(不考虑边界和角落)。
	
	请你计算出平面内重叠矩形数量最多的地方,有多少个矩形相互重叠。
	
	
	输入描述:
	输入包括五行。
	第一行包括一个整数n(2 <= n <= 50), 表示矩形的个数。
	第二行包括n个整数x1[i](-10^9 <= x1[i] <= 10^9),表示左下角的横坐标。
	第三行包括n个整数y1[i](-10^9 <= y1[i] <= 10^9),表示左下角的纵坐标。
	第四行包括n个整数x2[i](-10^9 <= x2[i] <= 10^9),表示右上角的横坐标。
	第五行包括n个整数y2[i](-10^9 <= y2[i] <= 10^9),表示右上角的纵坐标。
	
	
	输出描述:
	输出一个正整数, 表示最多的地方有多少个矩形相互重叠,如果矩形都不互相重叠,输出1。
	
	输入例子1:
	2
	0 90
	0 90
	100 200
	100 200
	
	输出例子1:
	2
	
 * @author ctl
 *
 */
public class Main1 {
	/**
	 * 分别枚举所有的横纵坐标,挨着判断每个矩形是否符合条件，计数维护最大即可。
	 * 
	 * 时间复杂度 O(n^3)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] x1 = new int[n];
		int[] y1 = new int[n];
		int[] x2 = new int[n];
		int[] y2 = new int[n];
		Set<Integer> xx = new HashSet<>();
		Set<Integer> yy = new HashSet<>();
		for (int i = 0; i < n; i++) {
			x1[i] = in.nextInt();
			xx.add(x1[i]);
		}
		for (int i = 0; i < n; i++) {
			y1[i] = in.nextInt();
			yy.add(y1[i]);
		}
		for (int i = 0; i < n; i++) {
			x2[i] = in.nextInt();
			xx.add(x2[i]);
		}
		for (int i = 0; i < n; i++) {
			y2[i] = in.nextInt();
			yy.add(y2[i]);
		}
		int ans = 0;
		for (int x : xx) { // 枚举的x,y全都来自于所有矩形左下角和右上角的x,y，不用类似从0~n这种
			for (int y : yy) {
				int cnt = 0;
				for (int i = 0; i < n; i++)
					if (x >= x1[i] && y >= y1[i] && x < x2[i] && y < y2[i]) cnt++; // 注意边界，只有一个角能够使用等于符号
				if (ans < cnt) ans = cnt;
			}
		}
		System.out.println(ans);
	}
}
