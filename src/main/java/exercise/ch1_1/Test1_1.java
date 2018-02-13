package exercise.ch1_1;



import java.util.Arrays;

import org.junit.Test;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Test1_1 {

	/*
	 * 打印16个从0开始的斐波那契数列
	 */
	@Test
	public void test06() {
		int f = 0;
		int g = 1;
		for (int i = 0; i <= 15; i++) {
			StdOut.println(f);
			f = f + g;
			g = f - g;
		}
	}

	@Test
	public void test07() {
		double t = 9.0;
		while (Math.abs(t - 9.0 / t) > .001)
			t = (9.0 / t + t) / 2.0;
		StdOut.printf("%.5f\n", t);
	}

	@Test
	public void test14() {
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println((int) (Integer.MAX_VALUE + 0.5));
//		int N = (int) (Math.random() * Integer.MAX_VALUE + 1); // 生成大于等于1的随机整数
		int N = (int) (Math.random() * 10000 + 1); // 生成大于等于1的随机整数
		System.out.println("N: " + N);
		int x = 0;
		long fx = 1;
		while (fx <= N) {
			x++;
			fx *= 2;
		}
		System.out.println("maxInt(x <= log2(N)): " + --x);
		System.out.println("true result by Math lib: " + (int) (Math.log10(N) / Math.log10(2)));
	}
	
	@Test
	public void test15() {
		int N = 30;
		int M = 10;
		int[] a = new int[N];
		
		for (int i = 0; i < N; i++) 
			a[i] = StdRandom.uniform(M);
		
		for (int i = 0; i < a.length; i++)
			StdOut.printf("%2d", a[i]);
		
		int[] r = histogram(a, M);
		StdOut.println();
		for (int i = 0; i < r.length; i++) {
			StdOut.printf("%d:%-3d", i, r[i]);
		}
	}
	
	public static int[] histogram(int[] a, int M) {
//		int[] ii = new int[10];
//		System.out.println(ii[2]);
		int[] r = new int[M];
		for (int i = 0; i < a.length; i++) {
			if (a[i] <= M - 1 && a[i] >= 0) {
				r[a[i]]++;
			}
		}
		return r; 
	}
	
	@Test
	public void test20() {
		int N = StdRandom.uniform(1, 10);
		System.out.println(N);
		System.out.println(fN20(N));
	}
	
	public static double fN20(int N) {
		if (N == 1) return 0;
		return Math.log(N) + fN20(N - 1);
	}
	
	
	@Test
	public void test28() {
		// 去除排序数组中的重复元素
		int[] whiteList = new int[20];
//		for (int i : whiteList) { //增强for循环不能用来赋值
//			i = StdRandom.uniform(1, 11);
//		}
		for (int i = 0; i < whiteList.length; i++) {
			whiteList[i] = StdRandom.uniform(1, 11);
		}
		Arrays.sort(whiteList);
		for (int i : whiteList) {
			System.out.print(i + " ");
		}
		System.out.println();
		int[] unique = new int[whiteList.length];
		unique[0] = whiteList[0];
		int i = 1, j = 0;
		while (i < whiteList.length) {
			if (whiteList[i] == unique[j])
				i++;
			else
				unique[++j] = whiteList[i++];
		}
		for (int k = 0; k <= j; k++)
			System.out.print(unique[k] + " ");
	}
	
	
	
	

}
