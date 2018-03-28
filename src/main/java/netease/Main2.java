package netease;

import java.util.Scanner;

/**
 * 条件：1<=x,y<=n; x%y>=k; 0<=k<n-1; 1<=n<=100000
 * 求x,y数对有多少个
 * 网易2018春招（2019实习） https://www.nowcoder.com/discuss/70736?type=0&order=0&pos=14&page=1
 * @author ctl
 *
 */
public class Main2 {
	public static void main(String[] args) {
        
    }
	
	/**
	 * 从y开始枚举，每次枚举中都可以用数学推导出满足条件的数对个数 O(n)
	 */
	public static void solution2() {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        if (k == 0)
        	System.out.println(1L * n * n); // 0 特殊考虑, 注意结果为long，int不够
        else {
        	long count = 0; // 注意结果为long，int不够
        	for (int y = k + 1; y <= n; y++) {
        		count += (n / y) * (y - k);
        		int m = n % y;
        		if (m >= k) count += m - k + 1;
        	}
        	System.out.println(count);
        }
	}
	
	/**
	 * 最普通枚举，时间太长 O(n2)
	 */
	public static void solution1() {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int count = 0;
        for (int x = k; x <= n; x++) {
        	for (int y = k + 1; y <= n; y++) {
        		if (x % y >= k) count++;
        	}
        }
        System.out.println(count);
	}
}
