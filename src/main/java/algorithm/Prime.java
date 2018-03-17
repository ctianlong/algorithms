package algorithm;

/**
 * 素数筛法
 * 
 * @author ctl
 *
 */
public class Prime {

	/**
	 * 返回不大于num的素数个数
	 * 普通筛法，num很大时非常慢
	 * 从2-N^(0.5)试除
	 * @param num
	 * @return
	 */
	public static int normal(int num) {
		int count = 0;
		for (int i = 2; i <= num; i++) {
			int root = (int) Math.sqrt(i);
			int j = 2;
			for (; j <= root; j++) {
				if (i % j == 0) {
					break;
				}
			}
			if (j - root > 0) {
				count++;
			}
		}
		return count;
	}

	/**
	 * 埃拉托斯特尼筛法（简称埃氏筛或爱氏筛）：要得到自然数n以内的全部素数，必须把不大于 根号n 的所有素数的倍数剔除，剩下的就是素数。
	 * 例如：给出要筛数值的范围n，找出以内的素数。
	 * 解法：先用2去筛，即把2留下，把2的倍数剔除掉；再用下一个质数，也就是3筛，把3留下，把3的倍数剔除掉；接下去用下一个质数5筛，把5留下，把5的倍数剔除掉；不断重复下去......。
	 * 
	 * 时间复杂度：O(nloglogn) 不足之处：6 在 i = 2 时被标记，而在 i = 3
	 * 时，又被标记了一次。存在重复标记，有优化空间
	 */
	private static int Eratosthenes(int num) {
		boolean[] check = new boolean[num + 1];
		check[0] = true;
		check[1] = true;
		int count = 0;
		int limit = (int) Math.sqrt(num);
		for (int i = 2; i <= limit; i++) {
			// 检查i是否是素数
			if (!check[i]) {
				// 如果i是素数，剔除 i 的倍数
				for (int j = i * i; j <= num; j += i) {
					check[j] = true;
				}
			}
		}
		for (boolean i: check) {
			if (!i) {
				count++;
			}
		}
		return count;
	}

	/**
	 * 欧拉筛法：保证每个合数只会被它的最小质因数筛掉，时间复杂度降低到O(n)。 每一个数都去乘以当前素数表里面已有的数，当 i 是合数，且
	 * i % primes[j] == 0 时，只能乘以第一个素数 2
	 */
	private static int Euler(int num) {
		boolean[] check = new boolean[num + 1];
		int[] primes = new int[num];
		int count = 0;
		for (int i = 2; i <= num; i++) {
			if (!check[i]) {
				primes[count++] = i;
			}
			// 每一个数都去乘以当前素数表里面已有的数，如果 i 是合数，且 i % primeList[j] ==
			// 0，那么它只能乘以第一个素数 2
			// 如：2×2、3×(2、3)、4×(2)、5×(2、3、5)、6×(2)、7×(2、3、5、7)、8×(2)、9×(2、3)、10×(2)
			for (int j = 0; j < count; j++) {
				int next = i * primes[j];
				// 过大的时候跳出
				if (next - num > 0) {
					break;
				}
				check[next] = true;
				// 如果 i 是一个合数，而且 i % primeList[j] == 0
				// 保证了每个合数只会被它的最小素因子筛掉
				if (i % primes[j] == 0) {
					break;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int n = 200000000; // 两百万，一亿
		
		// n 较大时，试除法耗时太长
		long start = System.currentTimeMillis();
//		System.out.println(normal(n));
		long end = System.currentTimeMillis();
//		System.out.println("试除法，耗时：" + (end - start) + " ms");
		
		start = System.currentTimeMillis();
		System.out.println(Eratosthenes(n));
		end = System.currentTimeMillis();
		System.out.println("埃氏筛，耗时：" + (end - start) + " ms");

		start = System.currentTimeMillis();
		System.out.println(Euler(n));
		end = System.currentTimeMillis();
		System.out.println("欧拉筛，耗时：" + (end - start) + " ms");
	}

}
