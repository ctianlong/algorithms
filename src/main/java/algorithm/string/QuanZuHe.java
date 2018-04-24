package algorithm.string;

/**
 * 输入三个字符 a、b、c，则它们的组合有a b c ab ac bc abc。当然我们还是可以借鉴全排列的思路，利用问题分解的思路，最终用递归解决。
 * 不过这里介绍一种比较巧妙的思路 —— 基于位图。
 * 假设原有元素n个，最终的组合结果有2^n - 1. 可以使用n个位，1表示取该元素，0表示不取。 所以a表示001,取ab是011。
 * 001,010,011,100,101,110,111。对应输出组合结果为：a,b,ab,c,ac,bc,abc。
 * 因此可以循环 1~2^n - 1，然后输出对应代表的组合即可。
 * @author ctl
 *
 */
public class QuanZuHe {
	
	public static void main(String[] args) {
		char[] str = "abcd".toCharArray();
		quanZuHe(str);
		
	}
	
	public static void quanZuHe(char[] str) {
		int n = str.length;
		int max = (1 << n) - 1;
		for (int i = 1; i <= max; ++i) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; ++j) {
				if ((i & (1 << j)) != 0) {
					sb.append(str[j]);
				}
			}
			System.out.println(sb);
		}
	}

}
